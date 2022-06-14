package ga.wawupc.springapi.auth.model.entity.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class UpdateUserResource {
private Long id;

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
  @Size(max = 256)
  private String email;

  @NotNull
  @NotBlank
  @Size(max = 10)
  private Date birthdate;

  @NotNull
  @NotBlank
  @Size(max = 256)
  private String location;

  @Size(max = 256)
  private String biography;

  @Size(max = 256)
  private String about;
}
