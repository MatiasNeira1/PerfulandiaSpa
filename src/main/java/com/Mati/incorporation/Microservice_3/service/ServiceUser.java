package com.Mati.incorporation.Microservice_3.service;

import com.Mati.incorporation.Microservice_3.model.ModelUser;
import com.Mati.incorporation.Microservice_3.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    RepositoryUser repositoryUser;

    public ModelUser createUser(ModelUser User) {
        return repositoryUser.save(User);
    }

    public List<ModelUser> getUsers(){
        return repositoryUser.findAll();
    }

    public ResponseEntity<ModelUser> getUser(Long rut) {
        return repositoryUser.findById(rut).map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteUser(Long rut) {
        for (ModelUser user : repositoryUser.findAll()) {
            if (user.getRut().equals(rut)) {
                repositoryUser.deleteById(rut);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
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
