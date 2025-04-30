package com.Mati.incorporation.Microservice_3.repository;

import com.Mati.incorporation.Microservice_3.model.ModelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUser extends JpaRepository<ModelUser, Long> {


    List<ModelUser> rut(Long rut);
}
