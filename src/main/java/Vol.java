import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vol {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String numVol;
	
	@Column
	private String typeAvion;
	
	@Column
	private Integer nbPlace;
	
	@Column
	private String villeDepart;
	
	@Column
	private String villeArrivee;
	
	@Column
	private Date dateDepart;
	
	@OneToMany(mappedBy = "vol")
	private List<Reservation> reservations;

	@Override
	public String toString() {
		return "Vol [numVol=" + numVol + ", typeAvion=" + typeAvion + ", nbPlace=" + nbPlace + ", villeDepart="
				+ villeDepart + ", villeArrivee=" + villeArrivee + ", dateDepart=" + dateDepart + "]";
	}

	public Vol() {
		super();
	}

	public Vol(String numVol, String typeAvion, Integer nbPlace, String villeDepart, String villeArrivee,
			Date dateDepart) {
		super();
		this.numVol = numVol;
		this.typeAvion = typeAvion;
		this.nbPlace = nbPlace;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.dateDepart = dateDepart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumVol() {
		return numVol;
	}

	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}

	public String getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	} 
		
}
