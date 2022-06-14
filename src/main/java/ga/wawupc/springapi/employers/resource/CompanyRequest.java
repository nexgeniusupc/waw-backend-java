package ga.wawupc.springapi.employers.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {
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
