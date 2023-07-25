package com.ftninformatika.jwd.modul3.cinema.service.impl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.cinema.model.Festival;
import com.ftninformatika.jwd.modul3.cinema.model.Izvodjac;
import com.ftninformatika.jwd.modul3.cinema.model.Nastup;
import com.ftninformatika.jwd.modul3.cinema.repository.FestivalRepository;
import com.ftninformatika.jwd.modul3.cinema.repository.IzvodjacRepository;
import com.ftninformatika.jwd.modul3.cinema.repository.NastupRepository;
import com.ftninformatika.jwd.modul3.cinema.service.NastupService;
import com.ftninformatika.jwd.modul3.cinema.support.NastupDtoToNastup;
import com.ftninformatika.jwd.modul3.cinema.web.dto.NastupDTO;

@Service
@Transactional
public class JpaNastupService implements NastupService {

	
	@Autowired
	private NastupDtoToNastup toEntity;
	
	@Autowired
	private NastupRepository Repository;
	
	@Autowired
	private FestivalRepository festivalRepository;//Repository povezane klase
	
	@Autowired
	private IzvodjacRepository izvodjacRepository;//Repository povezane klase

	@Override
	public Optional<Nastup> findOne(Long id) {
		return Repository.findById(id);
	}

	@Override
	public Page<Nastup> findAll(Integer pageNo) {
		return Repository.findAll(PageRequest.of(pageNo, 5));
	}
	
	@Override
	public Nastup update(Nastup nastup) {
		return Repository.save(nastup);
	}
	
	@Override
	public Nastup save(NastupDTO nastupDto) {
		Nastup nastup = toEntity.convert(nastupDto);


////		SLUZI ZA RAZVEZIVANJE SA POVEZANOM KLASOM - u povezanoj klasi moramo napraviti metodu brisi preko id
			if (nastupDto.getId() != null) { // Trebalo bi da postoji u bazi
				Optional<Nastup> oldnastupOptional = findOne(nastupDto.getId());
				if (oldnastupOptional.isPresent()) {
					Nastup oldNastup = oldnastupOptional.get();
					Festival oldFestival = oldNastup.getFestival();
					oldFestival.removeNastupById(nastupDto.getId());
					festivalRepository.save(oldFestival);
					
					Izvodjac oldIzvodjac = oldNastup.getIzvodjac();
					oldIzvodjac.removeNastupById(nastupDto.getId());
					izvodjacRepository.save(oldIzvodjac);
				}
			}
	
			Festival festival = nastup.getFestival();
			festival.dodajNastup(nastup);
//			festivalRepository.save(festival);

			
			Izvodjac izvodjac = nastup.getIzvodjac();
			izvodjac.dodajNastup(nastup);
//			izvodjacRepository.save(izvodjac);


			Nastup savedNastup = Repository.save(nastup);

			return savedNastup;
		
		
		
		
	}

	

	@Override
	public Nastup delete(Long id) {
		Optional<Nastup> nastup = Repository.findById(id);
		Nastup n = nastup.get();
		if(n != null){
			Festival festival = n.getFestival();
			festival.removeNastupById(n.getId());
			festivalRepository.save(festival);
			n.getFestival().getNastupi().remove(n);
			
			Izvodjac izvodjac = n.getIzvodjac();
			izvodjac.removeNastupById(n.getId());
			izvodjacRepository.save(izvodjac);
			n.getIzvodjac().getNastupi().remove(n);
			
//			lin.setPrevoznik(null); //mozda pravi gresku
//			n = Repository.save(n);
			Repository.deleteById(n.getId());
	            return n;
	        }
	        return null;
	}

	@Override
	public Page<Nastup> search(Long festivalId, Long izvodjacId, int pageNum) {
		return Repository.search(festivalId, izvodjacId,PageRequest.of(pageNum, 5));
	}

	

}

