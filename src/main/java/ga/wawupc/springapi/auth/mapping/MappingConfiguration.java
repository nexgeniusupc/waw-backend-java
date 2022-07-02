package ga.wawupc.springapi.auth.mapping;

import ga.wawupc.springapi.auth.domain.model.entity.UserExperience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("usersMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public UserMapper userMapper() {
    return new UserMapper();
  }

  @Bean
  public UserExperienceMapper userExperienceMapper() { return new UserExperienceMapper();}
}
