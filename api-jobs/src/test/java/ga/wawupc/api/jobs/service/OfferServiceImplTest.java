package ga.wawupc.api.jobs.service;


import ga.wawupc.api.jobs.domain.model.entity.Offer;
import ga.wawupc.api.jobs.domain.persistence.OfferRepository;
import ga.wawupc.api.jobs.service.OfferServiceImpl;

import ga.wawupc.api.shared.exception.ResourceValidationException;

import jakarta.validation.Validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OfferServiceUnitTest {
  @Mock
  private OfferRepository repository;
  @Mock
  private Validator validator;
  @InjectMocks
  private OfferServiceImpl service;
  @Test
  public void createCompanyWithExistingNameShouldThrowException() {
    Offer offer1 = new Offer(1L, "Full Stack Developer" , "https://example.com/image.jpg","We're looking for a full stack developer with experience in Java and Angular.", "$125k-$127k", true);
    Offer offer2 = new Offer(2L, "Full Stack Developer" , "https://example.com/image.jpg","We're looking for a backend developer with experience in JavaScript and Vue.", "$200k-$250k", true);

    when(repository.findByTitle(offer1.getTitle())).thenReturn(offer1);

    when(validator.validate(offer2)).thenReturn(Collections.emptySet());

    Assertions.assertThrows(ResourceValidationException.class, () -> service.create(offer2));
  }
}
