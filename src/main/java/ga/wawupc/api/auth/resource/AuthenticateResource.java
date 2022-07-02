package ga.wawupc.api.auth.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateResource extends UserResource {
  private String token;
}
