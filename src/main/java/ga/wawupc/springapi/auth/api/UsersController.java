package ga.wawupc.springapi.auth.api;

import ga.wawupc.springapi.auth.domain.service.UserService;
import ga.wawupc.springapi.auth.mapping.UserMapper;
import ga.wawupc.springapi.auth.model.entity.resource.CreateUserResource;
import ga.wawupc.springapi.auth.model.entity.resource.UpdateUserResource;
import ga.wawupc.springapi.auth.model.entity.resource.UserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UsersController {
  private final UserService service;
  private final UserMapper mapper;

  public UsersController(UserService service, UserMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  public Page<UserResource> getAllUser(Pageable pageable){
    return mapper.modelListPage(service.getAll(), pageable);
  }

  @GetMapping("{id}")
  public UserResource getUserById(@PathVariable Long id){
    return mapper.toResource(service.getById(id));
  }

  @PostMapping
  public UserResource createCompany(@RequestBody CreateUserResource user){
    return mapper.toResource(service.create(mapper.toModel(user)));
  }

  @PutMapping("{id}")
  public UserResource updateCompany(@PathVariable Long id, @RequestBody UpdateUserResource user){
    return mapper.toResource(service.update(id, mapper.toModel(user)));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable Long id){
    return service.delete(id);
  }
}
