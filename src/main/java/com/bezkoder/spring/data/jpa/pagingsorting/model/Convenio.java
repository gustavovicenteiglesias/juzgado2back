package com.bezkoder.spring.data.jpa.pagingsorting.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="convenio")
public class Convenio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Float anticipo;
	
	private Integer cant_cuotas;
	
	private Float valor_cuota;
	
	
	@OneToOne
	@JoinColumn(name="FK_INFRACCIONES" ,updatable = false, nullable = false)
	@JsonBackReference(value="infracciones-convenio")
	private Infraccione infracciones;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "convenio")
	@JsonManagedReference(value="convenio-cuotas")
	private List<PagosCuotas> cuotas;

	public Convenio(Long id, Float anticipo, Integer cant_cuotas, Float valor_cuota, Infraccione infracciones,
			List<PagosCuotas> cuotas) {
		super();
		this.id = id;
		this.anticipo = anticipo;
		this.cant_cuotas = cant_cuotas;
		this.valor_cuota = valor_cuota;
		this.infracciones = infracciones;
		this.cuotas = cuotas;
	}

	public Convenio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getAnticipo() {
		return anticipo;
	}

	public void setAnticipo(Float anticipo) {
		this.anticipo = anticipo;
	}

	public Integer getCant_cuotas() {
		return cant_cuotas;
	}

	public void setCant_cuotas(Integer cant_cuotas) {
		this.cant_cuotas = cant_cuotas;
	}

	public Float getValor_cuota() {
		return valor_cuota;
	}

	public void setValor_cuota(Float valor_cuota) {
		this.valor_cuota = valor_cuota;
	}

	public Infraccione getInfracciones() {
		return infracciones;
	}

	public void setInfracciones(Infraccione infracciones) {
		this.infracciones = infracciones;
	}

	public List<PagosCuotas> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<PagosCuotas> cuotas) {
		this.cuotas = cuotas;
	}
	
	
	

}
