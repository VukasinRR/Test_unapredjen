package com.ftninformatika.jwd.modul3.cinema.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.ftninformatika.jwd.modul3.cinema.model.Izvodjac;
import com.ftninformatika.jwd.modul3.cinema.web.dto.IzvodjacDTO;

@Component
public class IzvodjacToIzvodjacDto implements Converter<Izvodjac, IzvodjacDTO> {

	@Autowired
	private FestivalToFestivalDto toDto;

	@Override
	public IzvodjacDTO convert(Izvodjac source) {
		IzvodjacDTO dto = new IzvodjacDTO();
        dto.setId(source.getId());
        dto.setIme(source.getIme());
        dto.setZanr(source.getZanr());
        dto.setDrzava(source.getDrzava());
        return dto;
	}

	public List<IzvodjacDTO> convert(List<Izvodjac> Linije) {
		List<IzvodjacDTO> linijeDto = new ArrayList<>();

		for (Izvodjac linija : Linije) {
			linijeDto.add(convert(linija));
		}

		return linijeDto;
	}
	
//	@Override
//	public LinijaDTO convert(Linija source) {
//		LinijaDTO retValue = new LinijaDTO();
//		
//		retValue.setId(source.getId());
//		retValue.setBrojMesta(source.getBrojMesta());
//		retValue.setCenaKarte(source.getCenaKarte());
//		retValue.setVremePolaska(source.getVremePolaska());
//		retValue.setDestinacija(source.getDestinacija());
//
//		retValue.setPrevoznikId(source.getPrevoznik().getId());
//		retValue.setPrevoznikNaziv(source.getPrevoznik().getNaziv());
//		
//		return retValue;
//	}
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