//--------------------METODE--------------------------------------------	
//--------------------FIND ONE------------------------------------------------	
//	@Override
//	public Film findOne(Long id) {
//		return BBBRepository.findOneById(id);
//	}
//	
//	@Override//BOLJE OVA UGRADJENA
//	public Optional<Linija> findOne(Long id) {
//		return BBBRepository.findById(id);
//	}
//--------------------FIND ALL----------------------------------------------	
//	@Override//PAGINIRANO
//	public Page<Linija> findAll(Integer pageNo) {
//		return BBBRepository.findAll(PageRequest.of(pageNo, 5));
//	}
//
//	@Override//NEPAGINIRANO
//	public List<Film> findAll() {
//		return BBBRepository.findAll();
//	}
//--------------------UPDATE--------------------------------------------------	
//	@Override
//	public Linija update(Linija linija) {
//		return BBBRepository.save(linija);
//	}
//-------------------SAVE------------------------------------------------	
//	@Override
//	public Projekcija save(Projekcija projekcija) {
//		return BBBRepository.save(projekcija);
//	}
//------------------KAD SALJE DTO-------------------------------------------------------	
//	@Override
//	public Task save(TaskDto taskDto) {
//				
//		Task task = toBBB.convert(taskDto);
//		if(task.getId() == null) {
//			// Zbog 3. zadatka, podešavamo stanje na "nov",
//			// ako još uvek ne postoji u bazi
//			State newState = stateRepository.findById(1L).get();
//			task.setState(newState);
//		}
//
//		if(taskDto.getId() != null) { // Trebalo bi da postoji u bazi
//			Optional<Task> oldTaskOptional = one(taskDto.getId());
//			if(oldTaskOptional.isPresent()) {
//				Task oldTask = oldTaskOptional.get();
//				Sprint oldSprint = oldTask.getSprint();
//				oldSprint.removeTask(taskDto.getId());
//				sprintRepository.save(oldSprint);
//			}
//		}
//			
//		Sprint sprint = task.getSprint();
//		sprint.addTask(task);
//		Task savedTask = taskRepository.save(task);
//		sprintRepository.save(sprint);
//		return savedTask;
//	}
	
//------------------DELETE-------------------------------------------------------	
//@Override
////Kada se obrise film obrisace se i sve projekcije koje su vezane za taj film
//public Film delete(Long id) {
//    Optional<Film> film = filmRepository.findById(id);
//    if(film.isPresent()){
//        filmRepository.deleteById(id);
//        return film.get();
//    }
//    return null;
//}
//-----------------SA POVEZANIM ENTITETIMA-----------------------------------------------	
//@Override
//public Projekcija delete(Long id) {
//    Projekcija projekcija = findOne(id);
//    if(projekcija != null){
//        projekcija.getFilm().getProjekcije().remove(projekcija);
//        projekcija.setFilm(null);
//        projekcija = projekcijaRepository.save(projekcija);
//        projekcijaRepository.delete(projekcija);
//        return projekcija;
//    }
//    return null;
//}	

