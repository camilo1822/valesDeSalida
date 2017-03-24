/**
 * DT_PROVEEDOR.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package extranet_sgto_ordenes_compra.familia;


/**
 * Datos de proveedores
 */
public class DT_PROVEEDOR  implements java.io.Serializable {
    private java.lang.String COD_PROV;

    private java.lang.String NIT;

    private java.lang.String SOCIEDAD;

    private java.lang.String DEN_SOC;

    private java.lang.String PAIS;

    private java.lang.String DEN_PAIS;

    private java.lang.String NOMBRE;

    private java.lang.String CORREO;

    private java.lang.String DIRECCION;

    private java.lang.String CIUDAD;

    private extranet_sgto_ordenes_compra.familia.DT_CONTACTO[] CONTACTO;

    public DT_PROVEEDOR() {
    }

    public DT_PROVEEDOR(
           java.lang.String COD_PROV,
           java.lang.String NIT,
           java.lang.String SOCIEDAD,
           java.lang.String DEN_SOC,
           java.lang.String PAIS,
           java.lang.String DEN_PAIS,
           java.lang.String NOMBRE,
           java.lang.String CORREO,
           java.lang.String DIRECCION,
           java.lang.String CIUDAD,
           extranet_sgto_ordenes_compra.familia.DT_CONTACTO[] CONTACTO) {
           this.COD_PROV = COD_PROV;
           this.NIT = NIT;
           this.SOCIEDAD = SOCIEDAD;
           this.DEN_SOC = DEN_SOC;
           this.PAIS = PAIS;
           this.DEN_PAIS = DEN_PAIS;
           this.NOMBRE = NOMBRE;
           this.CORREO = CORREO;
           this.DIRECCION = DIRECCION;
           this.CIUDAD = CIUDAD;
           this.CONTACTO = CONTACTO;
    }


    /**
     * Gets the COD_PROV value for this DT_PROVEEDOR.
     * 
     * @return COD_PROV
     */
    public java.lang.String getCOD_PROV() {
        return COD_PROV;
    }


    /**
     * Sets the COD_PROV value for this DT_PROVEEDOR.
     * 
     * @param COD_PROV
     */
    public void setCOD_PROV(java.lang.String COD_PROV) {
        this.COD_PROV = COD_PROV;
    }


    /**
     * Gets the NIT value for this DT_PROVEEDOR.
     * 
     * @return NIT
     */
    public java.lang.String getNIT() {
        return NIT;
    }


    /**
     * Sets the NIT value for this DT_PROVEEDOR.
     * 
     * @param NIT
     */
    public void setNIT(java.lang.String NIT) {
        this.NIT = NIT;
    }


    /**
     * Gets the SOCIEDAD value for this DT_PROVEEDOR.
     * 
     * @return SOCIEDAD
     */
    public java.lang.String getSOCIEDAD() {
        return SOCIEDAD;
    }


    /**
     * Sets the SOCIEDAD value for this DT_PROVEEDOR.
     * 
     * @param SOCIEDAD
     */
    public void setSOCIEDAD(java.lang.String SOCIEDAD) {
        this.SOCIEDAD = SOCIEDAD;
    }


    /**
     * Gets the DEN_SOC value for this DT_PROVEEDOR.
     * 
     * @return DEN_SOC
     */
    public java.lang.String getDEN_SOC() {
        return DEN_SOC;
    }


    /**
     * Sets the DEN_SOC value for this DT_PROVEEDOR.
     * 
     * @param DEN_SOC
     */
    public void setDEN_SOC(java.lang.String DEN_SOC) {
        this.DEN_SOC = DEN_SOC;
    }


    /**
     * Gets the PAIS value for this DT_PROVEEDOR.
     * 
     * @return PAIS
     */
    public java.lang.String getPAIS() {
        return PAIS;
    }


    /**
     * Sets the PAIS value for this DT_PROVEEDOR.
     * 
     * @param PAIS
     */
    public void setPAIS(java.lang.String PAIS) {
        this.PAIS = PAIS;
    }


    /**
     * Gets the DEN_PAIS value for this DT_PROVEEDOR.
     * 
     * @return DEN_PAIS
     */
    public java.lang.String getDEN_PAIS() {
        return DEN_PAIS;
    }


    /**
     * Sets the DEN_PAIS value for this DT_PROVEEDOR.
     * 
     * @param DEN_PAIS
     */
    public void setDEN_PAIS(java.lang.String DEN_PAIS) {
        this.DEN_PAIS = DEN_PAIS;
    }


    /**
     * Gets the NOMBRE value for this DT_PROVEEDOR.
     * 
     * @return NOMBRE
     */
    public java.lang.String getNOMBRE() {
        return NOMBRE;
    }


    /**
     * Sets the NOMBRE value for this DT_PROVEEDOR.
     * 
     * @param NOMBRE
     */
    public void setNOMBRE(java.lang.String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }


    /**
     * Gets the CORREO value for this DT_PROVEEDOR.
     * 
     * @return CORREO
     */
    public java.lang.String getCORREO() {
        return CORREO;
    }


    /**
     * Sets the CORREO value for this DT_PROVEEDOR.
     * 
     * @param CORREO
     */
    public void setCORREO(java.lang.String CORREO) {
        this.CORREO = CORREO;
    }


