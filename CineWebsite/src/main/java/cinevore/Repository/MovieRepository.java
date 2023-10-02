package cinevore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cinevore.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
