package ga.wawupc.springapi.employers.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("employersConfiguration")
public class MappingConfiguration {
  @Bean
  public CompanyMapper companyMapper(){
    return new CompanyMapper();
  }

}
