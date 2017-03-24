package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the motivo_vale database table.
 * 
 */
@Entity
@Table(name="motivo_vale")
@NamedQuery(name="MotivoVale.findAll", query="SELECT m FROM MotivoVale m")
public class MotivoVale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MOTIVO_VALE")
	private int idMotivoVale;

	private String activo;

	private String motivo;

	private int orden;

	public MotivoVale() {
	}

	public int getIdMotivoVale() {
		return this.idMotivoVale;
	}

	public void setIdMotivoVale(int idMotivoVale) {
		this.idMotivoVale = idMotivoVale;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

}