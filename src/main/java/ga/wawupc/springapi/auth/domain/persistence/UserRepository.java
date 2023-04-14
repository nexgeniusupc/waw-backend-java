package ga.wawupc.springapi.auth.domain.persistence;

import ga.wawupc.springapi.auth.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findAll();

  User findByFullName(String fullName);
}
