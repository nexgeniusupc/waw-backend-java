package ga.wawupc.springapi.auth.service;

import ga.wawupc.springapi.auth.domain.model.entity.UserExperience;
import ga.wawupc.springapi.auth.domain.persistence.UserExperienceRepository;
import ga.wawupc.springapi.auth.domain.service.UserExperienceService;

import javax.validation.Validator;
import java.util.List;

public class UserExperienceServiceImpl implements UserExperienceService {
  private static final String ENTITY = "UserExperience";
  private final UserExperienceRepository repository;
  private final Validator validator;

  public UserExperienceServiceImpl(UserExperienceRepository repository, Validator validator) {
    this.repository = repository;
    this.validator = validator;
  }


  @Override
  public List<UserExperience> listByUserId(long userId) {
    return null;
  }

  @Override
  public UserExperience add(UserExperience request) {
    return null;
  }

  @Override
  public UserExperience update(long id, UserExperience request) {
    return null;
  }

  @Override
  public boolean remove(long id, long userId) {
    return false;
  }
}
