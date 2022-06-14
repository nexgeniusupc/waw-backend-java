package ga.wawupc.springapi.jobs.resource;

import lombok.*;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor

public class OfferResource {

  private Long id;
  private String title;
  private String image;
  private String description;
  private String salaryRange;
  private Boolean status;

}
