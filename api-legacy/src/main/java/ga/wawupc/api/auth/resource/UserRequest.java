package ga.wawupc.api.auth.resource;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
  @NotNull
  @NotBlank
  @Size(max = 256)
  private String fullName;

  @NotNull
  @NotBlank
  @Size(max = 256)
  private String preferredName;

  @NotNull
  @NotBlank
  @Size(max = 254)
  private String email;

  @NotNull
  @NotBlank
  private Date birthdate;

  @NotNull
  @NotBlank
  @Size(max = 256)
  private String location;

  @Size(max = 500)
  private String biography;

  @Size(max = 256)
  private String about;
}