    /**
     * Gets the DIRECCION value for this DT_PROVEEDOR.
     * 
     * @return DIRECCION
     */
    public java.lang.String getDIRECCION() {
        return DIRECCION;
    }


    /**
     * Sets the DIRECCION value for this DT_PROVEEDOR.
     * 
     * @param DIRECCION
     */
    public void setDIRECCION(java.lang.String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }


    /**
     * Gets the CIUDAD value for this DT_PROVEEDOR.
     * 
     * @return CIUDAD
     */
    public java.lang.String getCIUDAD() {
        return CIUDAD;
    }


    /**
     * Sets the CIUDAD value for this DT_PROVEEDOR.
     * 
     * @param CIUDAD
     */
    public void setCIUDAD(java.lang.String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }


    /**
     * Gets the CONTACTO value for this DT_PROVEEDOR.
     * 
     * @return CONTACTO
     */
    public extranet_sgto_ordenes_compra.familia.DT_CONTACTO[] getCONTACTO() {
        return CONTACTO;
    }


    /**
     * Sets the CONTACTO value for this DT_PROVEEDOR.
     * 
     * @param CONTACTO
     */
    public void setCONTACTO(extranet_sgto_ordenes_compra.familia.DT_CONTACTO[] CONTACTO) {
        this.CONTACTO = CONTACTO;
    }

    public extranet_sgto_ordenes_compra.familia.DT_CONTACTO getCONTACTO(int i) {
        return this.CONTACTO[i];
    }

    public void setCONTACTO(int i, extranet_sgto_ordenes_compra.familia.DT_CONTACTO _value) {
        this.CONTACTO[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DT_PROVEEDOR)) return false;
        DT_PROVEEDOR other = (DT_PROVEEDOR) obj;
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
            ((this.NIT==null && other.getNIT()==null) || 
             (this.NIT!=null &&
              this.NIT.equals(other.getNIT()))) &&
            ((this.SOCIEDAD==null && other.getSOCIEDAD()==null) || 
             (this.SOCIEDAD!=null &&
              this.SOCIEDAD.equals(other.getSOCIEDAD()))) &&
            ((this.DEN_SOC==null && other.getDEN_SOC()==null) || 
             (this.DEN_SOC!=null &&
              this.DEN_SOC.equals(other.getDEN_SOC()))) &&
            ((this.PAIS==null && other.getPAIS()==null) || 
             (this.PAIS!=null &&
              this.PAIS.equals(other.getPAIS()))) &&
            ((this.DEN_PAIS==null && other.getDEN_PAIS()==null) || 
             (this.DEN_PAIS!=null &&
              this.DEN_PAIS.equals(other.getDEN_PAIS()))) &&
            ((this.NOMBRE==null && other.getNOMBRE()==null) || 
             (this.NOMBRE!=null &&
              this.NOMBRE.equals(other.getNOMBRE()))) &&
            ((this.CORREO==null && other.getCORREO()==null) || 
             (this.CORREO!=null &&
              this.CORREO.equals(other.getCORREO()))) &&
            ((this.DIRECCION==null && other.getDIRECCION()==null) || 
             (this.DIRECCION!=null &&
              this.DIRECCION.equals(other.getDIRECCION()))) &&
            ((this.CIUDAD==null && other.getCIUDAD()==null) || 
             (this.CIUDAD!=null &&
              this.CIUDAD.equals(other.getCIUDAD()))) &&
            ((this.CONTACTO==null && other.getCONTACTO()==null) || 
             (this.CONTACTO!=null &&
              java.util.Arrays.equals(this.CONTACTO, other.getCONTACTO())));
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
        if (getNIT() != null) {
            _hashCode += getNIT().hashCode();
        }
        if (getSOCIEDAD() != null) {
            _hashCode += getSOCIEDAD().hashCode();
        }
        if (getDEN_SOC() != null) {
            _hashCode += getDEN_SOC().hashCode();
        }
        if (getPAIS() != null) {
            _hashCode += getPAIS().hashCode();
        }
        if (getDEN_PAIS() != null) {
            _hashCode += getDEN_PAIS().hashCode();
        }
        if (getNOMBRE() != null) {
            _hashCode += getNOMBRE().hashCode();
        }
        if (getCORREO() != null) {
            _hashCode += getCORREO().hashCode();
        }
        if (getDIRECCION() != null) {
            _hashCode += getDIRECCION().hashCode();
        }
        if (getCIUDAD() != null) {
            _hashCode += getCIUDAD().hashCode();
        }
        if (getCONTACTO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCONTACTO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCONTACTO(), i);
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
        new org.apache.axis.description.TypeDesc(DT_PROVEEDOR.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_PROVEEDOR"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COD_PROV");
        elemField.setXmlName(new javax.xml.namespace.QName("", "COD_PROV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NIT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NIT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SOCIEDAD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SOCIEDAD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DEN_SOC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DEN_SOC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAIS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DEN_PAIS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DEN_PAIS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NOMBRE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NOMBRE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CORREO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CORREO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DIRECCION");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DIRECCION"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CIUDAD");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CIUDAD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTACTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CONTACTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:familia:extranet_sgto_ordenes_compra", "DT_CONTACTO"));
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
