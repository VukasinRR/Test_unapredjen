package com.ftninformatika.jwd.modul3.cinema.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Adresa;
import com.ftninformatika.jwd.modul3.cinema.model.Izvodjac;
import com.ftninformatika.jwd.modul3.cinema.model.Festival;
import com.ftninformatika.jwd.modul3.cinema.service.IzvodjacService;
import com.ftninformatika.jwd.modul3.cinema.service.NastupService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.FestivalDTO;
import com.ftninformatika.jwd.modul3.cinema.service.FestivalService;


@Component
public class FestivalDtoToFestival implements  Converter<FestivalDTO, Festival>{

	@Autowired
    private FestivalService festivalService;
	
	@Autowired
    private IzvodjacService izvodjacService;//POVEZANI ENTITET
	
	@Autowired
	private NastupService nastupService;

	@Override
	public Festival convert(FestivalDTO source) {
		Festival festival = new Festival();
		
		festival.setId(source.getId());
		festival.setNaziv(source.getNaziv());
	
		return festival;
	}
	
//	@Override
//	public Prevoznik convert(PrevoznikDTO source) {
//		Prevoznik prevoznik = new Prevoznik();
//		
//		prevoznik.setId(source.getId());
//		prevoznik.setNaziv(source.getNaziv());
//		prevoznik.setAdresa(source.getAdresa());
//		prevoznik.setPib(source.getPib());
//
//		return prevoznik;
//	}
	
	
//-----------------------METODE----------------------------------	
//-----------------------OBICNA----------------------------------	
	
	
//	@Override//bez poveznih entiteta
//	public Prevoznik convert(PrevoznikDTO source) {
//		Prevoznik prevoznik = new Prevoznik();
//		
//		prevoznik.setId(source.getId());
//		prevoznik.setNaziv(source.getNaziv());
//		prevoznik.setAdresa(source.getAdresa());
//		prevoznik.setPib(source.getPib());
//
//		return prevoznik;
//	}
	
	
	
	
	
//	@Override
//    public Projekcija convert(ProjekcijaDTO dto) {
//        Projekcija projekcija;
//
//        if(dto.getId() == null){
//            projekcija = new Projekcija();
//        }else{
//            projekcija = projekcijaService.findOne(dto.getId());
//        }
//
//        if(projekcija != null){
//            projekcija.setDatumIVreme(getLocalDateTime(dto.getDatumIVreme()));
//            projekcija.setFilm(filmService.findOne(dto.getFilm().getId()));
//            projekcija.setSala(dto.getSala());
//            projekcija.setTip(dto.getTip());
//            projekcija.setCenaKarte(dto.getCenaKarte());
//        }
//        return projekcija;
//    }	
//-----------------------POVEZANI + POSEBAN ZADATAK----------------------------------	
//	@Override
//	public Task convert(TaskDto source) {
//
//		Sprint sprint = null;
//		if(source.getSprintId() != null) {
//			sprint = sprintService.one(source.getSprintId()).get();
//		}
//		
//		State state = null;
//		if(source.getId() != null) {
//			state = stanjeService.one(source.getStateId()).get();
//		}
//		
//		if(sprint!=null) {
//			
//			Long id = source.getId();
//			//Task task = id == null ? new Task() : zadatakService.one(id).get();
//			Task task = id == null ? new Task() : new Task(zadatakService.one(id).get());
//			
//				task.setId(source.getId());
//				task.setName(source.getName());
//				task.setPoints(source.getPoints());
//				task.setEmployee(source.getEmployee());
//				
//				task.setSprint(sprint);
//				
//				// Zbog 3. zadatka - stanje ne mora da se dodaje na početku
//				if(state != null) {
//					task.setState(state);	
//				}
//			
//			
//			return task;
//			
//		}else {
//			throw new IllegalStateException("Trying to attach to non-existant entities");
//		}
//		
//	}
	
//----------------------MANY TO MANY--------------------------------	
//	@Override
//	    public Film convert(FilmDTO dto) {
//
//	        Film entity;
//
//	        if(dto.getId() == null) {
//	            entity = new Film();
//	        }else {
//	            entity = filmService.findOne(dto.getId());
//	        }
//
//	        if(entity != null) {
//	            entity.setNaziv(dto.getNaziv());
//	            entity.setTrajanje(dto.getTrajanje());
//	            
//	            if(dto.getZanrovi() != null) {
//	            	List<Long> idZanrova = dto.getZanrovi().stream().map(ZanrDTO::getId).collect(Collectors.toList());
//	                List<Zanr> zanrovi = zanrService.find(idZanrova);
//	                entity.setZanrovi(new HashSet<>(zanrovi));
//	            }
//	        }
//
//	        return entity;
//--------------------------------------------------------------					
//-----------------------DATUM FORMATER--------------------------------------	

//	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
//		LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
//		return LocalDateTime.of(datum, vreme);
//	}
//--------------------------------------------------------------	
			

}
