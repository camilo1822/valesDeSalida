package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the operacion_vale database table.
 * 
 */
@Entity
@Table(name="operacion_vale")
@NamedQuery(name="OperacionVale.findAll", query="SELECT o FROM OperacionVale o")
public class OperacionVale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_OPERACION_VALE")
	private int idOperacionVale;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to EstadoVale
	@ManyToOne
	@JoinColumn(name="ID_ESTADO_FINAL")
	private EstadoVale estadoVale1;

	//bi-directional many-to-one association to EstadoVale
	@ManyToOne
	@JoinColumn(name="ID_ESTADO_INICIAL")
	private EstadoVale estadoVale2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to Vale
	@ManyToOne
	@JoinColumn(name="ID_VALE")
	private Vale vale;

	public OperacionVale() {
	}

	public int getIdOperacionVale() {
		return this.idOperacionVale;
	}

	public void setIdOperacionVale(int idOperacionVale) {
		this.idOperacionVale = idOperacionVale;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoVale getEstadoVale1() {
		return this.estadoVale1;
	}

	public void setEstadoVale1(EstadoVale estadoVale1) {
		this.estadoVale1 = estadoVale1;
	}

	public EstadoVale getEstadoVale2() {
		return this.estadoVale2;
	}

	public void setEstadoVale2(EstadoVale estadoVale2) {
		this.estadoVale2 = estadoVale2;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vale getVale() {
		return this.vale;
	}

	public void setVale(Vale vale) {
		this.vale = vale;
	}

}