package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_vale database table.
 * 
 */
@Entity
@Table(name="estado_vale")
@NamedQuery(name="EstadoVale.findAll", query="SELECT e FROM EstadoVale e")
public class EstadoVale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ESTADO_VALE")
	private int idEstadoVale;

	private String activo;

	private String estado;

	private int orden;

	//bi-directional many-to-one association to OperacionVale
	@OneToMany(mappedBy="estadoValeFinal")
	private List<OperacionVale> operacionVales1;

	//bi-directional many-to-one association to OperacionVale
	@OneToMany(mappedBy="estadoValeInicial")
	private List<OperacionVale> operacionVales2;

	//bi-directional many-to-one association to Vale
	@OneToMany(mappedBy="estadoVale")
	private List<Vale> vales;

	public EstadoVale() {
	}

	public int getIdEstadoVale() {
		return this.idEstadoVale;
	}

	public void setIdEstadoVale(int idEstadoVale) {
		this.idEstadoVale = idEstadoVale;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public List<OperacionVale> getOperacionVales1() {
		return this.operacionVales1;
	}

	public void setOperacionVales1(List<OperacionVale> operacionVales1) {
		this.operacionVales1 = operacionVales1;
	}

	public OperacionVale addOperacionVales1(OperacionVale operacionVales1) {
		getOperacionVales1().add(operacionVales1);
		operacionVales1.setEstadoValeFinal(this);

		return operacionVales1;
	}

	public OperacionVale removeOperacionVales1(OperacionVale operacionVales1) {
		getOperacionVales1().remove(operacionVales1);
		operacionVales1.setEstadoValeFinal(null);

		return operacionVales1;
	}

	public List<OperacionVale> getOperacionVales2() {
		return this.operacionVales2;
	}

	public void setOperacionVales2(List<OperacionVale> operacionVales2) {
		this.operacionVales2 = operacionVales2;
	}

	public OperacionVale addOperacionVales2(OperacionVale operacionVales2) {
		getOperacionVales2().add(operacionVales2);
		operacionVales2.setEstadoValeInicial(this);

		return operacionVales2;
	}

	public OperacionVale removeOperacionVales2(OperacionVale operacionVales2) {
		getOperacionVales2().remove(operacionVales2);
		operacionVales2.setEstadoValeInicial(null);

		return operacionVales2;
	}

	public List<Vale> getVales() {
		return this.vales;
	}

	public void setVales(List<Vale> vales) {
		this.vales = vales;
	}

	public Vale addVale(Vale vale) {
		getVales().add(vale);
		vale.setEstadoVale(this);

		return vale;
	}

	public Vale removeVale(Vale vale) {
		getVales().remove(vale);
		vale.setEstadoVale(null);

		return vale;
	}

}