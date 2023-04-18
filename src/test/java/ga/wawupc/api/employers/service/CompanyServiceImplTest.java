package ga.wawupc.api.employers.service;

import ga.wawupc.api.employers.domain.model.entity.Company;
import ga.wawupc.api.employers.domain.persistence.CompanyRepository;
import ga.wawupc.api.shared.exception.ResourceValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceUnitTest {
  @Mock
  private CompanyRepository repository;
  @InjectMocks
  private CompanyServiceImpl service;
  @Test
  public void getAllShouldReturnCompaniesList() {
    Company firstCompany = new Company(1L,"Google Inc.", "Silicon Valley", "google@dev.com");
    Company secondCompany = new Company(1L,"Amazon Inc.", "Silicon Valley", "amazon@dev.com");
    Company thirdCompany = new Company(1L,"Apple Inc.", "Silicon Valley", "apple@dev.com");

    when(repository.findAll()).thenReturn(List.of(firstCompany, secondCompany, thirdCompany));

    List<Company> companies = service.getAll();

    Assertions.assertEquals(List.of(firstCompany, secondCompany, thirdCompany), companies);
    verify(repository).findAll();

  }
}
