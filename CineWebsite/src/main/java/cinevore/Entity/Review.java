package cinevore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import cinevore.Views.Views;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idreview")
	@JsonView(Views.ReviewInfo.class)
	private Long idReview;
	
	@JsonView(Views.ReviewInfo.class)
	private int grade;
	
	@JsonView(Views.ReviewInfo.class)
	private String review;
	
	@JsonView(Views.ReviewInfo.class)
	@ManyToOne @JoinColumn(name="idmovie", nullable=false)
	private Movie movie;
	
	@JsonView(Views.ReviewInfo.class)
	@ManyToOne @JoinColumn(name="iduser", nullable=false)
	private User user;
	
	public Review() {}
	
	public Review(Long idReview, int grade, String review, Movie movie, User user) {
		super();
		this.idReview = idReview;
		this.grade = grade;
		this.review = review;
		this.movie = movie;
		this.user = user;
	}



	public Long getIdReview() {
		return idReview;
	}

	public void setIdReview(Long idReview) {
		this.idReview = idReview;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
