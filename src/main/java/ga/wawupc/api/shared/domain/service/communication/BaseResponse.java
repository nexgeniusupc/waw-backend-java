package ga.wawupc.api.shared.domain.service.communication;

import lombok.Getter;

@Getter
public abstract class BaseResponse<T> {
  private boolean success;
  private String message;
  private T resource;

  protected BaseResponse(String message) {
    this.success = false;
    this.message = message;
    this.resource = null;
  }

  protected BaseResponse(T resource) {
    this.success = true;
    this.message = "";
    this.resource = resource;
  }
}
