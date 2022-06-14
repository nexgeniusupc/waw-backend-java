package ga.wawupc.springapi.jobs.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("offersConfiguration")
public class MappingConfiguration {
  @Bean
  public OfferMapper companyMapper(){
    return new OfferMapper();
  }
}
