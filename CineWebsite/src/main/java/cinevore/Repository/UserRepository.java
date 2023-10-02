package cinevore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinevore.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByPseudo(String pseudo);
}
