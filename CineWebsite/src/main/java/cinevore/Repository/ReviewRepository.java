package cinevore.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cinevore.Entity.Movie;
import cinevore.Entity.Review;
import cinevore.Entity.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	@Query("SELECT AVG(r.grade) FROM Review r WHERE r.movie.idMovie = :idMovie")
    Double calculateAverageRatingForMovie(@Param("idMovie") Long idMovie);
	Optional<Review> findReviewByUserAndMovie(User user, Movie movie);
}
