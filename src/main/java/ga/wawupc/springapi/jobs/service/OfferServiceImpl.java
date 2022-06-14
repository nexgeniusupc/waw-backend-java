package ga.wawupc.springapi.jobs.service;

import ga.wawupc.springapi.jobs.domain.model.entity.Offer;
import ga.wawupc.springapi.jobs.domain.persistence.OfferRepository;
import ga.wawupc.springapi.jobs.domain.service.OfferService;
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
public class OfferServiceImpl implements OfferService {
  private static final String ENTITY = "Offer";
  private final OfferRepository repository;
  private final Validator validator;

  public OfferServiceImpl(OfferRepository repository, Validator validator) {
    this.repository = repository;
    this.validator = validator;
  }

  @Override
  public List<Offer> getAll() {
    return repository.findAll();
  }

  @Override
  public Page<Offer> getAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Offer getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
  }

  @Override
  public Offer create(Offer offer) {
    Set<ConstraintViolation<Offer>> violations = validator.validate(offer);

    if (!violations.isEmpty())
      throw new ResourceValidationException(ENTITY, violations);

    // Validate unique offer title
    Offer offerWithTitle = repository.findByTitle(offer.getTitle());

    if (offerWithTitle != null)
      throw new ResourceValidationException(ENTITY,"A offer with the same title already exists");
    return repository.save(offer);
  }

  @Override
  public Offer update(Long id, Offer request) {
    Set<ConstraintViolation<Offer>> violations = validator.validate(request);

    if (!violations.isEmpty())
      throw new ResourceValidationException(ENTITY, violations);

    // Validate unique offer name
    Offer offerWithTitle = repository.findByTitle(request.getTitle());

    if (offerWithTitle != null && !offerWithTitle.getId().equals(id))
      throw new ResourceValidationException(ENTITY, "A offer with the same name already exists");

    return repository.findById(id).map(offer ->
                    repository.save(offer
                            .withTitle(request.getTitle())
                            .withDescription(request.getDescription())
                            .withImage(request.getImage())
                            .withStatus(request.getStatus())
                            .withSalaryRange(request.getSalaryRange())
                    ))
            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
  }

  @Override
  public ResponseEntity<?> delete(Long id) {
    return repository.findById(id).map(offer -> {
      repository.delete(offer);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
  }
}
