 package com.ftninformatika.jwd.modul3.cinema.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nastup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Festival festival;
	
	@ManyToOne
	private Izvodjac izvodjac;

	public Nastup() {
		super();
	}

	public Nastup(Nastup nastup) {
	this.id = nastup.getId();
	this.festival = nastup.getFestival();
	this.izvodjac = nastup.getIzvodjac();	

}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Izvodjac getIzvodjac() {
		return this.izvodjac;
	}

	public void setIzvodjac(Izvodjac izvodjac) {
		this.izvodjac = izvodjac;
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
		Nastup other = (Nastup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nastup [id=" + id + "]";
	}
	
	
	
	
	
	
	
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
