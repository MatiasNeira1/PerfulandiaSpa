package com.Mati.incorporation.Microservice_3.service;

import com.Mati.incorporation.Microservice_3.model.Message;
import com.Mati.incorporation.Microservice_3.model.ModelUser;
import com.Mati.incorporation.Microservice_3.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser {


    @Autowired
    RepositoryUser repositoryUser;

    public ModelUser createUser(@RequestBody ModelUser User) {
        return repositoryUser.save(User);
    }


    public List<ModelUser> getUsers(){
        return repositoryUser.findAll();
    }

    public Optional<ModelUser> getUser(@PathVariable Long rut) {
        return repositoryUser.findById(rut);

    }

    public ResponseEntity<ModelUser> updateUser(Long rut, ModelUser updatedUser) {
        return repositoryUser.findById(rut).map(user -> {
            user.setNombre(updatedUser.getNombre());
            user.setApellido(updatedUser.getApellido());
            user.setCorreo(updatedUser.getCorreo());
            user.setTelefono(updatedUser.getTelefono());
            user.setDireccion(updatedUser.getDireccion());
            user.setComuna(updatedUser.getComuna());
            user.setProvincia(updatedUser.getProvincia());
            user.setRegion(updatedUser.getRegion());

            return ResponseEntity.ok(repositoryUser.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }


}






