package ga.wawupc.api.jobs.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ga.wawupc.api.shared.mapping.EnhancedModelMapper;

@Configuration("offersMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public EnhancedModelMapper modelMapper() {
    return new EnhancedModelMapper();
  }

  @Bean
  public OfferMapper offerMapper() {
    return new OfferMapper();
  }
}
