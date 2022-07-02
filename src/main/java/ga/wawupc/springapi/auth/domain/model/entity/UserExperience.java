package ga.wawupc.springapi.auth.domain.model.entity;

import ga.wawupc.springapi.employers.domain.model.entity.Company;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserExperience {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false, unique = true)
  private String title;

  @Column(length = 50, nullable = false)
  private String location;

  @Column(nullable = false)
  private Date startDate;

  @Column(nullable = false)
  private Date endDate;

  @Column(length = 100, nullable = false)
  private String timeDiff;

  @Column(length = 500, nullable = false)
  private String description;

  // Relationships
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "company_id",nullable = false)
  private Company company;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
