package ga.wawupc.springapi.jobs.domain.persistence;

import ga.wawupc.springapi.jobs.domain.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer,Long> {
  List<Offer> findAll();
  Offer findByTitle(String title);
}
