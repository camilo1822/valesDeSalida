/**
 * DT_RESPONSE_PROVEEDOR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package extranet_sgto_ordenes_compra.familia;


/**
 * Datos consultados de proveedor
 */
public class DT_RESPONSE_PROVEEDOR  implements java.io.Serializable {
    private extranet_sgto_ordenes_compra.familia.DT_PROVEEDOR[] PROVEEDOR;

    private extranet_sgto_ordenes_compra.familia.DT_RETURN[] RESULT;

    public DT_RESPONSE_PROVEEDOR() {
    }

    public DT_RESPONSE_PROVEEDOR(
           extranet_sgto_ordenes_compra.familia.DT_PROVEEDOR[] PROVEEDOR,
           extranet_sgto_ordenes_compra.familia.DT_RETURN[] RESULT) {
           this.PROVEEDOR = PROVEEDOR;
           this.RESULT = RESULT;
    }


    /**
     * Gets the PROVEEDOR value for this DT_RESPONSE_PROVEEDOR.
     * 
     * @return PROVEEDOR
     */
    public extranet_sgto_ordenes_compra.familia.DT_PROVEEDOR[] getPROVEEDOR() {
        return PROVEEDOR;
    }


    /**
     * Sets the PROVEEDOR value for this DT_RESPONSE_PROVEEDOR.
     * 
     * @param PROVEEDOR
     */
    public void setPROVEEDOR(extranet_sgto_ordenes_compra.familia.DT_PROVEEDOR[] PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
    }

    public extranet_sgto_ordenes_compra.familia.DT_PROVEEDOR getPROVEEDOR(int i) {
        return this.PROVEEDOR[i];
    }

    public void setPROVEEDOR(int i, extranet_sgto_ordenes_compra.familia.DT_PROVEEDOR _value) {
        this.PROVEEDOR[i] = _value;
    }


    /**
     * Gets the RESULT value for this DT_RESPONSE_PROVEEDOR.
     * 
     * @return RESULT
     */
    public extranet_sgto_ordenes_compra.familia.DT_RETURN[] getRESULT() {
        return RESULT;
    }


    /**
     * Sets the RESULT value for this DT_RESPONSE_PROVEEDOR.
     * 
     * @param RESULT
     */
    public void setRESULT(extranet_sgto_ordenes_compra.familia.DT_RETURN[] RESULT) {
        this.RESULT = RESULT;
    }

    public extranet_sgto_ordenes_compra.familia.DT_RETURN getRESULT(int i) {
        return this.RESULT[i];
    }

    public void setRESULT(int i, extranet_sgto_ordenes_compra.familia.DT_RETURN _value) {
        this.RESULT[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DT_RESPONSE_PROVEEDOR)) return false;
        DT_RESPONSE_PROVEEDOR other = (DT_RESPONSE_PROVEEDOR) obj;
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
              java.util.Arrays.equals(this.PROVEEDOR, other.getPROVEEDOR()))) &&
            ((this.RESULT==null && other.getRESULT()==null) || 
             (this.RESULT!=null &&
              java.util.Arrays.equals(this.RESULT, other.getRESULT())));
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
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPROVEEDOR());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPROVEEDOR(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRESULT() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRESULT());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRESULT(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DT_RESPONSE_PROVEEDOR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_RESPONSE_PROVEEDOR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROVEEDOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PROVEEDOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_PROVEEDOR"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESULT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RESULT"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_RETURN"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
