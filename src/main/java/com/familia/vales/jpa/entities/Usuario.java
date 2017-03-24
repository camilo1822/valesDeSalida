package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private int idUsuario;

	private String email;

	private String nombres;

	//bi-directional many-to-one association to OperacionVale
	@OneToMany(mappedBy="usuario")
	private List<OperacionVale> operacionVales;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<OperacionVale> getOperacionVales() {
		return this.operacionVales;
	}

	public void setOperacionVales(List<OperacionVale> operacionVales) {
		this.operacionVales = operacionVales;
	}

	public OperacionVale addOperacionVale(OperacionVale operacionVale) {
		getOperacionVales().add(operacionVale);
		operacionVale.setUsuario(this);

		return operacionVale;
	}

	public OperacionVale removeOperacionVale(OperacionVale operacionVale) {
		getOperacionVales().remove(operacionVale);
		operacionVale.setUsuario(null);

		return operacionVale;
	}

}