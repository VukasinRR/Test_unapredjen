package com.ftninformatika.jwd.modul3.cinema.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Festival {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false, unique = true)
	private String naziv;
	
	@OneToMany(mappedBy = "festival", fetch = FetchType.EAGER, cascade = CascadeType.ALL)// , cascade = CascadeType.ALL OBRISI AKO PRAVI GRESKU NA EDIT
	private List<Nastup> nastupi = new ArrayList<>();

	public Festival() {
		super();
	}
	
	public void removeNastupById(Long id) {
	for(Nastup t : this.nastupi) {
		if (t.getId()==id){
			this.nastupi.remove(t);
			return;
		}
	}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Nastup> getNastupi() {
		return nastupi;
	}

	public void setNastupi(List<Nastup> nastupi) {
		this.nastupi = nastupi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", naziv=" + naziv + "]";
	}
	
	public void dodajNastup(Nastup nastup) {
	this.nastupi.add(nastup);
	nastup.setFestival(this);
}

//	@OneToMany(mappedBy = "prevoznik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)// , cascade = CascadeType.ALL OBRISI AKO PRAVI GRESKU NA EDIT
//	private List<Linija> linije = new ArrayList<>();

	
//	public Prevoznik(Prevoznik prevoznik) {
//		this.id = prevoznik.getId();
//		this.naziv = prevoznik.getNaziv();
//		this.adresa = prevoznik.getAdresa();
//		this.pib = prevoznik.getPib();
//	}
	
//	public void removeLinijuById(Long id) {
//		for(Linija t : this.linije) {
//			if (t.getId()==id){
//				this.linije.remove(t);
////				this.setPoints(Integer.parseInt(this.getPoints())-t.getPoints()+"");
//				return;
//			}
//		}
	
//	public void obrisiLiniju(Linija liniju) {
//		liniju.setPrevoznik(null);
//		this.linije.remove(liniju);
//	}
//
//	public void dodajLiniju(Linija liniju) {
//		this.linije.add(liniju);
//		liniju.setPrevoznik(this);
//}
	
	
//---------------------------ATRIBUTI--------------------------------	
	

//	@Column(nullable = false, unique = true)
//	private String naziv;
//
//	@Column(nullable = false, unique = true)
//	private Boolean pol;
//	
//	@Column(nullable = false, unique = true)
//	private boolean vakcinisan;
//	
//	@Column
//	private int trajanje;
//	
//	@Column
//	private Integer points;
//	
//	@Column
//	private double cenaKarte;
//	
//	@Column
//	private Double borjMesta;
//	
//	@Column(name="datum_vreme", nullable = false)
//    private LocalDateTime datumIVreme;

//---------------------------VEZE--------------------------------	
	
//	@ManyToOne
//	private Linija linija;
	
//	@OneToMany(mappedBy = "prevoznik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)// , cascade = CascadeType.ALL OBRISI AKO PRAVI GRESKU NA EDIT
//	private List<BBB> linije = new ArrayList<>();

//  @ManyToMany
//  @JoinTable(name = "film_zanr", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "zanr_id", referencedColumnName = "id"))
//    private Set<Zanr> zanrovi = new HashSet<>();
	
//	 @ManyToMany(mappedBy = "zanrovi",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	    private Set<Film> filmovi = new HashSet<>();

//---------------------------KONSTRUKTORI--------------------------------	
	
//	public Prevoznik(Prevoznik prevoznik) {
//		this.id = prevoznik.getId();
//		this.naziv = prevoznik.getNaziv();
//		this.adresa = prevoznik.getAdresa();
//		this.pib = prevoznik.getPib();
//	}
	
//---------------------------METODE I SETERI--------------------------------	
	
//---------------------------one to many--------------------------------	
//	   public void setFilm(Film film) {
//	        this.film = film;
//	        if(film !=null && !film.getProjekcije().contains(this)){
//	            film.getProjekcije().add(this);
//	        }
//	    }
//	
//	public void setSprint(Sprint sprint) {
//		this.sprint = sprint;
//		sprint.tasks.add(this);
//
//	}
//---------------------------many to one--------------------------------	
//	   public void dodajLiniju(BBB linija){
//	        this.linije.add(linija);
//	        if(!equals(linija.getPrevoznik())){
//	        	linija.setPrevoznik(this);
//	        }
//	    }
//	   
//	public void dodajTask(Task task){
//		this.tasks.add(task);
//		task.sprint = this;
//	}
//	
	
//		public void removeLiniju(Long id) {
//			for(BBB t : this.linije) {
//				if (t.getId()==id){
//					this.linije.remove(t);
//					this.setPoints(Integer.parseInt(this.getPoints())-t.getPoints()+"");
//					return;
//				}
//			}
//		}
	
	
//	public void obrisiTask(Task task){
//		task.sprint = null;
//		this.tasks.remove(task);
//		}
//
	
//		public void novaLinija(BBB linija) {
//			this.linije.add(linija);
//			this.setPoints(Integer.parseInt(this.getPoints())+task.getPoints()+"");		
//		}
	
	
//	public void dodajSveTask(Collection<Task> task){
//		this.tasks.addAll(task);
//		for(Task k : this.tasks)
//		k.sprint = this;
//		}
//	
//		public void ukloniSveTasks(){
//		for(Task k : this.tasks)
//		k.sprint = null;
//		this.tasks.clear();
//		}

	   
}
