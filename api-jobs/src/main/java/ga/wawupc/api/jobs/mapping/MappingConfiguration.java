package ga.wawupc.api.jobs.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("offersMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public OfferMapper offerMapper() {
    return new OfferMapper();
  }
}
