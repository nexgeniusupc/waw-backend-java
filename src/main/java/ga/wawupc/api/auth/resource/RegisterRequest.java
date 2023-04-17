package ga.wawupc.api.auth.resource;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest extends UserRequest {
  @NotNull
  @NotBlank
  private String password;
}
