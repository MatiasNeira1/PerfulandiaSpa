package com.Mati.incorporation.Microservice_3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Job")

public class ModelUser {
    @Id

    private Long rut;
    private String dv;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private String comuna;
    private String provincia;
    private String region;
}
