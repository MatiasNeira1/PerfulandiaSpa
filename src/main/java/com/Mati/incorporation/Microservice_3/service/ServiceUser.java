package com.Mati.incorporation.Microservice_3.service;

import com.Mati.incorporation.Microservice_3.model.Message;
import com.Mati.incorporation.Microservice_3.model.ModelUser;
import com.Mati.incorporation.Microservice_3.repository.RepositoryUser;
import org.apache.catalina.User;
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

<<<<<<< HEAD
    public ResponseEntity<ModelUser> getUser(@PathVariable Long rut) {
        return repositoryUser.findById(rut).map(user-> ResponseEntity.ok(user)).
                orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<ModelUser> updateUser(@PathVariable int rut,
                                                @RequestBody ModelUser User) {
       for(ModelUser user :repositoryUser.findAll()){
            if(user.getRut().equals(rut)){
                user.setNombre(User.getNombre());
                user.setApellido(User.getApellido());
                user.setCorreo(User.getCorreo());
                user.setTelefono(User.getTelefono());
                user.setDireccion(User.getDireccion());
                user.setComuna(User.getComuna());
                user.setProvincia(User.getProvincia());
                user.setRegion(User.getRegion());

                return ResponseEntity.ok(repositoryUser.save(user));
               // repositoryUser.findAll().stream().forEach(u -> u.setNombre(user.getNombre())).;
            }
        }
        return ResponseEntity.notFound().build();
       }

    public ResponseEntity<Void> deleteUser(@PathVariable Long rut) {
        for (ModelUser user : repositoryUser.findAll()) {
            if (user.getRut().equals(rut)) {
                repositoryUser.deleteById(rut);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

=======
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

>>>>>>> 12a69b1313ebeef35b40dd691a2c1382144cede9



    }












