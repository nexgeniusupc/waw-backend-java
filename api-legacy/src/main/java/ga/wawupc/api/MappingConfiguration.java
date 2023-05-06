package ga.wawupc.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ga.wawupc.api.shared.mapping.EnhancedModelMapper;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
  @Bean
  public EnhancedModelMapper modelMapper() {
    return new EnhancedModelMapper();
  }
}
