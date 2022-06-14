package ga.wawupc.springapi.jobs.api;

import ga.wawupc.springapi.jobs.domain.service.OfferService;
import ga.wawupc.springapi.jobs.mapping.OfferMapper;
import ga.wawupc.springapi.jobs.resource.OfferRequest;
import ga.wawupc.springapi.jobs.resource.OfferResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {
  private final OfferService service;
  private final OfferMapper mapper;

  public OfferController(OfferService service, OfferMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  public Page<OfferResource> getAllCompanies(Pageable pageable) {
    return mapper.modelListPage(service.getAll(), pageable);
  }

  @GetMapping("{id}")
  public OfferResource getCompanyById(@PathVariable Long id) {
    return mapper.toResource(service.getById(id));
  }

  @PostMapping
  public OfferResource createCompany(@RequestBody OfferRequest offer) {
    return mapper.toResource(service.create(mapper.toModel(offer)));
  }

  @PutMapping("{id}")
  public OfferResource updateCompany(@PathVariable Long id, @RequestBody OfferRequest offer) {
    return mapper.toResource(service.update(id, mapper.toModel(offer)));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
    return service.delete(id);
  }
}
