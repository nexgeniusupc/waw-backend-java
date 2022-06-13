package ga.wawupc.springapi.shared.domain.service.communication;

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
