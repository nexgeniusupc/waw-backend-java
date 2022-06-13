package ga.wawupc.springapi.employers.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCompanyResource {
  private Long id;

  @NotNull
  @NotBlank
  @Size(max = 100)
  private String name;

  @Size(max = 256)
  private String address;

  @NotNull
  @NotBlank
  @Size(max = 256)
  private String email;
}
