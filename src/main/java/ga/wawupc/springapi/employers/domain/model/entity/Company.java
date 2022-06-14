package ga.wawupc.springapi.employers.domain.model.entity;

import ga.wawupc.springapi.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "companies")
public class Company extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  @Size(max = 100)
  @Column(unique = true)
  private String name;

  @Size(max = 256)
  private String address;

  @NotNull
  @NotBlank
  @Size(max = 256)
  private String email;
}
