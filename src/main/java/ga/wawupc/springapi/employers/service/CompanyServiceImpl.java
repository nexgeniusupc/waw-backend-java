package ga.wawupc.springapi.employers.service;

import ga.wawupc.springapi.employers.domain.model.entity.Company;
import ga.wawupc.springapi.employers.domain.persistence.CompanyRepository;
import ga.wawupc.springapi.employers.domain.service.CompanyService;
import ga.wawupc.springapi.shared.exception.ResourceNotFoundException;
import ga.wawupc.springapi.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService {
  private static final String ENTITY = "Company";
  private final CompanyRepository repository;
  private final Validator validator;

  public CompanyServiceImpl(CompanyRepository repository, Validator validator) {
    this.repository = repository;
    this.validator = validator;
  }

  @Override
  public List<Company> getAll() {
    return repository.findAll();
  }

  @Override
  public Page<Company> getAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Company getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
  }

  @Override
  public Company create(Company company) {
    Set<ConstraintViolation<Company>> violations = validator.validate(company);

    if (!violations.isEmpty())
      throw new ResourceValidationException(ENTITY, violations);

    // Validate unique company name
    Company companyWithName = repository.findByName(company.getName());

    if (companyWithName != null)
      throw new ResourceValidationException(ENTITY, "A company with the same name already exists.");

    return repository.save(company);
  }

  @Override
  public Company update(Long id, Company request) {
    Set<ConstraintViolation<Company>> violations = validator.validate(request);

    if (!violations.isEmpty())
      throw new ResourceValidationException(ENTITY, violations);

    // Validate unique company name
    Company companyWithName = repository.findByName(request.getName());

    if (companyWithName != null && !companyWithName.getId().equals(id))
      throw new ResourceValidationException(ENTITY, "A company with the same name already exists.");

    return repository.findById(id).map(company ->
            repository.save(company
                    .withName(request.getName())
                    .withAddress(request.getAddress())
                    .withEmail(request.getEmail())))
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    return repository.findById(id).map(company -> {
      repository.delete(company);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
  }
}
