package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_vale database table.
 * 
 */
@Entity
@Table(name="detalle_vale")
@NamedQuery(name="DetalleVale.findAll", query="SELECT d FROM DetalleVale d")
public class DetalleVale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DETALLE_VALE")
	private int idDetalleVale;

	private String aprobado;

	private int cantidad;

	private String codigo;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ESPERADA")
	private Date fechaEsperada;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FINAL")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PRORROGA")
	private Date fechaProrroga;

	private int fila;

	@Column(name="NO_OC")
	private int noOc;

	@Column(name="OC_AD")
	private int ocAd;

	@Column(name="PERTENECE_MAQUINA")
	private String perteneceMaquina;

	private double peso;

	private String recibido;

	private String regresa;

	private double valor;

	@Column(name="VALOR_UNI")
	private double valorUni;

	//bi-directional many-to-one association to UnidadMedidaVale
	@ManyToOne
	@JoinColumn(name="ID_UNIDAD_MEDIDA")
	private UnidadMedidaVale unidadMedidaVale;

	//bi-directional many-to-one association to Vale
	@ManyToOne
	@JoinColumn(name="ID_VALE")
	private Vale vale;

	public DetalleVale() {
	}

	public int getIdDetalleVale() {
		return this.idDetalleVale;
	}

	public void setIdDetalleVale(int idDetalleVale) {
		this.idDetalleVale = idDetalleVale;
	}

	public String getAprobado() {
		return this.aprobado;
	}

	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaEsperada() {
		return this.fechaEsperada;
	}

	public void setFechaEsperada(Date fechaEsperada) {
		this.fechaEsperada = fechaEsperada;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaProrroga() {
		return this.fechaProrroga;
	}

	public void setFechaProrroga(Date fechaProrroga) {
		this.fechaProrroga = fechaProrroga;
	}

	public int getFila() {
		return this.fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getNoOc() {
		return this.noOc;
	}

	public void setNoOc(int noOc) {
		this.noOc = noOc;
	}

	public int getOcAd() {
		return this.ocAd;
	}

	public void setOcAd(int ocAd) {
		this.ocAd = ocAd;
	}

	public String getPerteneceMaquina() {
		return this.perteneceMaquina;
	}

	public void setPerteneceMaquina(String perteneceMaquina) {
		this.perteneceMaquina = perteneceMaquina;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getRecibido() {
		return this.recibido;
	}

	public void setRecibido(String recibido) {
		this.recibido = recibido;
	}

	public String getRegresa() {
		return this.regresa;
	}

	public void setRegresa(String regresa) {
		this.regresa = regresa;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorUni() {
		return this.valorUni;
	}

	public void setValorUni(double valorUni) {
		this.valorUni = valorUni;
	}

	public UnidadMedidaVale getUnidadMedidaVale() {
		return this.unidadMedidaVale;
	}

	public void setUnidadMedidaVale(UnidadMedidaVale unidadMedidaVale) {
		this.unidadMedidaVale = unidadMedidaVale;
	}

	public Vale getVale() {
		return this.vale;
	}

	public void setVale(Vale vale) {
		this.vale = vale;
	}

}