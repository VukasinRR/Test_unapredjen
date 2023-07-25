package com.ftninformatika.jwd.modul3.cinema.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.cinema.model.Festival;



public interface FestivalService {
	
	 Optional<Festival> findOne(Long id);// BOLJE OVO
	 List<Festival> findAll(); // NE PAGINIRANO
	 Festival save(Festival festival); // SALJE ENTITET

	
	

//-------------- OSNOVNE -----------------------
//	 Projekcija findOne(Long id);
//	 
//	 Optional<Linija> findOne(Long id);// BOLJE OVO
//----------------------------------------------------
//	 Page<Projekcija> findAll(Integer pageNo); // PAGINIRANO
//	 
//	 List<Sprint> all(); // NE PAGINIRANO
//----------------------------------------------------
//	 Projekcija save(Projekcija projekcija); // SALJE ENTITET
//	 
//	 Linija save(LinijaDTO linija); // SALJE DTO
//----------------------------------------------------
//	 Projekcija update(Projekcija projekcija);
//----------------------------------------------------
//	 Projekcija delete(Long id);	
//-------------- PRETRAGE -----------------------
//	 Page<Linija> search(String destinacija, Long prevoznikId, Double maxCena, int pageNum);
//	 Page<Task> search(String imeZadatka, Long idSprinta, int pageNum);
//	 List<Film> find(String naziv, Long zanrId, Integer trajanjeOd, Integer trajanjeDo);
//	 List<Film> findByZanrId(Long zanrId);
//	 Page<Projekcija> find(LocalDateTime datumIVremeOd, LocalDateTime datumIVremeDo, Long filmId, String tip, Integer sala, Double cenaKarteOd, Double cenaKarteDo, Integer pageNo);
//	 List<Projekcija> findByFilmId(Long filmId);
	
//-------------- POSEBNI ZADATAK -----------------------
	
//	Task prelazak(Long id); // promena stanja
//	Long sumPoints(Long sprintId);	// sabiranje
	
	
	
	
	


}
