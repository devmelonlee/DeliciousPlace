package devmelonlee.delicious_place.config;

public class NaverMapsConfig {

  private String clientId = System.getProperty("clientId");

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }


}
