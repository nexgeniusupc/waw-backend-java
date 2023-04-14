package ga.wawupc.api.jobs.domain.model.entity;

import ga.wawupc.api.shared.domain.model.AuditModel;
import lombok.*;

import jakarta.persistence.*;

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

  @Column(length = 200, nullable = false, unique = true)
  private String title;

  @Column(length = 2000)
  private String image;

  @Column(length = 4000, nullable = false)
  private String description;

  @Column(length = 50)
  private String salaryRange;

  @Column(nullable = false)
  private Boolean status;
}
