package ga.wawupc.springapi.employers.mapping;

import ga.wawupc.springapi.employers.domain.model.entity.Company;
import ga.wawupc.springapi.employers.resource.CompanyResource;
import ga.wawupc.springapi.employers.resource.CreateCompanyResource;
import ga.wawupc.springapi.employers.resource.UpdateCompanyResource;
import ga.wawupc.springapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CompanyMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public CompanyResource toResource(Company model){
    return mapper.map(model, CompanyResource.class);
  }

  public Page<CompanyResource> modelListPage(List<Company> modelList, Pageable pageable){
    return new PageImpl<>(mapper.mapList(modelList, CompanyResource.class), pageable, modelList.size());
  }

  public Company toModel(CreateCompanyResource resource){
    return mapper.map(resource, Company.class);
  }

  public Company toModel(UpdateCompanyResource resource){
    return mapper.map(resource, Company.class);
  }
}
