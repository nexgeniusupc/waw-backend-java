package ga.wawupc.api.employers.mapping;

import ga.wawupc.api.employers.domain.model.entity.Company;
import ga.wawupc.api.employers.resource.CompanyRequest;
import ga.wawupc.api.employers.resource.CompanyResource;
import ga.wawupc.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CompanyMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public CompanyResource toResource(Company model) {
    return mapper.map(model, CompanyResource.class);
  }

  public Page<CompanyResource> modelListPage(List<Company> modelList, Pageable pageable) {
    return new PageImpl<>(mapper.mapList(modelList, CompanyResource.class), pageable, modelList.size());
  }

  public Company toModel(CompanyRequest resource) {
    return mapper.map(resource, Company.class);
  }
}
