package ga.wawupc.springapi.jobs.domain.service;

import ga.wawupc.springapi.jobs.domain.model.entity.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfferService {
  List<Offer> getAll();

  Page<Offer> getAll(Pageable pageable);

  Offer getById(Long id);

  Offer create(Offer request);

  Offer update(Long id, Offer request);

  ResponseEntity<?> delete(Long id);
}
