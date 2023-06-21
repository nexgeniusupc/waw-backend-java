package ga.wawupc.api.jobs;

import ga.wawupc.api.jobs.domain.model.entity.Offer;
import ga.wawupc.api.jobs.domain.persistence.OfferRepository;
import ga.wawupc.api.jobs.resource.OfferRequest;
import ga.wawupc.api.shared.JsonUtil;

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
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class OffersIntegrationTest {

  @Autowired
  private MockMvc mvc;
  @Autowired
  private OfferRepository repository;
  private static final Offer firstTestOffer = new Offer(1L, "Vue Mid Sr. Developer",
      "https://example.com/images/full-stack-developer.png",
      "We're seeking a skilled full stack developer to join our team and help us build and maintain cutting-edge web applications. The ideal candidate will have experience with a range of technologies and be comfortable working in a fast-paced, agile environment.",
      "$80,000 - $120,000", true);
  private static final Offer secondTestOffer = new Offer(2L, "Software Engineer (React)",
      "https://example.com/images/frontend-engineer.png",
      "We're looking for a talented software engineer with a strong focus on frontend development to join our team. The ideal candidate will have experience building complex web applications with modern JavaScript frameworks, and a passion for creating beautiful and intuitive user interfaces.",
      "$90,000 - $140,000", true);
  private static final List<Offer> offers = Arrays.asList(firstTestOffer, secondTestOffer);

  @BeforeEach
  public void setupTest() {
    repository.saveAllAndFlush(offers);
  }

  @AfterEach
  public void teardownTest() {
    repository.deleteAll();
    repository.flush();
  }

  @Test
  public void getAllOffersIntegrationTest() throws Exception {
    RequestBuilder request = get("/api/v1/offers").contentType(MediaType.APPLICATION_JSON);

    mvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content", hasSize(2)))
        .andExpect(jsonPath("$.content[0].title", is(firstTestOffer.getTitle())))
        .andExpect(jsonPath("$.content[1].title", is(secondTestOffer.getTitle())));
  }

  @Test
  public void addOfferIntegrationTest() throws Exception {
    OfferRequest dataScientistOffer = new OfferRequest("Data Scientist",
        "https://example.com/images/data-scientist.png",
        "We're seeking a skilled data scientist to help us analyze and interpret complex datasets and develop machine learning models to drive business insights. The ideal candidate will have a strong background in statistics and programming, and experience working with large datasets",
        "$100,000 - $150,000 per year", true);

    RequestBuilder request = post("/api/v1/offers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtil.toJson(dataScientistOffer));

    mvc.perform(request)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title", is(dataScientistOffer.getTitle())));
  }

  @Test
  public void addOfferAlreadyExistingIntegrationTest() throws Exception {
    OfferRequest offer2 = new OfferRequest("Vue Mid Sr. Developer",
        "https://example.com/images/full-stack-developer.png",
        "We're seeking a skilled full stack developer to join our team and help us build and maintain cutting-edge web applications. The ideal candidate will have experience with a range of technologies and be comfortable working in a fast-paced, agile environment.",
        "$100,000 - $150,000 per year", true);

    RequestBuilder request = post("/api/v1/offers")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtil.toJson(offer2));

    mvc.perform(request).andExpect(status().isBadRequest());
  }
}
