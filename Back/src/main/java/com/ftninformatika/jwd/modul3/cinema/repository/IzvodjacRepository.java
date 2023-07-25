package com.ftninformatika.jwd.modul3.cinema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftninformatika.jwd.modul3.cinema.model.Adresa;
import com.ftninformatika.jwd.modul3.cinema.model.Izvodjac;

public interface IzvodjacRepository extends JpaRepository<Izvodjac, Long> {
	
// Film findOneById(Long id);

	
//	@Query("SELECT t FROM Linija t WHERE" +
//			"(:destinacija = NULL OR t.destinacija LIKE :destinacija) AND " + 
//			"(:prevoznikId = NULL OR t.prevoznik.id = :prevoznikId) AND" +
//			"(:maxCena = NULL OR t.cenaKarte <= :maxCena)")
//		Page<Linija> search(@Param("destinacija") String destinacija, 
//							@Param("prevoznikId") Long prevoznikId, 
//							@Param("maxCena") Double maxCena, 
//							Pageable pageable);
	
	
// ------------------ PRIMERI PRETRAGA --------------------------------------
// ----------------------- 1 ----------------------------------------------

//		@Query("SELECT t FROM Task t WHERE" +
//				"(:taskName = NULL OR t.name LIKE :taskName) AND " + 
//				"(:sprintId = NULL OR t.sprint.id = :sprintId)")
//		Page<Task> search(@Param("taskName") String taskName, @Param("sprintId") Long sprintId, Pageable pageable);

// ----------------------- 2 ----------------------------------------------

//		@Query("SELECT COALESCE(SUM(t.points),0) FROM Task t WHERE t.sprint.id = :sprintId")
//		Long sumPoints(Long sprintId);	

// ----------------------- 3 ----------------------------------------------

//		 List<Film> findByZanroviId(Long zanrId);

//		 List<Film> findByNazivIgnoreCaseContainsAndTrajanjeBetweenAndZanroviId(String naziv,Integer trajanjeOd,Integer trajanjeDo,Long zanrId);

//		 List<Film> findByNazivIgnoreCaseContainsAndTrajanjeBetween(String naziv,Integer trajanjeOd,Integer trajanjeDo);	

// ----------------------- 4 ----------------------------------------------
// Page<Projekcija>
// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLike(LocalDateTime
// datumIVremeOd,LocalDateTime datumIVremeDo,
// Double cenaKarteOd,Double cenaKarteDo,String tip, Pageable pageable);

	// Page<Projekcija>
	// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndFilmId(LocalDateTime
	// datumIVremeOd,LocalDateTime datumIVremeDo,
//	            Double cenaKarteOd,Double cenaKarteDo,String tip,Long filmId, Pageable pageable);
	//
	// Page<Projekcija>
	// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndSala(LocalDateTime
	// datumIVremeOd,LocalDateTime datumIVremeDo,
//	                     Double cenaKarteOd,Double cenaKarteDo,String tip,Integer sala, Pageable pageable);
	//
	// Page<Projekcija>
	// findByDatumIVremeBetweenAndCenaKarteBetweenAndTipLikeAndFilmIdAndSala(LocalDateTime
	// datumIVremeOd,LocalDateTime datumIVremeDo,
//	                     Double cenaKarteOd,Double cenaKarteDo,String tip,Long filmId,Integer sala, Pageable pageable);
	// List<Projekcija> findByFilmId(Long filmId);

// ----------------------- 5 ----------------------------------------------

//		List<Zanr> findByNazivIgnoreCaseContains(String naziv);
	
