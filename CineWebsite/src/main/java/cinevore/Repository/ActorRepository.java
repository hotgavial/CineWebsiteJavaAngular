package cinevore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cinevore.Entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
	
	

}
