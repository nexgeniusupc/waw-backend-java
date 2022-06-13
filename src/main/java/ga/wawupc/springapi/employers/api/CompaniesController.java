package ga.wawupc.springapi.employers.api;

import ga.wawupc.springapi.employers.domain.persistence.CompanyRepository;
import ga.wawupc.springapi.employers.domain.service.CompanyService;
import ga.wawupc.springapi.employers.mapping.CompanyMapper;
import ga.wawupc.springapi.employers.resource.CompanyResource;
import ga.wawupc.springapi.employers.resource.CreateCompanyResource;
import ga.wawupc.springapi.employers.resource.UpdateCompanyResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CompaniesController {
  private final CompanyService service;
  private final CompanyMapper mapper;

  public CompaniesController(CompanyService service, CompanyMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  public Page<CompanyResource> getAllCompanies(Pageable pageable){
    return mapper.modelListPage(service.getAll(), pageable);
  }

  @GetMapping("{id}")
  public CompanyResource getCompanyById(@PathVariable Long id){
    return mapper.toResource(service.getById(id));
  }

  @PostMapping
  public CompanyResource createCompany(@RequestBody CreateCompanyResource company){
    return mapper.toResource(service.create(mapper.toModel(company)));
  }

  @PutMapping("{id}")
  public CompanyResource updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyResource company){
    return mapper.toResource(service.update(id, mapper.toModel(company)));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable Long id){
    return service.delete(id);
  }
}
