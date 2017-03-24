/**
 * DT_MATERIAL.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package extranet_devoluciones_oc.familia;


/**
 * DT Material
 */
public class DT_MATERIAL  implements java.io.Serializable {
    private java.lang.String CODIGO;

    private java.lang.String DESCRIPCION;

    private java.lang.String CENTRO;

    private java.lang.String TIPO;

    private java.lang.String UMB;

    private java.lang.String VALOR;

    public DT_MATERIAL() {
    }

    public DT_MATERIAL(
           java.lang.String CODIGO,
           java.lang.String DESCRIPCION,
           java.lang.String CENTRO,
           java.lang.String TIPO,
           java.lang.String UMB,
           java.lang.String VALOR) {
           this.CODIGO = CODIGO;
           this.DESCRIPCION = DESCRIPCION;
           this.CENTRO = CENTRO;
           this.TIPO = TIPO;
           this.UMB = UMB;
           this.VALOR = VALOR;
    }


    /**
     * Gets the CODIGO value for this DT_MATERIAL.
     * 
     * @return CODIGO
     */
    public java.lang.String getCODIGO() {
        return CODIGO;
    }


    /**
     * Sets the CODIGO value for this DT_MATERIAL.
     * 
     * @param CODIGO
     */
    public void setCODIGO(java.lang.String CODIGO) {
        this.CODIGO = CODIGO;
    }


    /**
     * Gets the DESCRIPCION value for this DT_MATERIAL.
     * 
     * @return DESCRIPCION
     */
    public java.lang.String getDESCRIPCION() {
        return DESCRIPCION;
    }


    /**
     * Sets the DESCRIPCION value for this DT_MATERIAL.
     * 
     * @param DESCRIPCION
     */
    public void setDESCRIPCION(java.lang.String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }


    /**
     * Gets the CENTRO value for this DT_MATERIAL.
     * 
     * @return CENTRO
     */
    public java.lang.String getCENTRO() {
        return CENTRO;
    }


    /**
     * Sets the CENTRO value for this DT_MATERIAL.
     * 
     * @param CENTRO
     */
    public void setCENTRO(java.lang.String CENTRO) {
        this.CENTRO = CENTRO;
    }


    /**
     * Gets the TIPO value for this DT_MATERIAL.
     * 
     * @return TIPO
     */
    public java.lang.String getTIPO() {
        return TIPO;
    }


    /**
     * Sets the TIPO value for this DT_MATERIAL.
     * 
     * @param TIPO
     */
    public void setTIPO(java.lang.String TIPO) {
        this.TIPO = TIPO;
    }


    /**
     * Gets the UMB value for this DT_MATERIAL.
     * 
     * @return UMB
     */
    public java.lang.String getUMB() {
        return UMB;
    }


    /**
     * Sets the UMB value for this DT_MATERIAL.
     * 
     * @param UMB
     */
    public void setUMB(java.lang.String UMB) {
        this.UMB = UMB;
    }


    /**
     * Gets the VALOR value for this DT_MATERIAL.
     * 
     * @return VALOR
     */
    public java.lang.String getVALOR() {
        return VALOR;
    }


    /**
     * Sets the VALOR value for this DT_MATERIAL.
     * 
     * @param VALOR
     */
    public void setVALOR(java.lang.String VALOR) {
        this.VALOR = VALOR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DT_MATERIAL)) return false;
        DT_MATERIAL other = (DT_MATERIAL) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CODIGO==null && other.getCODIGO()==null) || 
             (this.CODIGO!=null &&
              this.CODIGO.equals(other.getCODIGO()))) &&
            ((this.DESCRIPCION==null && other.getDESCRIPCION()==null) || 
             (this.DESCRIPCION!=null &&
              this.DESCRIPCION.equals(other.getDESCRIPCION()))) &&
            ((this.CENTRO==null && other.getCENTRO()==null) || 
             (this.CENTRO!=null &&
              this.CENTRO.equals(other.getCENTRO()))) &&
            ((this.TIPO==null && other.getTIPO()==null) || 
             (this.TIPO!=null &&
              this.TIPO.equals(other.getTIPO()))) &&
            ((this.UMB==null && other.getUMB()==null) || 
             (this.UMB!=null &&
              this.UMB.equals(other.getUMB()))) &&
            ((this.VALOR==null && other.getVALOR()==null) || 
             (this.VALOR!=null &&
              this.VALOR.equals(other.getVALOR())));
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
        if (getCODIGO() != null) {
            _hashCode += getCODIGO().hashCode();
        }
        if (getDESCRIPCION() != null) {
            _hashCode += getDESCRIPCION().hashCode();
        }
        if (getCENTRO() != null) {
            _hashCode += getCENTRO().hashCode();
        }
        if (getTIPO() != null) {
            _hashCode += getTIPO().hashCode();
        }
        if (getUMB() != null) {
            _hashCode += getUMB().hashCode();
        }
        if (getVALOR() != null) {
            _hashCode += getVALOR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DT_MATERIAL.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_devoluciones_oc", "DT_MATERIAL"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODIGO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CODIGO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESCRIPCION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DESCRIPCION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CENTRO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CENTRO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TIPO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UMB");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UMB"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VALOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VALOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
