package com.familia.vales.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vale database table.
 * 
 */
@Entity
@NamedQuery(name="Vale.findAll", query="SELECT v FROM Vale v")
public class Vale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_VALE")
	private int idVale;

	private String almacen;

	@Column(name="ALMACEN_ORIGEN")
	private String almacenOrigen;

	private String aprobadoralmacen;

	private String aprobadorjefe;

	@Column(name="DESTINO_CIUDAD")
	private String destinoCiudad;

	@Column(name="DESTINO_DIRECCION")
	private String destinoDireccion;

	@Column(name="DESTINO_EMPRESA")
	private String destinoEmpresa;

	@Column(name="DESTINO_NIT")
	private String destinoNit;

	@Column(name="DESTINO_NOMBRE")
	private String destinoNombre;

	@Column(name="DESTINO_PROVEEDOR")
	private String destinoProveedor;

	@Column(name="DESTINO_TEL")
	private String destinoTel;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	private String justificacion;

	@Column(name="MATERIAL_PICIZ")
	private String materialPiciz;

	private String motivo;

	@Column(name="NOMBRE_DILIGENCIO")
	private String nombreDiligencio;

	private String observaciones;

	private String planta;

	private String porteria;

	private String retira;

	@Column(name="RETIRA_EMPRESA")
	private String retiraEmpresa;

	@Column(name="RETIRA_IDENTIFICACION")
	private String retiraIdentificacion;

	@Column(name="RETIRA_NOMBRE")
	private String retiraNombre;

	@Column(name="RETIRA_PLACA")
	private String retiraPlaca;

	private String senores;

	private String solicitante;

	//bi-directional many-to-one association to DetalleVale
	@OneToMany(mappedBy="vale")
	private List<DetalleVale> detalleVales;

	//bi-directional many-to-one association to OperacionVale
	@OneToMany(mappedBy="vale")
	private List<OperacionVale> operacionVales;

	//bi-directional many-to-one association to EstadoVale
	@ManyToOne
	@JoinColumn(name="ID_ESTADO")
	private EstadoVale estadoVale;

	public Vale() {
	}

	public int getIdVale() {
		return this.idVale;
	}

	public void setIdVale(int idVale) {
		this.idVale = idVale;
	}

	public String getAlmacen() {
		return this.almacen;
	}

	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	public String getAlmacenOrigen() {
		return this.almacenOrigen;
	}

	public void setAlmacenOrigen(String almacenOrigen) {
		this.almacenOrigen = almacenOrigen;
	}

	public String getAprobadoralmacen() {
		return this.aprobadoralmacen;
	}

	public void setAprobadoralmacen(String aprobadoralmacen) {
		this.aprobadoralmacen = aprobadoralmacen;
	}

	public String getAprobadorjefe() {
		return this.aprobadorjefe;
	}

	public void setAprobadorjefe(String aprobadorjefe) {
		this.aprobadorjefe = aprobadorjefe;
	}

	public String getDestinoCiudad() {
		return this.destinoCiudad;
	}

	public void setDestinoCiudad(String destinoCiudad) {
		this.destinoCiudad = destinoCiudad;
	}

	public String getDestinoDireccion() {
		return this.destinoDireccion;
	}

	public void setDestinoDireccion(String destinoDireccion) {
		this.destinoDireccion = destinoDireccion;
	}

	public String getDestinoEmpresa() {
		return this.destinoEmpresa;
	}

	public void setDestinoEmpresa(String destinoEmpresa) {
		this.destinoEmpresa = destinoEmpresa;
	}

	public String getDestinoNit() {
		return this.destinoNit;
	}

	public void setDestinoNit(String destinoNit) {
		this.destinoNit = destinoNit;
	}

	public String getDestinoNombre() {
		return this.destinoNombre;
	}

	public void setDestinoNombre(String destinoNombre) {
		this.destinoNombre = destinoNombre;
	}

	public String getDestinoProveedor() {
		return this.destinoProveedor;
	}

	public void setDestinoProveedor(String destinoProveedor) {
		this.destinoProveedor = destinoProveedor;
	}

	public String getDestinoTel() {
		return this.destinoTel;
	}

	public void setDestinoTel(String destinoTel) {
		this.destinoTel = destinoTel;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getJustificacion() {
		return this.justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getMaterialPiciz() {
		return this.materialPiciz;
	}

	public void setMaterialPiciz(String materialPiciz) {
		this.materialPiciz = materialPiciz;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNombreDiligencio() {
		return this.nombreDiligencio;
	}

	public void setNombreDiligencio(String nombreDiligencio) {
		this.nombreDiligencio = nombreDiligencio;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPlanta() {
		return this.planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getPorteria() {
		return this.porteria;
	}

	public void setPorteria(String porteria) {
		this.porteria = porteria;
	}

	public String getRetira() {
		return this.retira;
	}

	public void setRetira(String retira) {
		this.retira = retira;
	}

	public String getRetiraEmpresa() {
		return this.retiraEmpresa;
	}

	public void setRetiraEmpresa(String retiraEmpresa) {
		this.retiraEmpresa = retiraEmpresa;
	}

	public String getRetiraIdentificacion() {
		return this.retiraIdentificacion;
	}

	public void setRetiraIdentificacion(String retiraIdentificacion) {
		this.retiraIdentificacion = retiraIdentificacion;
	}

	public String getRetiraNombre() {
		return this.retiraNombre;
	}

	public void setRetiraNombre(String retiraNombre) {
		this.retiraNombre = retiraNombre;
	}

	public String getRetiraPlaca() {
		return this.retiraPlaca;
	}

	public void setRetiraPlaca(String retiraPlaca) {
		this.retiraPlaca = retiraPlaca;
	}

	public String getSenores() {
		return this.senores;
	}

	public void setSenores(String senores) {
		this.senores = senores;
	}

	public String getSolicitante() {
		return this.solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public List<DetalleVale> getDetalleVales() {
		return this.detalleVales;
	}

	public void setDetalleVales(List<DetalleVale> detalleVales) {
		this.detalleVales = detalleVales;
	}

	public DetalleVale addDetalleVale(DetalleVale detalleVale) {
		getDetalleVales().add(detalleVale);
		detalleVale.setVale(this);

		return detalleVale;
	}

	public DetalleVale removeDetalleVale(DetalleVale detalleVale) {
		getDetalleVales().remove(detalleVale);
		detalleVale.setVale(null);

		return detalleVale;
	}

	public List<OperacionVale> getOperacionVales() {
		return this.operacionVales;
	}

	public void setOperacionVales(List<OperacionVale> operacionVales) {
		this.operacionVales = operacionVales;
	}

	public OperacionVale addOperacionVale(OperacionVale operacionVale) {
		getOperacionVales().add(operacionVale);
		operacionVale.setVale(this);

		return operacionVale;
	}

	public OperacionVale removeOperacionVale(OperacionVale operacionVale) {
		getOperacionVales().remove(operacionVale);
		operacionVale.setVale(null);

		return operacionVale;
	}

	public EstadoVale getEstadoVale() {
		return this.estadoVale;
	}

	public void setEstadoVale(EstadoVale estadoVale) {
		this.estadoVale = estadoVale;
	}

}