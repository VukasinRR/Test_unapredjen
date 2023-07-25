package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.cinema.model.Izvodjac;
import com.ftninformatika.jwd.modul3.cinema.model.Nastup;
import com.ftninformatika.jwd.modul3.cinema.web.dto.IzvodjacDTO;
import com.ftninformatika.jwd.modul3.cinema.web.dto.NastupDTO;
@Component
public class NastupToNastupDto implements  Converter<Nastup, NastupDTO>{

	@Override
	public NastupDTO convert(Nastup source) {
		NastupDTO retValue = new NastupDTO();
		
		retValue.setId(source.getId());
		

		retValue.setFestivalId(source.getFestival().getId());
		retValue.setFestivalNaziv(source.getFestival().getNaziv());
		
		retValue.setIzvodjacId(source.getIzvodjac().getId());
		retValue.setIzvodjacIme(source.getIzvodjac().getIme());
		
		return retValue;
	}

	
	public List<NastupDTO> convert(List<Nastup> Linije) {
		List<NastupDTO> linijeDto = new ArrayList<>();

		for (Nastup linija : Linije) {
			linijeDto.add(convert(linija));
		}

		return linijeDto;
	}
//------------------OBICNA-------------------------------
//	@Override
//	public PrevoznikDTO convert(Prevoznik prevoznik) {
//		PrevoznikDTO dto = new PrevoznikDTO();
//	        dto.setId(prevoznik.getId());
//	        dto.setNaziv(prevoznik.getNaziv());
//	        dto.setAdresa(prevoznik.getAdresa());
//	        dto.setPib(prevoznik.getPib());
//	        return dto;
//	}
//------------------NA DTO ATRIBUTE-------------------------------
// @Override
//	public LinijaDTO convert(Linija linija) {
//		
//		LinijaDTO retValue = new LinijaDTO();
//		
//		retValue.setId(linija.getId());
//		retValue.setBrojMesta(linija.getBrojMesta());
//		retValue.setCenaKarte(linija.getCenaKarte());
//		retValue.setVremePolaska(linija.getVremePolaska());
//		retValue.setDestinacija(linija.getDestinacija());
//
//		retValue.setPrevoznikId(linija.getPrevoznik().getId());
//		retValue.setPrevoznikNaziv(linija.getPrevoznik().getNaziv());
//		
//		return retValue;
//		
//	}
//------------------POVEZANI ENTITET-------------------------------
//   @Override
//    public ProjekcijaDTO convert(Projekcija projekcija) {
//        ProjekcijaDTO projekcijaDTO = new ProjekcijaDTO();
//        projekcijaDTO.setId(projekcija.getId());
//        projekcijaDTO.setDatumIVreme(projekcija.getDatumIVreme().toString());
//        projekcijaDTO.setFilm(BBBToBBBDto.convert(projekcija.getFilm()));
//        projekcijaDTO.setSala(projekcija.getSala());
//        projekcijaDTO.setTip(projekcija.getTip());
//        projekcijaDTO.setCenaKarte(projekcija.getCenaKarte());
//
//        return projekcijaDTO;
//    }
//------------------POVEZANI ENTITET-MANY TO MANY------------------------------
//   @Override
//    public FilmDTO convert(Film film) {
//        FilmDTO dto = new FilmDTO();
//        dto.setId(film.getId());
//        dto.setNaziv(film.getNaziv());
//        dto.setTrajanje(film.getTrajanje());
//        List<Zanr> zanrovi = new ArrayList<>(film.getZanrovi());
//        dto.setZanrovi(new HashSet<>(BBBToBBBDto.convert(zanrovi)));
//        return dto;
//    }	
	
	
}
