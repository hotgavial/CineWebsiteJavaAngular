package cinevore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cinevore.Entity.ActorMovie;

public interface ActorMovieRepository  extends JpaRepository<ActorMovie, Long> {

}
