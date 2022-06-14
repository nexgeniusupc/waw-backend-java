package ga.wawupc.springapi.auth.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  private String fullName;

  @NotNull
  @NotBlank
  private String preferredName;

  @NotNull
  @NotBlank
  private String email;

  @NotNull
  @NotBlank
  private Date birthdate;

  private String location;

  private String biography;

  private String about;
}
