package ga.wawupc.springapi.auth.domain.persistence;

import ga.wawupc.springapi.auth.domain.model.entity.UserExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExperienceRepository extends JpaRepository<UserExperience, Long> {
  List<UserExperience> findAll();
  UserExperience findByTitle(String title);
}
