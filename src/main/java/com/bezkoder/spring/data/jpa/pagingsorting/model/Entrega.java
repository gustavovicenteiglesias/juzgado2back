package com.bezkoder.spring.data.jpa.pagingsorting.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "entrega")
public class Entrega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ejemplos de valores:
    // "DOMINIO", "ESCAPE Y SILENCIADOR", "ELEMENTOS DE SEGURIDAD",
    // "POR ACARREO", "OTRO"
    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToMany(mappedBy = "entregas")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Infraccione> infracciones = new HashSet<>();
}
