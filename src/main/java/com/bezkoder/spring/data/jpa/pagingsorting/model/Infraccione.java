package com.bezkoder.spring.data.jpa.pagingsorting.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

    // 👉 NUEVO: observaciones específicas para el oficio/entrega
    @Column(name = "observaciones_entrega", length = 500)
    private String observacionesEntrega;

    // 👉 NUEVO: relación muchos-a-muchos con Entrega
    @ManyToMany
    @JoinTable(
            name = "infracciones_entregas",
            joinColumns = @JoinColumn(name = "infraccion_id"),
            inverseJoinColumns = @JoinColumn(name = "entrega_id")
    )
    @ToString.Exclude
    private Set<Entrega> entregas = new HashSet<>();

    @OneToOne(mappedBy = "infracciones", cascade = CascadeType.ALL)
    @JsonManagedReference(value="infracciones-convenio")
    private Convenio convenio ;
}
