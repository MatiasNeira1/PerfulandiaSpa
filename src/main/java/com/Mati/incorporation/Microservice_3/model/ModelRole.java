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
@Table(name = "roles")

public class ModelRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    @SequenceGenerator(name = "seq_role", sequenceName = "role_seq", allocationSize = 1)
    private Long id;
    private String name;



    @ManyToOne
    @JoinColumn(name = "id_user")
    private ModelUser user;
}
