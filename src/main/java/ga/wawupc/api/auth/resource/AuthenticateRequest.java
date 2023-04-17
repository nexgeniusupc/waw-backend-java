package ga.wawupc.api.auth.resource;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class AuthenticateRequest {
  @NotNull
  @NotBlank
  @Size(max = 254)
  private String email;

  @NotNull
  @NotBlank
  private String password;
}
