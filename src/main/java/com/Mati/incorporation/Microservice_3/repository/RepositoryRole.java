package com.Mati.incorporation.Microservice_3.repository;

import com.Mati.incorporation.Microservice_3.model.ModelRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRole extends JpaRepository<ModelRole, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
