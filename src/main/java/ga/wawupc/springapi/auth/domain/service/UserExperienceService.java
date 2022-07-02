package ga.wawupc.springapi.auth.domain.service;

import ga.wawupc.springapi.auth.domain.model.entity.UserExperience;
import ga.wawupc.springapi.auth.resource.UserExperienceRequest;
import ga.wawupc.springapi.auth.resource.UserExperienceResource;

import java.util.List;

public interface UserExperienceService {
  List<UserExperience> listByUserId(long userId);
  UserExperience add(UserExperience request);
  UserExperience update(long id, UserExperience request);
  boolean remove(long id, long userId);
}
