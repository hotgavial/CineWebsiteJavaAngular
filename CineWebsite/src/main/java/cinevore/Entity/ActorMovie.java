package cinevore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import cinevore.Views.Views;

@Entity
@Table(name = "actors_movies")
public class ActorMovie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "idactorsmovies")
	private int idActorMovie;
	
	@ManyToOne @JoinColumn(name="idmovie", nullable=false)
	private Movie movie;
	
	@JsonView(Views.MovieDetail.class)
	@ManyToOne @JoinColumn(name="idactor", nullable=false)
	private Actor actor;
	
	@JsonView(Views.Default.class)
	private String job;

	public ActorMovie() {}
	
	
	public ActorMovie(int idActorMovie, Movie movie, Actor actor, String job) {
		super();
		this.idActorMovie = idActorMovie;
		this.movie = movie;
		this.actor = actor;
		this.job = job;
	}



	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getIdActorMovie() {
		return idActorMovie;
	}

	public void setIdActorMovie(int idActorMovie) {
		this.idActorMovie = idActorMovie;
	}

	public Movie getmovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
}
