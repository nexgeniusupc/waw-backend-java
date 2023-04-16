package ga.wawupc.api.jobs.domain.persistence;

import ga.wawupc.api.jobs.domain.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
  List<Offer> findAll();

  Offer findByTitle(String title);
}
