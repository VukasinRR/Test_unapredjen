package com.ftninformatika.jwd.modul3.cinema.web.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ftninformatika.jwd.modul3.cinema.model.Izvodjac;
import com.ftninformatika.jwd.modul3.cinema.service.IzvodjacService;
import com.ftninformatika.jwd.modul3.cinema.support.IzvodjacDtoToIzvodjac;
import com.ftninformatika.jwd.modul3.cinema.support.IzvodjacToIzvodjacDto;
import com.ftninformatika.jwd.modul3.cinema.web.dto.IzvodjacDTO;



@RestController
@RequestMapping(value = "/api/izvodjac", produces = MediaType.APPLICATION_JSON_VALUE)
public class IzvodjacController {

	@Autowired
	private IzvodjacService service;

	@Autowired
	private IzvodjacToIzvodjacDto toDTO;

	@Autowired
	private IzvodjacDtoToIzvodjac toEntity;

	
//  @PreAuthorize("hasRole('ADMIN')")
	//@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<IzvodjacDTO>> getAll(@RequestParam(required = false) String naziv) {

		List<Izvodjac> findAll = service.findAll();
		return new ResponseEntity<>(toDTO.convert(findAll), HttpStatus.OK);
	}
	
	
	// 	DODAVANJE
	//  @PreAuthorize("hasRole('ADMIN')")
		@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
		public ResponseEntity<IzvodjacDTO> add(@Validated @RequestBody IzvodjacDTO newDto) {
	
				Izvodjac saved = service.save(toEntity.convert(newDto));//zavisi da li se cuva entitet

	
//				Izvodjac saved = service.save(newDto); //zavisi da li se cuva dto
	
			return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);
		}
	
	// 	GET JEDNOG
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//		ResponseEntity<TaskDto> getOne(@PathVariable Long id) {
//			Optional<Task> task= service.findOne(id);
//			if (!task.isPresent()) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//	
//			return new ResponseEntity<>(toDTO.convert(task.get()), HttpStatus.OK);
//		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// 	GET ALL I PRETRAGA
//  @PreAuthorize("hasRole('ADMIN')")
//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//	@RequestMapping(method = RequestMethod.GET)
//	ResponseEntity<List<TaskDto>> get(
//			@RequestParam(value = "taskName", required = false) String taskName,
//			@RequestParam(value = "sprintId", required = false) Long sprintId,
//			//@RequestParam(value = "maxCena", required = false) Double maxCena,// da nije primitivan
//			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
//
//		Page<Task> page = null;
//				
//		//if (taskName != null || sprintId != null || maxCena != null) {
//		if (taskName != null || sprintId != null) {
//			page = service.search(taskName, sprintId, pageNo);
//		} else {
//			page = service.findAll(pageNo);
//		}
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
//
//		//Napredni zadatak, za racunanje sume poena svih zadataka jednog sprinta
//		//Ovo se radi JEDINO ako je vrsena pretraga po sprint, to jest sprint id nije nula
//		//if(sprintId != null) {
//		//	headers.add("Sprint-Total", Long.toString(taskService.sumPoints(sprintId)));
//		//}
//		
//		return new ResponseEntity<>(toDTO.convert(page.getContent()), headers, HttpStatus.OK);
//	}
	
	
	// 	DODAVANJE
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//		public ResponseEntity<TaskDto> add(@Validated @RequestBody TaskDto newDto) {
	//
//			Task saved = service.save(newDto);
	//
//			return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);
//		}
	
	// 	GET JEDNOG
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//		ResponseEntity<TaskDto> getOne(@PathVariable Long id) {
//			Optional<Task> getOne= service.findOne(id);
//			if (!getOne.isPresent()) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
	//
//			return new ResponseEntity<>(toDTO.convert(getOne.get()), HttpStatus.OK);
//		}
	
	// 	DELETE
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//		ResponseEntity<TaskDto> delete(@PathVariable Long id) {
//			Task deleted = service.delete(id);
	//
//			if (deleted == null) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
	//
//			return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
//		}
	
	// 	EDIT
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
//		public ResponseEntity<TaskDto> edit(@Validated @RequestBody TaskDto editedDTO, @PathVariable Long id) {
	//
