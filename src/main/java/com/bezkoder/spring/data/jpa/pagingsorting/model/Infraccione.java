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
	
	private String comentario;
	
	private String intervino ;
	
	@Column(name="cp_titular")
	private String cpTitular;
	
	@Column(name="nombre_titular")
	private String nombreTitular;
	
	@Column(name="direccion_titular")
	private String direccionTitular;
	
	@Column(name="localidad_titular")
	private String localidadTitular;
	
	@Column(name="provincia_titular")
	private String provinciaTitular;
	
	@Column(name="dni_titular")
	private String dniTitular;
	

	
	public Infraccione(int id, String acta, String actoResolutorio, String agente, String articulo, String chasis,
			String codigoPostal, String descripcion, String direccion, String dni, String dominio, Date fecha,
			Date fechaResolucion, String inciso, String leyOrdenanza, String localidad, String lugar, String motor,
			String nombre, String provincia, float unidadValor, String valor, String vehiculo, String comentario,
			String intervino, String cpTitular, String nombreTitular, String direccionTitular, String localidadTitular,
			String provinciaTitular, String dniTitular) {
		super();
		this.id = id;
		this.acta = acta;
		this.actoResolutorio = actoResolutorio;
		this.agente = agente;
		this.articulo = articulo;
		this.chasis = chasis;
		this.codigoPostal = codigoPostal;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.dni = dni;
		this.dominio = dominio;
		this.fecha = fecha;
		this.fechaResolucion = fechaResolucion;
		this.inciso = inciso;
		this.leyOrdenanza = leyOrdenanza;
		this.localidad = localidad;
		this.lugar = lugar;
		this.motor = motor;
		this.nombre = nombre;
		this.provincia = provincia;
		this.unidadValor = unidadValor;
		this.valor = valor;
		this.vehiculo = vehiculo;
		this.comentario = comentario;
		this.intervino = intervino;
		this.cpTitular = cpTitular;
		this.nombreTitular = nombreTitular;
		this.direccionTitular = direccionTitular;
		this.localidadTitular = localidadTitular;
		this.provinciaTitular = provinciaTitular;
		this.dniTitular = dniTitular;
	}

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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getIntervino() {
		return intervino;
	}

	public void setIntervino(String intervino) {
		this.intervino = intervino;
	}

	public String getCpTitular() {
		return cpTitular;
	}

	public void setCpTitular(String cpTitular) {
		this.cpTitular = cpTitular;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getDireccionTitular() {
		return direccionTitular;
	}

	public void setDireccionTitular(String direccionTitular) {
		this.direccionTitular = direccionTitular;
	}

	public String getLocalidadTitular() {
		return localidadTitular;
	}

	public void setLocalidadTitular(String localidadTitular) {
		this.localidadTitular = localidadTitular;
	}

	public String getProvinciaTitular() {
		return provinciaTitular;
	}

	public void setProvinciaTitular(String provinciaTitular) {
		this.provinciaTitular = provinciaTitular;
	}

	public String getDniTitular() {
		return dniTitular;
	}

	public void setDniTitular(String dniTitular) {
		this.dniTitular = dniTitular;
	}
	
	

}