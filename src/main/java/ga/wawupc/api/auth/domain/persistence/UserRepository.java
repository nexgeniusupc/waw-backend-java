package ga.wawupc.api.auth.domain.persistence;

import ga.wawupc.api.auth.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Boolean existsByEmail(String email);
  Optional<User> findByEmail(String email);
}
