package ga.wawupc.api.employers.domain.model.entity;

import ga.wawupc.api.shared.domain.model.AuditModel;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false, unique = true)
  private String name;

  @Column(length = 256)
  private String address;

  @Column(length = 256, nullable = false)
  private String email;
}