//------------------SA POVEZANIM ENTITETIMA- POSEBAN ZADATAK--------------------------------------------	
//@Override
//@Transactional
//public Task delete(Long id) {
//	Optional<Task> taskOptional = taskRepository.findById(id);
//	if(taskOptional.isPresent()) {
//		Task task = taskOptional.get();
//		
//		Sprint sprint = task.getSprint();
//		Integer newSprintPoints = Integer.parseInt(sprint.getPoints()) - task.getPoints();
//		sprint.setPoints(newSprintPoints + "");
//		
//		sprint.removeTask(task.getId());
//		State state = task.getState();
//		state.removeTask(task.getId());
//		
//		stateRepository.save(state);
//		sprintRepository.save(sprint);
//		taskRepository.deleteById(id);
//		return task;
//	}
//	
//	return null;
//}
//------------------SEARCH---------------------------------------------------	
//@Override
//public Page<Linija> search(String destinacija, Long prevoznikId,Double maxCena, int pageNum) {
//	if(destinacija != null) {
//		destinacija = "%" + destinacija + "%";
//	}
//	
//	
//	return linijaRepository.search(destinacija, prevoznikId, maxCena, PageRequest.of(pageNum, 2));
//}	
//------------------------------------------------------------------------------	
//@Override
//public List<Film> find(String naziv, Long zanrId, Integer trajanjeOd, Integer trajanjeDo) {
//    if (naziv == null) {
//        naziv = "";
//    }
//
//    if (trajanjeOd == null) {
//        trajanjeOd = 0;
//    }
//
//    if (trajanjeDo == null) {
//        trajanjeDo = Integer.MAX_VALUE;
//    }
//
//    if(zanrId == null){
//        return filmRepository.findByNazivIgnoreCaseContainsAndTrajanjeBetween(naziv,trajanjeOd,trajanjeDo);
//    }
//    return filmRepository.findByNazivIgnoreCaseContainsAndTrajanjeBetweenAndZanroviId(naziv,trajanjeOd,trajanjeDo,zanrId);
//}
//------------------------------------------------------------------------------	
//@Override
//public List<Film> findByZanrId(Long zanrId) {
//    return filmRepository.findByZanroviId(zanrId);
//}
//------------------------------------------------------------------------------	
//@Override
//public Page<Linija> search(String destinacija, Long prevoznikId,Double maxCena, int pageNum) {
//	if(destinacija != null) {
//		destinacija = "%" + destinacija + "%";
//	}
//	
//	
//	return linijaRepository.search(destinacija, prevoznikId, maxCena, PageRequest.of(pageNum, 2));
//}
//------------------------------------------------------------------------------	
//@Override
//public Page<Projekcija> find(LocalDateTime datumIVremeOd, LocalDateTime datumIVremeDo, Long filmId, String tip, Integer sala,
//                             Double cenaKarteOd, Double cenaKarteDo, Integer pageNo) {
//    if (cenaKarteOd == null) {
//        cenaKarteOd = 0.0;
//    }
//
//    if (cenaKarteDo == null) {
//        cenaKarteDo = Double.MAX_VALUE;
//    }
//
//    if(filmId == null && sala == null){
//        return projekcijaRepository.findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLike(datumIVremeOd,datumIVremeDo,cenaKarteOd,cenaKarteDo,tip,PageRequest.of(pageNo,3));
//    }else if(filmId == null){
//        return projekcijaRepository.findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndSala(datumIVremeOd,datumIVremeDo,cenaKarteOd,cenaKarteDo,tip,sala,PageRequest.of(pageNo,3));
//    }else if(sala == null){
//        return projekcijaRepository.findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndFilmId(datumIVremeOd,datumIVremeDo,cenaKarteOd,cenaKarteDo,tip,filmId,PageRequest.of(pageNo,3));
//    }
//    return projekcijaRepository.findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndFilmIdAndSala(datumIVremeOd,datumIVremeDo,cenaKarteOd,cenaKarteDo,tip,filmId,sala,PageRequest.of(pageNo,3));
//}
//------------------------------------------------------------------------------	
//@Override
//public List<Projekcija> findByFilmId(Long filmId) {
//    return projekcijaRepository.findByFilmId(filmId);
//}
	
//----------POSEBAN ZADATAK-STANJA---------------------------------------------------	
//@Override
//public Task prelazak(Long id) {
//	
//	Task task = taskRepository.getOne(id);
//	if(task != null) {
//		State currentState = task.getState();
//		if(currentState.getId().equals(1L)) {
//			State inProgress = stateRepository.getOne(2L);
//			task.setState(inProgress);
//		}
//		else if(currentState.getId().equals(2L)) {
//			State finished = stateRepository.getOne(3L);
//			task.setState(finished);
//		}
//		
//		return taskRepository.save(task);
//	}
//	
//	return null;
//}
//------------------------------------------------------------------------------	
//@Override
//public Long sumPoints(Long sprintId) {
//	return taskRepository.sumPoints(sprintId);
//}

//----------------DATUM FORMATER-------------------------------------------------	
//private LocalDateTime getDateConverted(String dateTime) throws DateTimeParseException {
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//    return LocalDateTime.parse(dateTime, formatter);
//}
//------------------------------------------------------------------------------	
	