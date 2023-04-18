package ga.wawupc.api.offers.services;
import ga.wawupc.api.jobs.domain.model.entity.Offer;
import ga.wawupc.api.jobs.domain.persistence.OfferRepository;
import ga.wawupc.api.jobs.service.OfferServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
public class OfferServiceImplTest {
  @Mock
  private OfferRepository offerRepository;
  @InjectMocks
  private OfferServiceImpl offerServiceImpl;
  Offer offer;

  @BeforeEach
  public void setUp(){
    offer = new Offer(1L, "Full Stack Developer" , "https://example.com/image.jpg","We're looking for a full stack developer with experience in Java and Angular.", "$125k-$127k", true);
  }
}
