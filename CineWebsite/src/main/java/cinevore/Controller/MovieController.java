package cinevore.Controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;
import cinevore.Entity.Actor;
import cinevore.Entity.ActorMovie;
import cinevore.Entity.Movie;
import cinevore.Repository.MovieRepository;
import cinevore.Views.Views;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieRepository movieRepo;
	
	@GetMapping("/{id}")
	@JsonView(Views.MovieDetail.class)
	public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
	    Optional<Movie> optMovie = movieRepo.findById(id);;
	    if (optMovie.isPresent()) {
	        Movie movie = optMovie.get();
	        return ResponseEntity.ok(movie);
	    } else {
	    	return ResponseEntity.notFound().build();
	    }
	}
	
}
