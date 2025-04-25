package com.Mati.incorporation.Microservice_3.repository;

import com.Mati.incorporation.Microservice_3.model.ModelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<ModelUser, Long> {


}
