package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidad_medida_vale database table.
 * 
 */
@Entity
@Table(name="unidad_medida_vale")
@NamedQuery(name="UnidadMedidaVale.findAll", query="SELECT u FROM UnidadMedidaVale u")
public class UnidadMedidaVale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_UNIDAD_MEDIDA_VALE")
	private int idUnidadMedidaVale;

	private String activo;

	private int orden;

	@Column(name="UNIDAD_MEDIDA")
	private String unidadMedida;

	//bi-directional many-to-one association to DetalleVale
	@OneToMany(mappedBy="unidadMedidaVale")
	private List<DetalleVale> detalleVales;

	public UnidadMedidaVale() {
	}

	public int getIdUnidadMedidaVale() {
		return this.idUnidadMedidaVale;
	}

	public void setIdUnidadMedidaVale(int idUnidadMedidaVale) {
		this.idUnidadMedidaVale = idUnidadMedidaVale;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public List<DetalleVale> getDetalleVales() {
		return this.detalleVales;
	}

	public void setDetalleVales(List<DetalleVale> detalleVales) {
		this.detalleVales = detalleVales;
	}

	public DetalleVale addDetalleVale(DetalleVale detalleVale) {
		getDetalleVales().add(detalleVale);
		detalleVale.setUnidadMedidaVale(this);

		return detalleVale;
	}

	public DetalleVale removeDetalleVale(DetalleVale detalleVale) {
		getDetalleVales().remove(detalleVale);
		detalleVale.setUnidadMedidaVale(null);

		return detalleVale;
	}

}