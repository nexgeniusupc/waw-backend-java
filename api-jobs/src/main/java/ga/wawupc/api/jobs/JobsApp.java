package ga.wawupc.api.jobs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
public class JobsApp {
  public static void main(String[] args) {
    SpringApplication.run(JobsApp.class, args);
  }
}
