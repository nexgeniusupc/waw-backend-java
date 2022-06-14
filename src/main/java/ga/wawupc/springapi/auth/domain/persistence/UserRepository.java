package ga.wawupc.springapi.auth.domain.persistence;

import ga.wawupc.springapi.auth.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findAll();

  User findByFullName(String fullName);
}
