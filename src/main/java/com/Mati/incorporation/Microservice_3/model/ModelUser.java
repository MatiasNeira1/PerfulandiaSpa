package com.Mati.incorporation.Microservice_3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="users")

public class ModelUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empleado")
    @SequenceGenerator(name = "seq_empleado", sequenceName = "empleado_seq", allocationSize = 1)

    private Long id;
    private Long rut;
    private String dv;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
<<<<<<< HEAD
    private String comuna;
    private String provincia;
    private String region;

=======

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModelRole> role;
>>>>>>> 4ebc66e (Finalizacion de user)
}
