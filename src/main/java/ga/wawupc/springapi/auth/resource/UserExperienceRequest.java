package ga.wawupc.springapi.auth.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserExperienceRequest {
  @NotNull
  @NotBlank
  @Size(max = 100)
  private String title;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String location;

  @NotNull
  @NotBlank
  private Date startDate;

  @NotNull
  @NotBlank
  private Date endDate;

  @NotNull
  @NotBlank
  @Size(max = 100)
  private String timeDiff;

  @NotNull
  @NotBlank
  @Size(max = 500)
  private String description;

  @NotNull
  @NotBlank
  private long companyId;
}
