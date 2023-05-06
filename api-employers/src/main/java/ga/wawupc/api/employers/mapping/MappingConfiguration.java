package ga.wawupc.api.employers.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ga.wawupc.api.shared.mapping.EnhancedModelMapper;

@Configuration("companiesMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public EnhancedModelMapper modelMapper() {
    return new EnhancedModelMapper();
  }

  @Bean
  public CompanyMapper companyMapper() {
    return new CompanyMapper();
  }
}
