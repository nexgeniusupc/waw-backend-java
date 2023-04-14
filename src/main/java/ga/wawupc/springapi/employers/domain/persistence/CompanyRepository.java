package ga.wawupc.springapi.employers.domain.persistence;

import ga.wawupc.springapi.employers.domain.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
  List<Company> findAll();

  Company findByName(String name);
}
