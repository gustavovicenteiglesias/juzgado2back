package com.bezkoder.spring.data.jpa.pagingsorting.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the infracciones database table.
 * 
 */
@Entity
@Table(name="infracciones")
@NamedQuery(name="Infraccione.findAll", query="SELECT i FROM Infraccione i")
public class Infraccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String acta;

	@Column(name="acto_resolutorio")
	private String actoResolutorio;

	private String agente;

	private String articulo;

	private String chasis;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private String descripcion;

	private String direccion;

	private String dni;

	private String dominio;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_resolucion")
	private Date fechaResolucion;

	private String inciso;

	@Column(name="ley_ordenanza")
	private String leyOrdenanza;

	private String localidad;

	private String lugar;

	private String motor;

	private String nombre;

	private String provincia;

	@Column(name="unidad_valor")
	private float unidadValor;

	private String valor;

	private String vehiculo;

	public Infraccione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActa() {
		return this.acta;
	}

	public void setActa(String acta) {
		this.acta = acta;
	}

	public String getActoResolutorio() {
		return this.actoResolutorio;
	}

	public void setActoResolutorio(String actoResolutorio) {
		this.actoResolutorio = actoResolutorio;
	}

	public String getAgente() {
		return this.agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public String getArticulo() {
		return this.articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDominio() {
		return this.dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaResolucion() {
		return this.fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public String getInciso() {
		return this.inciso;
	}

	public void setInciso(String inciso) {
		this.inciso = inciso;
	}

	public String getLeyOrdenanza() {
		return this.leyOrdenanza;
	}

	public void setLeyOrdenanza(String leyOrdenanza) {
		this.leyOrdenanza = leyOrdenanza;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getMotor() {
		return this.motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public float getUnidadValor() {
		return this.unidadValor;
	}

	public void setUnidadValor(float unidadValor) {
		this.unidadValor = unidadValor;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

}