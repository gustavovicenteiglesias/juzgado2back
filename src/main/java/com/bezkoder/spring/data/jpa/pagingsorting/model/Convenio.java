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
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
	
	private Long nro_recibo; 
	
	private Boolean estado;
	
	
	@OneToOne
	@JoinColumn(name="FK_INFRACCIONES" ,updatable = false, nullable = false)
	@JsonBackReference(value="infracciones-convenio")
	private Infraccione infracciones;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "convenio")
	@JsonManagedReference(value="convenio-cuotas")
	private List<PagosCuotas> cuotas;


}
