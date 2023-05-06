package ga.wawupc.api.employers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
public class EmployersApp {
  public static void main(String[] args) {
    SpringApplication.run(EmployersApp.class, args);
  }
}
