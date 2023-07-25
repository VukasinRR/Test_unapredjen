package com.ftninformatika.jwd.modul3.cinema.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftninformatika.jwd.modul3.cinema.model.Nastup;

public interface NastupRepository extends JpaRepository<Nastup, Long>{
	
	
	// Film findOneById(Long id);
//	Page<Nastup> search( Long festivalId,  Long izvodjacId, Pageable pageable);

	@Query("SELECT t FROM Nastup t WHERE" +
	"(:festivalId = NULL OR t.festival.id LIKE :festivalId) AND " + 
	"(:izvodjacId = NULL OR t.izvodjac.id = :izvodjacId)")
	Page<Nastup> search(@Param("festivalId") Long festivalId, 
						@Param("izvodjacId") Long izvodjacId, 
						 Pageable pageable);
	
//	Page<Nastup> findByFestivalIDOIzvodjacId(Long festivalId, Long izvodjacId);

	
	// ------------------ PRIMERI PRETRAGA --------------------------------------
	// ----------------------- 1 ----------------------------------------------

//			@Query("SELECT t FROM Task t WHERE" +
//					"(:taskName = NULL OR t.name LIKE :taskName) AND " + 
//					"(:sprintId = NULL OR t.sprint.id = :sprintId)")
//			Page<Task> search(@Param("taskName") String taskName, @Param("sprintId") Long sprintId, Pageable pageable);

	// ----------------------- 2 ----------------------------------------------

//			@Query("SELECT COALESCE(SUM(t.points),0) FROM Task t WHERE t.sprint.id = :sprintId")
//			Long sumPoints(Long sprintId);	

	// ----------------------- 3 ----------------------------------------------

//			 List<Film> findByZanroviId(Long zanrId);

//			 List<Film> findByNazivIgnoreCaseContainsAndTrajanjeBetweenAndZanroviId(String naziv,Integer trajanjeOd,Integer trajanjeDo,Long zanrId);

//			 List<Film> findByNazivIgnoreCaseContainsAndTrajanjeBetween(String naziv,Integer trajanjeOd,Integer trajanjeDo);	

	// ----------------------- 4 ----------------------------------------------
	// Page<Projekcija>
	// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLike(LocalDateTime
	// datumIVremeOd,LocalDateTime datumIVremeDo,
	// Double cenaKarteOd,Double cenaKarteDo,String tip, Pageable pageable);

		// Page<Projekcija>
		// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndFilmId(LocalDateTime
		// datumIVremeOd,LocalDateTime datumIVremeDo,
//		            Double cenaKarteOd,Double cenaKarteDo,String tip,Long filmId, Pageable pageable);
		//
		// Page<Projekcija>
		// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndSala(LocalDateTime
		// datumIVremeOd,LocalDateTime datumIVremeDo,
//		                     Double cenaKarteOd,Double cenaKarteDo,String tip,Integer sala, Pageable pageable);
		//
		// Page<Projekcija>
		// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndFilmIdAndSala(LocalDateTime
		// datumIVremeOd,LocalDateTime datumIVremeDo,
//		                     Double cenaKarteOd,Double cenaKarteDo,String tip,Long filmId,Integer sala, Pageable pageable);
		// List<Projekcija> findByFilmId(Long filmId);

	// ----------------------- 5 ----------------------------------------------

//			List<Zanr> findByNazivIgnoreCaseContains(String naziv);
		
		// List<Zanr> findByIdIn(List<Long> ids);

	// ----------------------- 6 ----------------------------------------------

//			@Query("SELECT t FROM Linija t WHERE" +
//					"(:destinacija = NULL OR t.destinacija LIKE CONCAT('%',LOWER(:destinacija), '%')) AND " + 
//					"(:prevoznikId = NULL OR t.prevoznik.id = :prevoznikId) AND " +
//					"(:maxCena = NULL OR t.cenaKarte <= :maxCena)")	
//			Page<Linija> search(@Param("destinacija") String destinacija,
//								@Param("prevoznikId") Long prevoznikId,
//								@Param("maxCena") Double maxCena,
//								Pageable pageable);	

	// ----------------------- 7 ----------------------------------------------	
	
	
	
	
	
	
}
