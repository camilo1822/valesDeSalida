/**
 * DT_CON_PROV.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package extranet_sgto_ordenes_compra.familia;


/**
 * Datos para consulta de proveedor
 */
public class DT_CON_PROV  implements java.io.Serializable {
    private java.lang.String COD_PROV;

    private java.lang.String SOCIEDAD;

    private java.lang.String PAIS;

    private java.lang.String NOMBRE;

    private java.lang.String NIT;

    public DT_CON_PROV() {
    }

    public DT_CON_PROV(
           java.lang.String COD_PROV,
           java.lang.String SOCIEDAD,
           java.lang.String PAIS,
           java.lang.String NOMBRE,
           java.lang.String NIT) {
           this.COD_PROV = COD_PROV;
           this.SOCIEDAD = SOCIEDAD;
           this.PAIS = PAIS;
           this.NOMBRE = NOMBRE;
           this.NIT = NIT;
    }


    /**
     * Gets the COD_PROV value for this DT_CON_PROV.
     * 
     * @return COD_PROV
     */
    public java.lang.String getCOD_PROV() {
        return COD_PROV;
    }


    /**
     * Sets the COD_PROV value for this DT_CON_PROV.
     * 
     * @param COD_PROV
     */
    public void setCOD_PROV(java.lang.String COD_PROV) {
        this.COD_PROV = COD_PROV;
    }


    /**
     * Gets the SOCIEDAD value for this DT_CON_PROV.
     * 
     * @return SOCIEDAD
     */
    public java.lang.String getSOCIEDAD() {
        return SOCIEDAD;
    }


    /**
     * Sets the SOCIEDAD value for this DT_CON_PROV.
     * 
     * @param SOCIEDAD
     */
    public void setSOCIEDAD(java.lang.String SOCIEDAD) {
        this.SOCIEDAD = SOCIEDAD;
    }


    /**
     * Gets the PAIS value for this DT_CON_PROV.
     * 
     * @return PAIS
     */
    public java.lang.String getPAIS() {
        return PAIS;
    }


    /**
     * Sets the PAIS value for this DT_CON_PROV.
     * 
     * @param PAIS
     */
    public void setPAIS(java.lang.String PAIS) {
        this.PAIS = PAIS;
    }


    /**
     * Gets the NOMBRE value for this DT_CON_PROV.
     * 
     * @return NOMBRE
     */
    public java.lang.String getNOMBRE() {
        return NOMBRE;
    }


    /**
     * Sets the NOMBRE value for this DT_CON_PROV.
     * 
     * @param NOMBRE
     */
    public void setNOMBRE(java.lang.String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }


    /**
     * Gets the NIT value for this DT_CON_PROV.
     * 
     * @return NIT
     */
    public java.lang.String getNIT() {
        return NIT;
    }


    /**
     * Sets the NIT value for this DT_CON_PROV.
     * 
     * @param NIT
     */
    public void setNIT(java.lang.String NIT) {
        this.NIT = NIT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DT_CON_PROV)) return false;
        DT_CON_PROV other = (DT_CON_PROV) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.COD_PROV==null && other.getCOD_PROV()==null) || 
             (this.COD_PROV!=null &&
              this.COD_PROV.equals(other.getCOD_PROV()))) &&
            ((this.SOCIEDAD==null && other.getSOCIEDAD()==null) || 
             (this.SOCIEDAD!=null &&
              this.SOCIEDAD.equals(other.getSOCIEDAD()))) &&
            ((this.PAIS==null && other.getPAIS()==null) || 
             (this.PAIS!=null &&
              this.PAIS.equals(other.getPAIS()))) &&
            ((this.NOMBRE==null && other.getNOMBRE()==null) || 
             (this.NOMBRE!=null &&
              this.NOMBRE.equals(other.getNOMBRE()))) &&
            ((this.NIT==null && other.getNIT()==null) || 
             (this.NIT!=null &&
              this.NIT.equals(other.getNIT())));
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
        if (getCOD_PROV() != null) {
            _hashCode += getCOD_PROV().hashCode();
        }
        if (getSOCIEDAD() != null) {
            _hashCode += getSOCIEDAD().hashCode();
        }
        if (getPAIS() != null) {
            _hashCode += getPAIS().hashCode();
        }
        if (getNOMBRE() != null) {
            _hashCode += getNOMBRE().hashCode();
        }
        if (getNIT() != null) {
            _hashCode += getNIT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DT_CON_PROV.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_CON_PROV"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COD_PROV");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COD_PROV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOCIEDAD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SOCIEDAD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAIS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NOMBRE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NIT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NIT"));
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
