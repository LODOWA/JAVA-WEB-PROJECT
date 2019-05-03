package org;

public class KlasaProxy implements org.Klasa {
  private String _endpoint = null;
  private org.Klasa klasa = null;
  
  public KlasaProxy() {
    _initKlasaProxy();
  }
  
  public KlasaProxy(String endpoint) {
    _endpoint = endpoint;
    _initKlasaProxy();
  }
  
  private void _initKlasaProxy() {
    try {
      klasa = (new org.KlasaServiceLocator()).getKlasa();
      if (klasa != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)klasa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)klasa)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (klasa != null)
      ((javax.xml.rpc.Stub)klasa)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.Klasa getKlasa() {
    if (klasa == null)
      _initKlasaProxy();
    return klasa;
  }
  
  public java.lang.String image(java.lang.String base64String) throws java.rmi.RemoteException{
    if (klasa == null)
      _initKlasaProxy();
    return klasa.image(base64String);
  }
  
  public java.lang.String getAllFilles(int n) throws java.rmi.RemoteException{
    if (klasa == null)
      _initKlasaProxy();
    return klasa.getAllFilles(n);
  }
  
  public java.lang.Object decodeToImage(java.lang.String imageString) throws java.rmi.RemoteException{
    if (klasa == null)
      _initKlasaProxy();
    return klasa.decodeToImage(imageString);
  }
  
  
}