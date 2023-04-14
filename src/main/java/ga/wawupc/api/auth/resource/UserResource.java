package ga.wawupc.api.auth.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
  private Long id;
  private String fullName;
  private String preferredName;
  private String email;
  private Date birthdate;
  private String location;
  private String biography;
  private String about;
}
