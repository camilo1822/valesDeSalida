package extranet_devoluciones_oc.familia;

public class SI_CONSULTA_MATERIALES_OUT_SProxy implements extranet_devoluciones_oc.familia.SI_CONSULTA_MATERIALES_OUT_S {
  private String _endpoint = null;
  private extranet_devoluciones_oc.familia.SI_CONSULTA_MATERIALES_OUT_S sI_CONSULTA_MATERIALES_OUT_S = null;
  
  public SI_CONSULTA_MATERIALES_OUT_SProxy() {
    _initSI_CONSULTA_MATERIALES_OUT_SProxy();
  }
  
  public SI_CONSULTA_MATERIALES_OUT_SProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_CONSULTA_MATERIALES_OUT_SProxy();
  }
  
  private void _initSI_CONSULTA_MATERIALES_OUT_SProxy() {
    try {
      sI_CONSULTA_MATERIALES_OUT_S = (new extranet_devoluciones_oc.familia.BSEXTRANET_SI_CONSULTA_MATERIALES_OUT_SLocator()).getHTTPS_Port();
      if (sI_CONSULTA_MATERIALES_OUT_S != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_CONSULTA_MATERIALES_OUT_S)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_CONSULTA_MATERIALES_OUT_S)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_CONSULTA_MATERIALES_OUT_S != null)
      ((javax.xml.rpc.Stub)sI_CONSULTA_MATERIALES_OUT_S)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public extranet_devoluciones_oc.familia.SI_CONSULTA_MATERIALES_OUT_S getSI_CONSULTA_MATERIALES_OUT_S() {
    if (sI_CONSULTA_MATERIALES_OUT_S == null)
      _initSI_CONSULTA_MATERIALES_OUT_SProxy();
    return sI_CONSULTA_MATERIALES_OUT_S;
  }
  
  public extranet_devoluciones_oc.familia.DT_MATERIAL[] SI_CONSULTA_MATERIALES_IN_S(extranet_devoluciones_oc.familia.DT_FCMM MT_FCMM) throws java.rmi.RemoteException{
    if (sI_CONSULTA_MATERIALES_OUT_S == null)
      _initSI_CONSULTA_MATERIALES_OUT_SProxy();
    return sI_CONSULTA_MATERIALES_OUT_S.SI_CONSULTA_MATERIALES_IN_S(MT_FCMM);
  }
  
  
}