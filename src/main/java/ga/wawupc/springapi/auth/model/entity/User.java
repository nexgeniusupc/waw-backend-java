package ga.wawupc.springapi.auth.model.entity;


import ga.wawupc.springapi.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity

public class User extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  @Size(max= 256)
  @Column(unique = true)
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

  @NotNull
  @NotBlank
  private String location;

  private String biography;

  private String about;
}
