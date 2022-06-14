package ga.wawupc.springapi.jobs.domain.persistence;

import ga.wawupc.springapi.jobs.domain.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
  List<Offer> findAll();
  Offer findByTitle(String title);
}
