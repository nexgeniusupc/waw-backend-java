package ga.wawupc.springapi.auth.resource;

import ga.wawupc.springapi.employers.domain.model.entity.Company;
import ga.wawupc.springapi.employers.resource.CompanyResource;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserExperienceResource {
  private Long id;
  private String title;
  private String location;
  private Date startDate;
  private Date endDate;
  private String timeDiff;
  private String description;
  private CompanyResource company;
}
