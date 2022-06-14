package ga.wawupc.springapi.jobs.mapping;

import ga.wawupc.springapi.jobs.domain.model.entity.Offer;
import ga.wawupc.springapi.jobs.resource.CreateOfferResource;
import ga.wawupc.springapi.jobs.resource.OfferResource;
import ga.wawupc.springapi.jobs.resource.UpdateOfferResource;
import ga.wawupc.springapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class OfferMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public OfferResource toResource(Offer model){
    return mapper.map(model, OfferResource.class);
  }

  public Page<OfferResource> modelListPage(List<Offer> modelList, Pageable pageable){
    return new PageImpl<>(mapper.mapList(modelList, OfferResource.class), pageable, modelList.size());
  }

  public Offer toModel(CreateOfferResource resource){
    return mapper.map(resource, Offer.class);
  }

  public Offer toModel(UpdateOfferResource resource){
    return mapper.map(resource, Offer.class);
  }
}
