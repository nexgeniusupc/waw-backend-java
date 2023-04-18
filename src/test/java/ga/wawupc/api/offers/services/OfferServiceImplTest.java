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
}
