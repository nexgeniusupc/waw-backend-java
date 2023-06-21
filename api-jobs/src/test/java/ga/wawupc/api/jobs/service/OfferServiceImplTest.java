package ga.wawupc.api.jobs.service;

import ga.wawupc.api.jobs.domain.model.entity.Offer;
import ga.wawupc.api.jobs.domain.persistence.OfferRepository;
import ga.wawupc.api.shared.exception.ResourceNotFoundException;
import ga.wawupc.api.shared.exception.ResourceValidationException;

import jakarta.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OfferServiceUnitTest {
  @Mock
  private OfferRepository repository;
  @Mock
  private Validator validator;
  @InjectMocks
  private OfferServiceImpl service;

  Offer offer;

  @BeforeEach
  public void setUp() {
    offer = new Offer(1L, "Full Stack Developer", "https://example.com/image.jpg",
        "We're looking for a full stack developer with experience in Java and Angular.", "$125k-$127k", true);
  }

  @Test
  public void createCompanyWithExistingNameShouldThrowException() {
    Offer newOffer = new Offer(2L, "Full Stack Developer", "https://example.com/image.jpg",
        "We're looking for a backend developer with experience in JavaScript and Vue.", "$200k-$250k", true);

    when(repository.findByTitle(offer.getTitle())).thenReturn(offer);

    when(validator.validate(newOffer)).thenReturn(Collections.emptySet());

    assertThrows(ResourceValidationException.class, () -> service.create(newOffer));
  }

  @Test
  public void findByIdShouldReturnSingleOffer() {
    when(repository.findById(1L)).thenReturn(Optional.of(offer));
    
    assertEquals(offer, service.getById(1L));
  }

  @Test
  public void findByIdNonExistingOfferShouldThrowException(){
    when(repository.findById(offer.getId())).thenReturn(Optional.empty());

    assertThrows(ResourceNotFoundException.class, () -> service.getById(offer.getId()));
  }
}
