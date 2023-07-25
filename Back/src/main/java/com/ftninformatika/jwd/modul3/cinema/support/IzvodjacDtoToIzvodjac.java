package com.ftninformatika.jwd.modul3.cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Izvodjac;
import com.ftninformatika.jwd.modul3.cinema.model.Festival;
import com.ftninformatika.jwd.modul3.cinema.service.IzvodjacService;
import com.ftninformatika.jwd.modul3.cinema.service.NastupService;
import com.ftninformatika.jwd.modul3.cinema.service.FestivalService;
import com.ftninformatika.jwd.modul3.cinema.web.dto.IzvodjacDTO;

@Component
public class IzvodjacDtoToIzvodjac implements Converter<IzvodjacDTO, Izvodjac>{

	
	@Autowired
	private IzvodjacService izvodjacService;
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private NastupService nastupService;

	@Override
	public Izvodjac convert(IzvodjacDTO source) {

		Long id = source.getId();
		Izvodjac izvodjac = id == null ? new Izvodjac() : izvodjacService.findOne(id).get();
//		Linija linija = id == null ? new Linija() : new Linija(linijaService.findOne(id).get());	
//      Linija linija = new Linija();
		
		izvodjac.setId(source.getId());
		izvodjac.setIme(source.getIme());
		izvodjac.setZanr(source.getZanr());
		izvodjac.setDrzava(source.getDrzava());
		izvodjac.setBrojClanova(source.getBrojClanova());
					
		
		return izvodjac;
		
		
		
	
	}
	
//	@Override
//	public Linija convert(LinijaDTO source) {
//		
//		Prevoznik prevoznik = null;
//		if(source.getPrevoznikId() != null) {
//			prevoznik = prevoznikService.findOne(source.getPrevoznikId()).get();
//		}
////		ZA JOS POVEZANIH ENTITETA AKO IMA
////		State state = null; 
////		if(source.getId() != null) {
////			state = stanjeService.one(source.getStateId()).get();
////		}
//		
//		if(prevoznik!=null) {
//	//      JEDNA OD OVE 3 VARIJANTE CE RADITI  		
//			Long id = source.getId();
//			Linija linija = id == null ? new Linija() : linijaService.findOne(id).get();
//	//		Linija linija = id == null ? new Linija() : new Linija(linijaService.findOne(id).get());	
//	//      Linija linija = new Linija();
//			
//			linija.setId(source.getId());
//			linija.setBrojMesta(source.getBrojMesta());
//			linija.setCenaKarte(source.getCenaKarte());
//			linija.setVremePolaska(source.getVremePolaska());
//			linija.setDestinacija(source.getDestinacija());
//			linija.setPrevoznik(prevoznik);
//				
//				// Zbog 3. zadatka - stanje ne mora da se dodaje na početku
////				if(state != null) {
////					task.setState(state);	
////				}
//			
//			
//			return linija;
//			
//		}else {
//			throw new IllegalStateException("Trying to attach to non-existant entities");
//		}
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
	
	
//		@Override
//	    public Projekcija convert(ProjekcijaDTO dto) {
//	        Projekcija projekcija;
	//
//	        if(dto.getId() == null){
//	            projekcija = new Projekcija();
//	        }else{
//	            projekcija = projekcijaService.findOne(dto.getId());
//	        }
	//
//	        if(projekcija != null){
//	            projekcija.setDatumIVreme(getLocalDateTime(dto.getDatumIVreme()));
//	            projekcija.setFilm(filmService.findOne(dto.getFilm().getId()));
//	            projekcija.setSala(dto.getSala());
//	            projekcija.setTip(dto.getTip());
//	            projekcija.setCenaKarte(dto.getCenaKarte());
//	        }
//	        return projekcija;
//	    }	
//-----------------------POVEZANI + POSEBAN ZADATAK----------------------------------	
//		@Override
//		public Task convert(TaskDto source) {
	//
//			Sprint sprint = null;
//			if(source.getSprintId() != null) {
//				sprint = sprintService.one(source.getSprintId()).get();
//			}
//			
//			State state = null;
//			if(source.getId() != null) {
//				state = stanjeService.one(source.getStateId()).get();
//			}
//			
//			if(sprint!=null) {
//				
//				Long id = source.getId();
//				Task task = id == null ? new Task() : zadatakService.one(id).get();
//				//Task task = id == null ? new Task() : new Task(zadatakService.one(id).get());
//				
//					task.setId(source.getId());
//					task.setName(source.getName());
//					task.setPoints(source.getPoints());
//					task.setEmployee(source.getEmployee());
//					
//					task.setSprint(sprint);
//					
//					// Zbog 3. zadatka - stanje ne mora da se dodaje na početku
//					if(state != null) {
//						task.setState(state);	
//					}
//				
//				
//				return task;
//				
//			}else {
//				throw new IllegalStateException("Trying to attach to non-existant entities");
//			}
//			
//		}
		
//----------------------MANY TO MANY--------------------------------	
//		@Override
//		    public Film convert(FilmDTO dto) {
	//
//		        Film entity;
	//
//		        if(dto.getId() == null) {
//		            entity = new Film();
//		        }else {
//		            entity = filmService.findOne(dto.getId());
//		        }
	//
//		        if(entity != null) {
//		            entity.setNaziv(dto.getNaziv());
//		            entity.setTrajanje(dto.getTrajanje());
//		            
//		            if(dto.getZanrovi() != null) {
//		            	List<Long> idZanrova = dto.getZanrovi().stream().map(ZanrDTO::getId).collect(Collectors.toList());
//		                List<Zanr> zanrovi = zanrService.find(idZanrova);
//		                entity.setZanrovi(new HashSet<>(zanrovi));
//		            }
//		        }
	//
//		        return entity;
//--------------------------------------------------------------					
//-----------------------DATUM FORMATER--------------------------------------	

//		private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
//			LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
//			return LocalDateTime.of(datum, vreme);
//		}
//--------------------------------------------------------------	
					
		

}
