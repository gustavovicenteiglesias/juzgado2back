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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pagos_cuotas")
public class PagosCuotas implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date fecha_pago;
	
	private Long nro_recibo; 
	
	private Boolean estado;
	
	 @ManyToOne
	 @JoinColumn(name = "FK_CONVENIO", nullable = false, updatable = false)
	 @JsonBackReference(value="convenio-cuotas")
	 private Convenio convenio;

}
