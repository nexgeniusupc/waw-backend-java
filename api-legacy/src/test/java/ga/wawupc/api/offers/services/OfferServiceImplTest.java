package ga.wawupc.api.offers.services;
import ga.wawupc.api.jobs.domain.model.entity.Offer;
import ga.wawupc.api.jobs.domain.persistence.OfferRepository;
import ga.wawupc.api.jobs.service.OfferServiceImpl;
import ga.wawupc.api.shared.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

  @Test
  public void FindByIdShouldReturnSingleOffer() {
    when(offerRepository.findById(1L)).thenReturn(Optional.of(offer));
    Offer response = offerServiceImpl.getById(1L);
    assertEquals(1L, response.getId());
    verify(offerRepository).findById(offer.getId());
  }

  @Test
  public void FindByIdNonExistingOfferShouldThrowException(){
    when(offerRepository.findById(offer.getId())).thenReturn(Optional.empty());

    Throwable exception =
      catchThrowable(() -> offerServiceImpl.getById(offer.getId()));
    assertThat(exception).isInstanceOf(ResourceNotFoundException.class);
  }
}
