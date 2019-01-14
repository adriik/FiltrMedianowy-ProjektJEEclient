package projekt_plichta_jee_srvr;

public class UploadProxy implements projekt_plichta_jee_srvr.Upload {
  private String _endpoint = null;
  private projekt_plichta_jee_srvr.Upload upload = null;
  
  public UploadProxy() {
    _initUploadProxy();
  }
  
  public UploadProxy(String endpoint) {
    _endpoint = endpoint;
    _initUploadProxy();
  }
  
  private void _initUploadProxy() {
    try {
      upload = (new projekt_plichta_jee_srvr.UploadServiceLocator()).getUpload();
      if (upload != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)upload)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)upload)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (upload != null)
      ((javax.xml.rpc.Stub)upload)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public projekt_plichta_jee_srvr.Upload getUpload() {
    if (upload == null)
      _initUploadProxy();
    return upload;
  }
  
  public byte[] upload(java.lang.String fileName, byte[] imageBytes) throws java.rmi.RemoteException{
    if (upload == null)
      _initUploadProxy();
    return upload.upload(fileName, imageBytes);
  }
  
  
}