package ga.wawupc.api.auth.domain.model.entity;

import ga.wawupc.api.shared.domain.model.AuditModel;
import lombok.*;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AuditModel implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 256, nullable = false)
  private String fullName;

  @Column(length = 256, nullable = false)
  private String preferredName;

  @Column(length = 254, nullable = false)
  private String email;

  @Column(nullable = false)
  private Date birthdate;

  @Column(length = 256)
  private String location;

  @Column(length = 500)
  private String biography;

  @Column(length = 256)
  private String about;

  @Column(length = 60, nullable = false)
  private String password;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("USER"));
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
