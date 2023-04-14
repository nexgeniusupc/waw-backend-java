package ga.wawupc.springapi.employers.resource;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


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
