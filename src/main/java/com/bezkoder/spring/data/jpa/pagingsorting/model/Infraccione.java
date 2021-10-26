package com.bezkoder.spring.data.jpa.pagingsorting.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String causa;

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
	private Float unidadValor;

	private String valor;

	private String vehiculo;
	
	private String comentario;
	
	private String intervino ;
	
	@Column(name="titular_codigo_postal	")
	private String cpTitular;
	
	@Column(name="titular_nombre")
	private String nombreTitular;
	
	@Column(name="titular_direccion")
	private String direccionTitular;
	
	@Column(name="titular_localidad")
	private String localidadTitular;
	
	@Column(name="titular_provincia")
	private String provinciaTitular;
	
	@Column(name="titular_dni")
	private String dniTitular;
	
	@OneToOne(mappedBy = "infracciones", cascade = CascadeType.ALL)
	@JsonManagedReference(value="infracciones-convenio")
	private Convenio convenio ;

	public Infraccione(Long id, String causa, String acta, String actoResolutorio, String agente, String articulo,
			String chasis, String codigoPostal, String descripcion, String direccion, String dni, String dominio,
			Date fecha, Date fechaResolucion, String inciso, String leyOrdenanza, String localidad, String lugar,
			String motor, String nombre, String provincia, Float unidadValor, String valor, String vehiculo,
			String comentario, String intervino, String cpTitular, String nombreTitular, String direccionTitular,
			String localidadTitular, String provinciaTitular, String dniTitular, Convenio convenio) {
		super();
		this.id = id;
		this.causa = causa;
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
		this.convenio = convenio;
	}

	public Infraccione() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getActa() {
		return acta;
	}

	public void setActa(String acta) {
		this.acta = acta;
	}

	public String getActoResolutorio() {
		return actoResolutorio;
	}

	public void setActoResolutorio(String actoResolutorio) {
		this.actoResolutorio = actoResolutorio;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public String getInciso() {
		return inciso;
	}

	public void setInciso(String inciso) {
		this.inciso = inciso;
	}

	public String getLeyOrdenanza() {
		return leyOrdenanza;
	}

	public void setLeyOrdenanza(String leyOrdenanza) {
		this.leyOrdenanza = leyOrdenanza;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Float getUnidadValor() {
		return unidadValor;
	}

	public void setUnidadValor(Float unidadValor) {
		this.unidadValor = unidadValor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getVehiculo() {
		return vehiculo;
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

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	@Override
	public String toString() {
		return "Infraccione [id=" + id + ", causa=" + causa + ", acta=" + acta + ", actoResolutorio=" + actoResolutorio
				+ ", agente=" + agente + ", articulo=" + articulo + ", chasis=" + chasis + ", codigoPostal="
				+ codigoPostal + ", descripcion=" + descripcion + ", direccion=" + direccion + ", dni=" + dni
				+ ", dominio=" + dominio + ", fecha=" + fecha + ", fechaResolucion=" + fechaResolucion + ", inciso="
				+ inciso + ", leyOrdenanza=" + leyOrdenanza + ", localidad=" + localidad + ", lugar=" + lugar
				+ ", motor=" + motor + ", nombre=" + nombre + ", provincia=" + provincia + ", unidadValor="
				+ unidadValor + ", valor=" + valor + ", vehiculo=" + vehiculo + ", comentario=" + comentario
				+ ", intervino=" + intervino + ", cpTitular=" + cpTitular + ", nombreTitular=" + nombreTitular
				+ ", direccionTitular=" + direccionTitular + ", localidadTitular=" + localidadTitular
				+ ", provinciaTitular=" + provinciaTitular + ", dniTitular=" + dniTitular + ", convenio=" + convenio
				+ "]";
	}

	
	

	
	

}