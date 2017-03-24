/**
 * DT_REQUEST_PROVEDOR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package extranet_sgto_ordenes_compra.familia;


/**
 * Parametros entrada consulta proveedor
 */
public class DT_REQUEST_PROVEDOR  implements java.io.Serializable {
    private extranet_sgto_ordenes_compra.familia.DT_CON_PROV PROVEEDOR;

    public DT_REQUEST_PROVEDOR() {
    }

    public DT_REQUEST_PROVEDOR(
           extranet_sgto_ordenes_compra.familia.DT_CON_PROV PROVEEDOR) {
           this.PROVEEDOR = PROVEEDOR;
    }


    /**
     * Gets the PROVEEDOR value for this DT_REQUEST_PROVEDOR.
     * 
     * @return PROVEEDOR
     */
    public extranet_sgto_ordenes_compra.familia.DT_CON_PROV getPROVEEDOR() {
        return PROVEEDOR;
    }


    /**
     * Sets the PROVEEDOR value for this DT_REQUEST_PROVEDOR.
     * 
     * @param PROVEEDOR
     */
    public void setPROVEEDOR(extranet_sgto_ordenes_compra.familia.DT_CON_PROV PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DT_REQUEST_PROVEDOR)) return false;
        DT_REQUEST_PROVEDOR other = (DT_REQUEST_PROVEDOR) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PROVEEDOR==null && other.getPROVEEDOR()==null) || 
             (this.PROVEEDOR!=null &&
              this.PROVEEDOR.equals(other.getPROVEEDOR())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPROVEEDOR() != null) {
            _hashCode += getPROVEEDOR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DT_REQUEST_PROVEDOR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_REQUEST_PROVEDOR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROVEEDOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROVEEDOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_CON_PROV"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
