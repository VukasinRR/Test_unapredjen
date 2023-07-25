package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Adresa;
import com.ftninformatika.jwd.modul3.cinema.model.Festival;
import com.ftninformatika.jwd.modul3.cinema.web.dto.AdresaDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.FestivalDTO;


@Component
public class FestivalToFestivalDto implements  Converter<Festival, FestivalDTO>{

	@Autowired
    private FestivalToFestivalDto toDTO;//POVEZANI ENTITET DTO

	
	@Override
	public FestivalDTO convert(Festival source) {
		FestivalDTO dto = new FestivalDTO();
        dto.setId(source.getId());
        dto.setNaziv(source.getNaziv());
        return dto;
	}
	
	
	public List<FestivalDTO> convert(List<Festival> adrese){
        List<FestivalDTO> adresaDTOS = new ArrayList<>();

        for(Festival a : adrese) {
        	FestivalDTO dto = convert(a);
            adresaDTOS.add(dto);
        }

        return adresaDTOS;
    }
	 
	 
//		@Override
//		public PrevoznikDTO convert(Prevoznik source) {
//			PrevoznikDTO dto = new PrevoznikDTO();
//	        dto.setId(source.getId());
//	        dto.setNaziv(source.getNaziv());
//	        dto.setAdresa(source.getAdresa());
//	        dto.setPib(source.getPib());
//	        return dto;
//		}

//------------------OBICNA-------------------------------
//		@Override
//		public PrevoznikDTO convert(Prevoznik prevoznik) {
//			PrevoznikDTO dto = new PrevoznikDTO();
//		        dto.setId(prevoznik.getId());
//		        dto.setNaziv(prevoznik.getNaziv());
//		        dto.setAdresa(prevoznik.getAdresa());
//		        dto.setPib(prevoznik.getPib());
//		        return dto;
//		}
//------------------NA DTO ATRIBUTE-------------------------------
//	 @Override
//		public LinijaDTO convert(Linija linija) {
//			
//			LinijaDTO retValue = new LinijaDTO();
//			
//			retValue.setId(linija.getId());
//			retValue.setBrojMesta(linija.getBrojMesta());
//			retValue.setCenaKarte(linija.getCenaKarte());
//			retValue.setVremePolaska(linija.getVremePolaska());
//			retValue.setDestinacija(linija.getDestinacija());
//
//			retValue.setPrevoznikId(linija.getPrevoznik().getId());
//			retValue.setPrevoznikNaziv(linija.getPrevoznik().getNaziv());
//			
//			return retValue;
//			
//		}
//------------------POVEZANI ENTITET-------------------------------
//	   @Override
//	    public ProjekcijaDTO convert(Projekcija projekcija) {
//	        ProjekcijaDTO projekcijaDTO = new ProjekcijaDTO();
//	        projekcijaDTO.setId(projekcija.getId());
//	        projekcijaDTO.setDatumIVreme(projekcija.getDatumIVreme().toString());
//	        projekcijaDTO.setFilm(BBBToBBBDto.convert(projekcija.getFilm()));
//	        projekcijaDTO.setSala(projekcija.getSala());
//	        projekcijaDTO.setTip(projekcija.getTip());
//	        projekcijaDTO.setCenaKarte(projekcija.getCenaKarte());
//
//	        return projekcijaDTO;
//	    }
//------------------POVEZANI ENTITET-MANY TO MANY------------------------------
//	   @Override
//	    public FilmDTO convert(Film film) {
//	        FilmDTO dto = new FilmDTO();
//	        dto.setId(film.getId());
//	        dto.setNaziv(film.getNaziv());
//	        dto.setTrajanje(film.getTrajanje());
//	        List<Zanr> zanrovi = new ArrayList<>(film.getZanrovi());
//	        dto.setZanrovi(new HashSet<>(BBBToBBBDto.convert(zanrovi)));
//	        return dto;
//	    }
	
}
