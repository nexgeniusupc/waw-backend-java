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
  Offer create(Offer company);
  Offer update(Long id, Offer company);
  ResponseEntity<?> delete(Long id);
}
