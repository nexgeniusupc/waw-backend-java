package ga.wawupc.springapi.jobs.resource;

import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OfferRequest {
  @NotNull
  @NotBlank
  @Size(max = 200)
  private String title;

  @NotNull
  @NotBlank
  @Size(max = 2000)
  private String image;

  @NotNull
  @NotBlank
  @Size(max = 2048)
  private String description;

  @Size(max = 50)
  private String salaryRange;

  @NotNull
  @NotBlank
  private Boolean status;
}
