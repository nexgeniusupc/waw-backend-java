package ga.wawupc.springapi.employers.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResource {
  private Long id;
  private String name;
  private String address;
  private String email;
}
