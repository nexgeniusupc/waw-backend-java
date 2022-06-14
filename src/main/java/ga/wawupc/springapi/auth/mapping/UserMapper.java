package ga.wawupc.springapi.auth.mapping;

import ga.wawupc.springapi.auth.domain.model.entity.User;
import ga.wawupc.springapi.auth.resource.UserRequest;
import ga.wawupc.springapi.auth.resource.UserResource;
import ga.wawupc.springapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public UserResource toResource(User model) {
    return mapper.map(model, UserResource.class);
  }

  public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
    return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
  }

  public User toModel(UserRequest resource) {
    return mapper.map(resource, User.class);
  }
}
