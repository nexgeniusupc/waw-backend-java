package ga.wawupc.springapi.auth.domain.service;

import ga.wawupc.springapi.auth.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
  List<User> getAll();
  Page<User> getAll(Pageable pageable);

  User getById(Long id);
  User create(User user);
  User update(Long id, User user);
  ResponseEntity<?> delete(Long id);
}
