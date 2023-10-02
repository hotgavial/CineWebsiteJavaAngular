package cinevore.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import cinevore.Views.Views;

@Entity
@Table(name = "actors")
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idactor")
	@JsonView(Views.Default.class)
	private Long idActor;
	
	@Column(name = "firstname")
	@JsonView(Views.Default.class)
	private String firstName;
	
	@Column(name = "lastname")
	@JsonView(Views.Default.class)
	private String lastName;
	
	@Column(name = "hasbadge")
	private boolean hasBadge;
	
	@Column(name = "ismale")
	private boolean isMale;
		
	@OneToMany( targetEntity=ActorMovie.class, mappedBy="actor" )
    private List<ActorMovie> movies = new ArrayList<>();
			
	public Actor() {}
	
	public Actor(Long idActor, String firstName, String lastName, boolean hasBadge, boolean isMale,
			List<ActorMovie> movies) {
		super();
		this.idActor = idActor;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hasBadge = hasBadge;
		this.isMale = isMale;
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [idActor=" + idActor + ", firstName=" + firstName + ", lastName=" + lastName + ", hasBadge="
				+ hasBadge + ", isMale=" + isMale + "]";
	}

	public Long getIdActor() {
		return idActor;
	}

	public void setIdActor(Long idActor) {
		this.idActor = idActor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isHasBadge() {
		return hasBadge;
	}

	public void setHasBadge(boolean hasBadge) {
		this.hasBadge = hasBadge;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public List<ActorMovie> getMovies() {
		return movies;
	}

	public void setCelebrites(List<ActorMovie> movies) {
		this.movies = movies;
	}
	
}
