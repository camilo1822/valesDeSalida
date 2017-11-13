package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the centros database table.
 * 
 */
@Entity
@Table(name="centros")
@NamedQuery(name="Centro.findAll", query="SELECT c FROM Centro c")
public class Centro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcentros;

	private String centro;

	public Centro() {
	}

	public int getIdcentros() {
		return this.idcentros;
	}

	public void setIdcentros(int idcentros) {
		this.idcentros = idcentros;
	}

	public String getCentro() {
		return this.centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

}