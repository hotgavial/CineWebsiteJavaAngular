package cinevore.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import cinevore.Views.Views;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
	private int idUser;
	@JsonView(Views.ReviewInfo.class)
	private String pseudo;
	private String password;
	private Date createdAt;
	
	@OneToMany( targetEntity=Review.class, mappedBy="user" )
    private List<Review> reviews = new ArrayList<>();
	
	public User() {}
	
	public User(String pseudo, String password) {
		super();
		this.pseudo = pseudo;
		this.password = password;
	}
	
	

	public User(int idUser, String pseudo, String password, Date createdAt, List<Review> reviews) {
		super();
		this.idUser = idUser;
		this.pseudo = pseudo;
		this.password = password;
		this.createdAt = createdAt;
		this.reviews = reviews;
	}



	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "User [pseudo=" + pseudo + ", password=" + password + "]";
	}
	
	
	
	

}
