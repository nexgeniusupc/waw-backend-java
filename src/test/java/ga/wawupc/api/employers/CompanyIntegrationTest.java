package ga.wawupc.api.employers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import ga.wawupc.api.JsonUtil;
import ga.wawupc.api.employers.domain.model.entity.Company;
import ga.wawupc.api.employers.domain.persistence.CompanyRepository;
import ga.wawupc.api.employers.resource.CompanyRequest;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CompanyIntegrationTest {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private CompanyRepository repository;

  private static final Company google = new Company(1L, "Google", "Mountain View", "support@google.com");
  private static final Company microsoft = new Company(2L, "Microsoft", "Redmont", "support@microsoft.com");
  private static final List<Company> companies = Arrays.asList(google, microsoft);

  @BeforeEach
  public void setupTest() {
    repository.saveAllAndFlush(companies);
  }

  @AfterEach
  public void teardownTest() {
    repository.deleteAll();
    repository.flush();
  }

  @Test
  public void getAllCompaniesIntegrationTest() throws Exception {
    RequestBuilder request = get("/api/v1/companies").contentType(MediaType.APPLICATION_JSON);

    mvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content", hasSize(2)))
        .andExpect(jsonPath("$.content[0].name", is(google.getName())))
        .andExpect(jsonPath("$.content[1].name", is(microsoft.getName())));
  }

  @Test
  public void addCompanyIntegrationTest() throws Exception {
    CompanyRequest netflix = new CompanyRequest("Netflix", "Los Gatos", "support@netflix.com");

    RequestBuilder request = post("/api/v1/companies")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtil.toJson(netflix));

    mvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(3)))
        .andExpect(jsonPath("$.name", is(netflix.getName())));
  }

  @Test
  public void addCompanyAlreadyExistingIntegrationTest() throws Exception {
    CompanyRequest google2 = new CompanyRequest("Google", "California", "webmaster@google.com");

    RequestBuilder request = post("/api/v1/companies")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtil.toJson(google2));

    mvc.perform(request).andExpect(status().isBadRequest());
  }

  @Test
  public void updateCompanyIntegrationTest() throws Exception {
    CompanyRequest update = new CompanyRequest("Google", "California", "webmaster@google.com");

    RequestBuilder request = put("/api/v1/companies/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtil.toJson(update));

    mvc.perform(request)
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id", is(1)))
      .andExpect(jsonPath("$.name", is(update.getName())))
      .andExpect(jsonPath("$.address", is(update.getAddress())))
      .andExpect(jsonPath("$.email", is(update.getEmail())));
  }
}
