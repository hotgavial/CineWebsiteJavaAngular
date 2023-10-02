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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import cinevore.Views.Views;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmovie")
	@JsonView(Views.Default.class)
	private Long idMovie;
	@JsonView(Views.Default.class)
	private String title;
	@Column(name = "originaltitle")
	@JsonView(Views.Default.class)
	private String originalTitle;
	@JsonView(Views.Default.class)
	private int year;
	@JsonView(Views.Default.class)
	private String trailer;

	@JsonView(Views.MovieDetail.class)
	@OneToMany( targetEntity=ActorMovie.class, mappedBy="movie" )
    private List<ActorMovie> cast = new ArrayList<>();
	
	@OneToMany( targetEntity=Review.class, mappedBy="movie" )
	private List<Review> reviews = new ArrayList<>();
	
	public Movie() {}


	public Movie(Long idMovie, String title, String originalTitle, int year, String trailer, List<ActorMovie> cast) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.originalTitle = originalTitle;
		this.year = year;
		this.trailer = trailer;
		this.cast = cast;
	}


	public Long getIdMovie() {
		return idMovie;
	}


	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getOriginalTitle() {
		return originalTitle;
	}


	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getTrailer() {
		return trailer;
	}


	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}


	public List<ActorMovie> getCast() {
		return cast;
	}


	public void setCast(List<ActorMovie> cast) {
		this.cast = cast;
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	@Override
	public String toString() {
		return "Movie [idMovie=" + idMovie + ", title=" + title + ", originalTitle=" + originalTitle + ", year=" + year
				+ ", trailer=" + trailer + "]";
	}
	
		
}

