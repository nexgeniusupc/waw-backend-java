package ga.wawupc.springapi.jobs.domain.model.entity;

import ga.wawupc.springapi.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offers")
public class Offer extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  @Size(max = 200)
  @Column(unique = true)
  private String title;

  @NotNull
  @NotBlank
  @Size(max = 2000)
  private String image;

  @NotNull
  @NotBlank
  @Size(max = 2048)
  private String description;

  @Size(max = 50)
  private String salaryRange;

  @NotNull
  @NotBlank
  private Boolean status;
}
