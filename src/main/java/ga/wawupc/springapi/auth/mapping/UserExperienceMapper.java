package ga.wawupc.springapi.auth.mapping;

import ga.wawupc.springapi.auth.domain.model.entity.UserExperience;
import ga.wawupc.springapi.auth.resource.UserExperienceResource;
import ga.wawupc.springapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserExperienceMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public UserExperienceResource toResource(UserExperience model) { return  mapper.map(model, UserExperienceResource.class); }
  public Page<UserExperienceResource> modelListPage(List<UserExperienceResource> modelList, Pageable pageable){
    return new PageImpl<>(mapper.mapList(modelList, UserExperienceResource.class), pageable, modelList.size());
  }
}
