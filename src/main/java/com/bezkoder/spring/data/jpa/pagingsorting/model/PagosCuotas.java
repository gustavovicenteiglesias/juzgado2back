package com.bezkoder.spring.data.jpa.pagingsorting.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="pagos_cuotas")
public class PagosCuotas implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date fecha_pago;
	
	private Long nro_recibo; 
	
	private Boolean estado;
	
	 @ManyToOne
	 @JoinColumn(name = "FK_CONVENIO", nullable = false, updatable = false)
	 @JsonBackReference(value="convenio-cuotas")
	 private Convenio convenio;

	public PagosCuotas(Long id, Date fecha_pago, Long nro_recibo, Boolean estado, Convenio convenio) {
		super();
		this.id = id;
		this.fecha_pago = fecha_pago;
		this.nro_recibo = nro_recibo;
		this.estado = estado;
		this.convenio = convenio;
	}

	public PagosCuotas() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public Long getNro_recibo() {
		return nro_recibo;
	}

	public void setNro_recibo(Long nro_recibo) {
		this.nro_recibo = nro_recibo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	 
	
}
