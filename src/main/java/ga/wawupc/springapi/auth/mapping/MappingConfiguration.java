package ga.wawupc.springapi.auth.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("usersConfiguration")
public class MappingConfiguration {
  @Bean
  public UserMapper userMapper(){
    return new UserMapper();
  }
}