	// List<Zanr> findByIdIn(List<Long> ids);

// ----------------------- 6 ----------------------------------------------

//		@Query("SELECT t FROM Linija t WHERE" +
//				"(:destinacija = NULL OR t.destinacija LIKE CONCAT('%',LOWER(:destinacija), '%')) AND " + 
//				"(:prevoznikId = NULL OR t.prevoznik.id = :prevoznikId) AND " +
//				"(:maxCena = NULL OR t.cenaKarte <= :maxCena)")	
//		Page<Linija> search(@Param("destinacija") String destinacija,
//							@Param("prevoznikId") Long prevoznikId,
//							@Param("maxCena") Double maxCena,
//							Pageable pageable);	

// ----------------------- 7 ----------------------------------------------
//	List<User> findByName(String name);
//	List<User> findByNameIs(String name);
//	List<User> findByNameEquals(String name);
//	List<User> findByNameIsNot(String name);
//	List<User> findByNameIsNull();
//	List<User> findByNameIsNotNull();
//	List<User> findByActiveTrue();
//	List<User> findByActiveFalse();
//	List<User> findByNameStartingWith(String prefix);
//	List<User> findByNameEndingWith(String suffix);
//	List<User> findByNameContaining(String infix);
//	////////////////////////////////////////////
//	List<User> findByNameLike(String likePattern);
//	String likePattern = "a%b%c";
//	userRepository.findByNameLike(likePattern);
//	////////////////////////////////////////////
//	List<User> findByAgeLessThan(Integer age);
//	List<User> findByAgeLessThanEqual(Integer age);
//	List<User> findByAgeGreaterThan(Integer age);
//	List<User> findByAgeGreaterThanEqual(Integer age);
//	List<User> findByAgeBetween(Integer startAge, Integer endAge);
//	List<User> findByAgeIn(Collection<Integer> ages);
//	List<User> findByBirthDateAfter(ZonedDateTime birthDate);
//	List<User> findByBirthDateBefore(ZonedDateTime birthDate);
//	List<User> findByNameOrAge(String name, Integer age);
//	List<User> findByNameOrAgeAndActive(String name, Integer age, Boolean active);
//	List<User> findByNameOrderByName(String name);
//	List<User> findByNameOrderByNameAsc(String name);
//	List<User> findByNameOrderByNameDesc(String name);
//	////////////////////////////////////////////
//	User findFirstByIdOrderByPointPointsDesc(int userId);
//	////////////////////////////////////////////
//	Passenger findFirstByOrderBySeatNumberAsc();
//	Passenger findTopByOrderBySeatNumberAsc();
//	////////////////////////////////////////////
//	Optional<Passenger> findFirstByOrderBySeatNumberAsc();
//	Optional<Passenger> findTopByOrderBySeatNumberAsc();
//	////////////////////////////////////////////
//	Page<Passenger> page = repository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "seatNumber")));
//	////////////////////////////////////////////
//	Optional<Dog> findById(Long id);
//	Optional<Dog> readById(Long id);
//	Optional<Dog> getById(Long id);
//	Optional<Dog> queryById(Long id);
//	////////////////////////////////////////////
//	List<Dog> findByAgeAndHeight(Integer age, Double height);
//	List<Dog> findByAgeAndNameAndColor(Integer age, String name, String color);
//	List<Dog> findByNameOrAge(String name, Integer age);
//	List<Dog> findByNameIgnoreCaseAndColor(String name, String color);
//	////////////////////////////////////////////
//	Integer countByName(String name);
//	Integer countByNameAndLastName(String name, String lastName);
//	////////////////////////////////////////////
//	Dog findFirstByName(String name);
//	Dog findTopByName(String name);
//	List<Dog> findTop10ByColor(String color);
//	////////////////////////////////////////////
//	Dog findTopByOrderByBirthDateDesc();
//	////////////////////////////////////////////
//	List<Dog> findByNameContaining(String subName);
//	List<Dog> findByNameStartingWith(String subName);
//	////////////////////////////////////////////
//	List<Dog> findByHeightLessThan(double height);
//	List<Dog> findByAgeLessThanOrHeightGreaterThan(Integer age, double height);
//	List<Dog> findByAgeGreaterThanAndAgeLessThan(Integer ageStart, Integer ageEnd);
//	List<Dog> findByAgeGreaterThanEqual(Integer age);
//	List<Dog> findByDateOfBirthBetween(Date start, Date end);
//	////////////////////////////////////////////
//	List<Employee> findByNameAndAddressZipCode(Integer zipCode);
//	List<Employee> findByNameAndAddress_ZipCode(Integer zipCode);
//	////////////////////////////////////////////
	

}
