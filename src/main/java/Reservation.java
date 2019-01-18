import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

		@Id
		@GeneratedValue
		private Integer id;
		
		@Column
		private String nom;
		
		@Column
		private String prenom;
		
		@Column
		private Integer age;
		
		@Column
		private String numResa;
		
		@ManyToOne
		private Vol vol;
		
		public Reservation() {
			super();
		}

		public Reservation(String nom, String prenom, Integer age, Vol vol, String numResa) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.age = age;
			this.vol = vol;
			this.numResa = numResa;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Vol getVol() {
			return vol;
		}

		public void setVol(Vol vol) {
			this.vol = vol;
		}

		public String getNumResa() {
			return numResa;
		}

		public void setNumResa(String numResa) {
			this.numResa = numResa;
		}
		
}
