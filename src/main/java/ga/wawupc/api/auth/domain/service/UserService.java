package ga.wawupc.api.auth.domain.service;

import ga.wawupc.api.auth.resource.AuthenticateRequest;
import ga.wawupc.api.auth.resource.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  ResponseEntity<?> authenticate(AuthenticateRequest request);

  ResponseEntity<?> register(RegisterRequest request);
}
