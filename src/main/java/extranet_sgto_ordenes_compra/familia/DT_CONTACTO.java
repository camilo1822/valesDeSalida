/**
 * DT_CONTACTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package extranet_sgto_ordenes_compra.familia;


/**
 * Persona de contacto
 */
public class DT_CONTACTO  implements java.io.Serializable {
    private java.lang.String NOMBRES;

    private java.lang.String APELLIDOS;

    private java.lang.String TELEFONO;

    private java.lang.String CEDULA;

    public DT_CONTACTO() {
    }

    public DT_CONTACTO(
           java.lang.String NOMBRES,
           java.lang.String APELLIDOS,
           java.lang.String TELEFONO,
           java.lang.String CEDULA) {
           this.NOMBRES = NOMBRES;
           this.APELLIDOS = APELLIDOS;
           this.TELEFONO = TELEFONO;
           this.CEDULA = CEDULA;
    }


    /**
     * Gets the NOMBRES value for this DT_CONTACTO.
     * 
     * @return NOMBRES
     */
    public java.lang.String getNOMBRES() {
        return NOMBRES;
    }


    /**
     * Sets the NOMBRES value for this DT_CONTACTO.
     * 
     * @param NOMBRES
     */
    public void setNOMBRES(java.lang.String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }


    /**
     * Gets the APELLIDOS value for this DT_CONTACTO.
     * 
     * @return APELLIDOS
     */
    public java.lang.String getAPELLIDOS() {
        return APELLIDOS;
    }


    /**
     * Sets the APELLIDOS value for this DT_CONTACTO.
     * 
     * @param APELLIDOS
     */
    public void setAPELLIDOS(java.lang.String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }


    /**
     * Gets the TELEFONO value for this DT_CONTACTO.
     * 
     * @return TELEFONO
     */
    public java.lang.String getTELEFONO() {
        return TELEFONO;
    }


    /**
     * Sets the TELEFONO value for this DT_CONTACTO.
     * 
     * @param TELEFONO
     */
    public void setTELEFONO(java.lang.String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }


    /**
     * Gets the CEDULA value for this DT_CONTACTO.
     * 
     * @return CEDULA
     */
    public java.lang.String getCEDULA() {
        return CEDULA;
    }


    /**
     * Sets the CEDULA value for this DT_CONTACTO.
     * 
     * @param CEDULA
     */
    public void setCEDULA(java.lang.String CEDULA) {
        this.CEDULA = CEDULA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DT_CONTACTO)) return false;
        DT_CONTACTO other = (DT_CONTACTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.NOMBRES==null && other.getNOMBRES()==null) || 
             (this.NOMBRES!=null &&
              this.NOMBRES.equals(other.getNOMBRES()))) &&
            ((this.APELLIDOS==null && other.getAPELLIDOS()==null) || 
             (this.APELLIDOS!=null &&
              this.APELLIDOS.equals(other.getAPELLIDOS()))) &&
            ((this.TELEFONO==null && other.getTELEFONO()==null) || 
             (this.TELEFONO!=null &&
              this.TELEFONO.equals(other.getTELEFONO()))) &&
            ((this.CEDULA==null && other.getCEDULA()==null) || 
             (this.CEDULA!=null &&
              this.CEDULA.equals(other.getCEDULA())));
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
        if (getNOMBRES() != null) {
            _hashCode += getNOMBRES().hashCode();
        }
        if (getAPELLIDOS() != null) {
            _hashCode += getAPELLIDOS().hashCode();
        }
        if (getTELEFONO() != null) {
            _hashCode += getTELEFONO().hashCode();
        }
        if (getCEDULA() != null) {
            _hashCode += getCEDULA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DT_CONTACTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_CONTACTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NOMBRES");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRES"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("APELLIDOS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "APELLIDOS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TELEFONO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TELEFONO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CEDULA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CEDULA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
