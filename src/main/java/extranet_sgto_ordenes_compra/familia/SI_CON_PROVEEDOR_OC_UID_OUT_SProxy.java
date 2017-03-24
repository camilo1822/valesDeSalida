package extranet_sgto_ordenes_compra.familia;

public class SI_CON_PROVEEDOR_OC_UID_OUT_SProxy implements extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_S {
  private String _endpoint = null;
  private extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_S sI_CON_PROVEEDOR_OC_UID_OUT_S = null;
  
  public SI_CON_PROVEEDOR_OC_UID_OUT_SProxy() {
    _initSI_CON_PROVEEDOR_OC_UID_OUT_SProxy();
  }
  
  public SI_CON_PROVEEDOR_OC_UID_OUT_SProxy(String endpoint) {
    _endpoint = endpoint;
    _initSI_CON_PROVEEDOR_OC_UID_OUT_SProxy();
  }
  
  private void _initSI_CON_PROVEEDOR_OC_UID_OUT_SProxy() {
    try {
      sI_CON_PROVEEDOR_OC_UID_OUT_S = (new extranet_sgto_ordenes_compra.familia.BSEXTRANET_SI_CON_PROVEEDOR_OC_UID_OUT_SLocator()).getHTTPS_Port();
      if (sI_CON_PROVEEDOR_OC_UID_OUT_S != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sI_CON_PROVEEDOR_OC_UID_OUT_S)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sI_CON_PROVEEDOR_OC_UID_OUT_S)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sI_CON_PROVEEDOR_OC_UID_OUT_S != null)
      ((javax.xml.rpc.Stub)sI_CON_PROVEEDOR_OC_UID_OUT_S)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public extranet_sgto_ordenes_compra.familia.SI_CON_PROVEEDOR_OC_UID_OUT_S getSI_CON_PROVEEDOR_OC_UID_OUT_S() {
    if (sI_CON_PROVEEDOR_OC_UID_OUT_S == null)
      _initSI_CON_PROVEEDOR_OC_UID_OUT_SProxy();
    return sI_CON_PROVEEDOR_OC_UID_OUT_S;
  }
  
  public extranet_sgto_ordenes_compra.familia.DT_RESPONSE_PROVEEDOR SI_CON_PROVEEDOR_OC_UID_OUT_S(extranet_sgto_ordenes_compra.familia.DT_REQUEST_PROVEDOR MT_DATA_CON_PROVEEDOR) throws java.rmi.RemoteException{
    if (sI_CON_PROVEEDOR_OC_UID_OUT_S == null)
      _initSI_CON_PROVEEDOR_OC_UID_OUT_SProxy();
    return sI_CON_PROVEEDOR_OC_UID_OUT_S.SI_CON_PROVEEDOR_OC_UID_OUT_S(MT_DATA_CON_PROVEEDOR);
  }
  
  
}