//			if (!id.equals(editedDTO.getId())) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
	//
//			Task persisted = service.save(editedDTO);
	//
//			return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
//		}
	
// 	PROMENA STANJA - POSEBAN ZADATAK
//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//	@RequestMapping(value = "/{id}/change_state", method = RequestMethod.POST)
//	public ResponseEntity<TaskDto> changeState(@PathVariable Long id) {
//		
//		Task change = service.prelazak(id);//pozivamo metodu za promenu
//		//Linija change = service.rezervacija(id);//pozivamo metodu za promenu
//		if(change != null) {
//			return new ResponseEntity<>(toDTO.convert(change),HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		}
//	}
	
	
	//---------------------GET ALL OBICNA - PAGINIRANO--------------------------------------------------------	
		//  @PreAuthorize("hasRole('ADMIN')")
		//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//			@GetMapping
//			public ResponseEntity<List<LinijaDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
		//
//				Page<Linija> page;
		//
//				page = linijaService.findAll(pageNo);
		//
//				HttpHeaders headers = new HttpHeaders();
//				headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		//
//				return new ResponseEntity<>(linijaToLinijaDto.convert(page.getContent()), headers, HttpStatus.OK);
//			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------   1   --------------------------------------------------------	
	
	//---------------------GET ALL OBICNA - NEPAGINIRANO--------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@GetMapping
//		public ResponseEntity<List<PrevoznikDTO>> getAll(@RequestParam(required = false) String naziv) {
	//
//			List<Prevoznik> prevoznici = prevoznikService.findAll();
//			return new ResponseEntity<>(prevoznikToPrevoznikDto.convert(prevoznici), HttpStatus.OK);
//		}
	//---------------------GET ALL OBICNA - PAGINIRANO--------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@GetMapping
//		public ResponseEntity<List<LinijaDTO>> getAll(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
	//
//			Page<Linija> page;
	//
//			page = linijaService.findAll(pageNo);
	//
//			HttpHeaders headers = new HttpHeaders();
//			headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	//
//			return new ResponseEntity<>(linijaToLinijaDto.convert(page.getContent()), headers, HttpStatus.OK);
//		}	
	//-------------------GET ALL-PRETRAGE-NEPAGINIRANO--------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@GetMapping
//	    public ResponseEntity<List<FilmDTO>> getAll(
//	            @RequestParam(required=false) String naziv,
//	            @RequestParam(required=false) Long zanrId,
//	            @RequestParam(required=false) Integer trajanjeOd,
//	            @RequestParam(required=false) Integer trajanjeDo){
	//
//	        List<Film> filmovi = filmService.find(naziv,zanrId,trajanjeOd,trajanjeDo);
	//
//	        return new ResponseEntity<>(toFilmDto.convert(filmovi), HttpStatus.OK);
//	    }	
	//-------------------GET ALL-PRETRAGE-PAGINIRANO--------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@GetMapping
//	    public ResponseEntity<List<ProjekcijaDTO>> getAll(
//	    		@RequestParam(required=false) String datumIVremeOdParametar,
//	            @RequestParam(required=false) String datumIVremeDoParametar,
//	            @RequestParam(required=false) Long filmId,
//	            @RequestParam(required=false) String tip,
//	            @RequestParam(required=false) Integer sala,
//	            @RequestParam(required=false) Double cenaKarteOd,
//	            @RequestParam(required=false) Double cenaKarteDo,
//	            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
	//
//	        Page<Projekcija> page;
	//
//	        if(datumIVremeOdParametar != null && datumIVremeDoParametar != null) {
//	        	
//	            LocalDateTime datumIVremeOd =  getLocalDateTime(datumIVremeOdParametar);
//	            LocalDateTime datumIVremeDo =  getLocalDateTime(datumIVremeDoParametar);
	//
//	            page = projekcijaService.find(datumIVremeOd,datumIVremeDo,filmId,tip,sala,cenaKarteOd,cenaKarteDo, pageNo);
//	        }
//	        else{
//	        	page = projekcijaService.findAll(pageNo);
//	        }
	//
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
//	        
//	        return new ResponseEntity<>(toProjekcijaDto.convert(page.getContent()), headers, HttpStatus.OK);
//	    }
	//-------------------GET ALL-PRETRAGE-PAGINIRANO--------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(method = RequestMethod.GET)
