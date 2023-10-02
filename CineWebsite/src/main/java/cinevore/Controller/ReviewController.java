package cinevore.Controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import cinevore.Entity.Movie;
import cinevore.Entity.Review;
import cinevore.Entity.User;
import cinevore.Repository.MovieRepository;
import cinevore.Repository.ReviewRepository;
import cinevore.Repository.UserRepository;
import cinevore.Service.JwtAuthService;
import cinevore.Views.Views;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private JwtAuthService authService;
	
	
	@GetMapping("/average/{id}")
	public Double getMovieAverageRating(@PathVariable("id") Long id) {
		System.out.println(reviewRepo.calculateAverageRatingForMovie(id));
		return reviewRepo.calculateAverageRatingForMovie(id);
	}
	
	@JsonView(Views.ReviewInfo.class)
	@GetMapping("/get-user-review/{id}")
	public ResponseEntity<?> getReview(@PathVariable("id") Long idMovie,  @RequestParam("pseudo") String pseudo,
            @RequestParam("token") String token) {
	
        if(!authService.isTokenValid(token, pseudo)) {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findByPseudo(pseudo);
        Optional<Movie> optMovie = movieRepo.findById(idMovie);
	    if (!optMovie.isPresent()) {
	    	return ResponseEntity.notFound().build();
	    }
	    Movie movie = optMovie.get();
	    System.out.println("non");
        Optional<Review> optReview = reviewRepo.findReviewByUserAndMovie(user, movie);
        if (!optReview.isPresent()) {
	    	return ResponseEntity.notFound().build();
	    }
        Review review = optReview.get();
        return ResponseEntity.ok(review);
	}
	
	@PostMapping("/addReview")
	public ResponseEntity<Void> addReview (@RequestBody Map<String, String> data)
	{
		String pseudo = data.get("pseudo");
        String token = data.get("token");
        int grade = Integer.parseInt(data.get("grade"));
        Long idMovie = Long.parseLong(data.get("idMovie"));
        
		if(grade <  1 || grade > 10) {
			return ResponseEntity.badRequest().build();
		}
		Optional<Movie> optMovie = movieRepo.findById(idMovie);
		if(!optMovie.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		Movie movie = optMovie.get();
        
        if(!authService.isTokenValid(token, pseudo)) {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findByPseudo(pseudo);
	    Review review = new Review();
	    review.setUser(user);
	    review.setGrade(grade);
	    review.setMovie(movie);
	    reviewRepo.save(review);
	    
	    return ResponseEntity.ok().build();
		
	}
}
