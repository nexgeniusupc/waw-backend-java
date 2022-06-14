package ga.wawupc.springapi.jobs.resource;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfferRequest {

  @NotNull
  @NotBlank
  @Size(max=200)
  private String title;
  @NotNull
  @NotBlank
  @Size(max=700)
  private String image;
  @NotNull
  @NotBlank
  private String description;

  @Size(max=400)
  private String salaryRange;
  @NotNull
  @NotBlank
  private Boolean status;
}