//		ResponseEntity<List<TaskDto>> get(@RequestParam(value = "taskName", required = false) String taskName,
//				@RequestParam(value = "sprintId", required = false) Long sprintId,
//				@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
	//
//			Page<Task> page = null;
	//
//			if (taskName != null || sprintId != null) {
//				page = taskService.search(taskName, sprintId, pageNo);
//			} else {
//				page = taskService.all(pageNo);
//			}
	//
//			HttpHeaders headers = new HttpHeaders();
//			headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	//
//			//Napredni zadatak, za racunanje sume poena svih zadataka jednog sprinta
//			//Ovo se radi JEDINO ako je vrsena pretraga po sprint, to jest sprint id nije nula
//			if(sprintId != null) {
//				headers.add("Sprint-Total", Long.toString(taskService.sumPoints(sprintId)));
//			}
//			
//			return new ResponseEntity<>(toDTO.convert(page.getContent()), headers, HttpStatus.OK);
//		}	
	//-------------------GET ALL-PRETRAGE-POSEBNO--------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(value = "/search", method = RequestMethod.GET)
//		ResponseEntity<List<LinijaDTO>> get(
//				@RequestParam(value = "destinacija", required = false) String destinacija,
//				@RequestParam(value = "prevoznikId", required = false) Long prevoznikId,
//				@RequestParam(value = "maxCena", required = false) Double maxCena,
//				@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) 
//		{
	//
//			Page<Linija> page = null;
	//
//			if (destinacija != null || prevoznikId != null || maxCena != null) {
//				page = linijaService.search(destinacija, prevoznikId, maxCena, pageNo);
//			} else {
//				page = linijaService.findAll(pageNo);
//			}
	//
//			HttpHeaders headers = new HttpHeaders();
//			headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	//
//			
//			return new ResponseEntity<>(linijaToLinijaDto.convert(page.getContent()), headers, HttpStatus.OK);
//		}	
	//------------------------   2   --------------------------------------------------------	

	//----------------------CREATE-SAVE DTO--------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//		public ResponseEntity<TaskDto> add(@Validated @RequestBody TaskDto newDto) {
	//
//			Task saved = taskService.save(newDto);
	//
//			return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);
//	}
	// 	DODAVANJE
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//		public ResponseEntity<TaskDto> add(@Validated @RequestBody TaskDto newDto) {
	//
//				Prevoznik saved = service.save(toEntity.convert(newDto));//zavisi da li se cuva entitet

	
//				Prevoznik saved = service.save(newDto); //zavisi da li se cuva dto
	//
//			return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);
//		}

	//----------------------CREATE-SAVE ENTITY--------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	    public ResponseEntity<FilmDTO> create(@Valid @RequestBody FilmDTO filmDTO){
//	        Film film = toEntity.convert(filmDTO);
//	        Film sacuvanFilm = filmService.save(film);
	//
//	        return new ResponseEntity<>(toFilmDto.convert(sacuvanFilm), HttpStatus.CREATED);
//	    }
		
	//-------------------------------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	    public ResponseEntity<ProjekcijaDTO> create(@Valid @RequestBody ProjekcijaDTO projekcijaDTO){
//	        Projekcija projekcija = toProjekcija.convert(projekcijaDTO);
	//
//	        if(projekcija.getFilm() == null) {
//	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	        }
//	        
//	        Projekcija sacuvanProjekcija = projekcijaService.save(projekcija);
	//
//	        return new ResponseEntity<>(toProjekcijaDto.convert(sacuvanProjekcija), HttpStatus.CREATED);
//	    }
		
	//------------------------   3   --------------------------------------------------------	
		
	//---------------------GET ONE---------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//		ResponseEntity<TaskDto> getOne(@PathVariable Long id) {
//			Optional<Task> task= taskService.one(id);
//			if (!task.isPresent()) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
	//
//			return new ResponseEntity<>(toDTO.convert(task.get()), HttpStatus.OK);
//		}
	//----------------------------------------------------------------------------------	
		
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//	    @GetMapping("/{id}")
//	    public ResponseEntity<AdresaDTO> getOne(@PathVariable Long id){
//	        AAA adresa = aaaService.findOne(id).get();
	//
