package ga.wawupc.api.jobs.mapping;

import ga.wawupc.api.jobs.domain.model.entity.Offer;
import ga.wawupc.api.jobs.resource.OfferRequest;
import ga.wawupc.api.jobs.resource.OfferResource;
import ga.wawupc.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class OfferMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public OfferResource toResource(Offer model) {
    return mapper.map(model, OfferResource.class);
  }

  public Page<OfferResource> modelListPage(List<Offer> modelList, Pageable pageable) {
    return new PageImpl<>(mapper.mapList(modelList, OfferResource.class), pageable, modelList.size());
  }

  public Offer toModel(OfferRequest resource) {
    return mapper.map(resource, Offer.class);
  }

}
