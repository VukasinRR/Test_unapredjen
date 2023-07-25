package com.ftninformatika.jwd.modul3.cinema.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class IzvodjacDTO {

	private Long id;
	
	private String ime;

	private String zanr;

	private String drzava;

	private int brojClanova;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public int getBrojClanova() {
		return brojClanova;
	}

	public void setBrojClanova(int brojClanova) {
		this.brojClanova = brojClanova;
	}

	
//	private Long prevoznikId;//POVEZANI ENTITET - preko atributa
//	private String prevoznikNaziv;//POVEZANI ENTITET - preko atributa
	
	//----------------VALIDACIJA ATRIBUTA----------------------------------------------
//		@NotBlank
//		@Length(max = 40)
//		private String name;
//		
//	    @NotBlank(message = "Naziv filma nije zadat.")
//		private String employee;
//	    
//	    @NotEmpty
//	    @Email
//	    private String eMail;
//	    
//	    @Size(min=3, max=50)
//	    private String ime;
//	    
//		@Min(value = 0)
//		@Max(value = 20)
//		private Integer points;	
//		
//		@Positive(message = "Id mora biti pozitivan broj.")
//	    private Long ids;
//		
//		@NotNull(message = "Nije zadato trajanje filma.")
//	    @Positive(message = "Trajanje filma nije pozitivan broj.")
//	    private int trajanje;
//		
//		@NotBlank(message = "Datum i vreme nisu zadati.")
//	    @Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]$", message = "Datum i vreme nisu validni.")
//	    private String datumIVreme;
		
	//----------------POVEZANI ENTITE----------------------------------------------
		
//		private Long sprintId;//POVEZANI ENTITET - preko atributa
//		private Long stateId;//POVEZANI ENTITET  - preko atributa
//		
//		private String sprintName;//POVEZANI ENTITET - preko atributa
//		private String stateName;//POVEZANI ENTITET - preko atributa
//		
//		@NotNull(message = "Film za koji je vezana projekcija nije zadat.")
//	    private FilmDTO film; //POVEZANI ENTITET - CEO DTO
		
	//----------------POVEZANI ENTITE-MANY TO MANY---------------------------------------------
		
//		// @NotEmpty(message = "Nije zadat nijedan zanr kom pripada film.")
//	    private Set<ZanrDTO> zanrovi = new HashSet<>();

	


}