//	        if(adresa != null) {
//	            return new ResponseEntity<>(toDTO.convert(adresa), HttpStatus.OK);
//	        }else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
		
	//------------------------   4   --------------------------------------------------------	

	//------------------------DELETE---------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//		ResponseEntity<TaskDto> delete(@PathVariable Long id) {
//			Task deleted = taskService.delete(id);
	//
//			if (deleted == null) {
//				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
	//
//			return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
//		}
	//------------------------------------------------------------------------------------	
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@DeleteMapping("/{id}")
//	    public ResponseEntity<Void> delete(@PathVariable Long id){
//	        Projekcija obrisanProjekcija = projekcijaService.delete(id);
	//
//	        if(obrisanProjekcija != null) {
//	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	        } else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
		
	//------------------------   5   --------------------------------------------------------	
		
	//----------------------EDIT METODA - SAVE DTO--------------------------------------------------------	
		
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//		@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
//		public ResponseEntity<TaskDto> edit(@Validated @RequestBody TaskDto taskDTO, @PathVariable Long id) {
	//
//			if (!id.equals(taskDTO.getId())) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			}
	//
//			Task persisted = taskService.save(taskDTO);
	//
//			return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
//		}
	//----------------------UPDATE METODA-SAVE ENTITY-POVEZAN-------------------------------------------------------	
		
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//	    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
//	    public ResponseEntity<ProjekcijaDTO> update(@PathVariable Long id, @Valid @RequestBody ProjekcijaDTO projekcijaDTO){
	//
//	        if(!id.equals(projekcijaDTO.getId())) {
//	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	        }
	//
//	        Projekcija projekcija = toEntity.convert(projekcijaDTO);
	//
//	        if(projekcija.getFilm() == null) {
//	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	        }
	//
//	        Projekcija sacuvanProjekcija = projekcijaService.update(projekcija);
	//
//	        return new ResponseEntity<>(toDTO.convert(sacuvanProjekcija),HttpStatus.OK);
//	    }
	//----------------------UPDATE METODA-SAVE ENTITY-POVEZAN-------------------------------------------------------	
	    
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")	
//	    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
//	    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @Valid @RequestBody FilmDTO filmDTO){
	//
//	        if(!id.equals(filmDTO.getId())) {
//	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	        }
	//
//	        Film film = toEntity.convert(filmDTO);
//	        Film sacuvanFilm = filmService.update(film);
	//
//	        return new ResponseEntity<>(toDTO.convert(sacuvanFilm),HttpStatus.OK);
//	    }
		
	//--------------------PRETRAGA POVEZANIH ENTITETA PO ID---------------------------------------------------------	
		
		
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//	    @GetMapping("/{id}/projekcije")
//	    public ResponseEntity<List<ProjekcijaDTO>> findByFilmId(@PathVariable @Positive(message = "Id must be positive.")  Long id){
//	        List<Projekcija> projekcije = projekcijaService.findByFilmId(id);
	//
//	        return new ResponseEntity<>(toProjekcijaDto.convert(projekcije), HttpStatus.OK);
//	    }
	//    
	 //--------------------PROMENA STANJA---------------------------------------------------------	
		
	//  @PreAuthorize("hasRole('ADMIN')")
	//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
//	  	@RequestMapping(value = "/{id}/change_state", method = RequestMethod.POST)
//	  	public ResponseEntity<TaskDto> changeState(@PathVariable Long id) {
//	  		
//	  		Task task = taskService.prelazak(id);
//	  		if(task != null) {
//	  			return new ResponseEntity<>(toDTO.convert(task),HttpStatus.OK);
//	  		}
//	  		else {
//	  			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//	  		}
//	  	}
		
	 //--------------------DATUM FORMATER---------------------------------------------------------	

		private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
			LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
			return LocalDateTime.of(datum, vreme);
		}
	//--------------------EXCEPTION---------------------------------------------------------	

		@ExceptionHandler(value = DataIntegrityViolationException.class)
		public ResponseEntity<Void> handle() {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
}
