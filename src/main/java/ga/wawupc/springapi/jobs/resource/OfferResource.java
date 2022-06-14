package ga.wawupc.springapi.jobs.resource;

import lombok.*;


public class OfferResource {
  @Getter
  @Setter
  @With
  @NoArgsConstructor
  @AllArgsConstructor
  public class CompanyResource {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String salaryRange;
    private Boolean status;
  }
}
