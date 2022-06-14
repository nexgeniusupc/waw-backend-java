package ga.wawupc.springapi.auth.domain.service;

import ga.wawupc.springapi.auth.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
  List<User> getAll();

  Page<User> getAll(Pageable pageable);

  User getById(Long id);

  User create(User request);

  User update(Long id, User request);

  ResponseEntity<?> delete(Long id);
}
