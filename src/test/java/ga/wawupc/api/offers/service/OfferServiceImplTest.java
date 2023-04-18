package ga.wawupc.api.offers.service;


import ga.wawupc.api.jobs.domain.persistence.OfferRepository;
import ga.wawupc.api.jobs.service.OfferServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OfferServiceUnitTest {
  @Mock
  private OfferRepository repository;
  @InjectMocks
  private OfferServiceImpl service;
}
