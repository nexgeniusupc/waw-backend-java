package ga.wawupc.springapi.employers.domain.service;

import ga.wawupc.springapi.employers.domain.model.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {
  List<Company> getAll();
  Page<Company> getAll(Pageable pageable);
  Company getById(Long id);
  Company create(Company company);
  Company update(Long id, Company company);
  ResponseEntity<?> delete(Long id);
}
