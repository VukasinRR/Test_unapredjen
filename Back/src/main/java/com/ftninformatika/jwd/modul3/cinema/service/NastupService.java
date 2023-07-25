package com.ftninformatika.jwd.modul3.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.cinema.model.Nastup;
import com.ftninformatika.jwd.modul3.cinema.web.dto.NastupDTO;

public interface NastupService {

	 Optional<Nastup> findOne(Long id);// BOLJE OVO
	 Page<Nastup> findAll(Integer pageNo); // PAGINIRANO
	 Nastup save(NastupDTO nastup); // SALJE DTO
	 Nastup update(Nastup nastup);
	 Nastup delete(Long id);
	Page<Nastup> search(Long festivalId, Long izvodjacId, int pageNum);	

	//ZA PRETRAGE
//	Page<Zadatak> search(String zadatakIme, Long sprintId, int pageNum);
	
	//ZA REZERVACIJU
//	Linija rezervacija(Long id);	
	
	//ZA PROMENE STANJA
//	Zadatak prelazak(Long id);
	
	//ZA PROMENE BODOVA,SUMA,ITD
//	Long sumPoints(Long sprintId);
	
	
	

	
	
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
