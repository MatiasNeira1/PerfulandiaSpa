package com.Mati.incorporation.Microservice_3.service;

<<<<<<< HEAD
=======
import com.Mati.incorporation.Microservice_3.model.Message;
import com.Mati.incorporation.Microservice_3.model.ModelRole;
>>>>>>> 4ebc66e (Finalizacion de user)
import com.Mati.incorporation.Microservice_3.model.ModelUser;
import com.Mati.incorporation.Microservice_3.repository.RepositoryRole;
import com.Mati.incorporation.Microservice_3.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {
<<<<<<< HEAD
=======
    @Autowired
    private RepositoryRole repositoryRole;
>>>>>>> 4ebc66e (Finalizacion de user)

    @Autowired
    RepositoryUser repositoryUser;

    public ModelUser createUser(ModelUser User) {
        return repositoryUser.save(User);
    }

    public List<ModelUser> getUsers(){
        return repositoryUser.findAll();
    }

<<<<<<< HEAD
    public ResponseEntity<ModelUser> getUser(Long rut) {
        return repositoryUser.findById(rut).map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }
=======
    public Optional<ModelUser> getUser(@PathVariable Long id) {
        return repositoryUser.findById(id);
>>>>>>> 4ebc66e (Finalizacion de user)

    public ResponseEntity<Void> deleteUser(Long rut) {
        for (ModelUser user : repositoryUser.findAll()) {
            if (user.getRut().equals(rut)) {
                repositoryUser.deleteById(rut);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    public ModelUser updateUser(Long id, ModelUser updatedUser) {
        return repositoryUser.findById(id).map(user -> {
            user.setNombre(updatedUser.getNombre());
            user.setApellido(updatedUser.getApellido());
            user.setCorreo(updatedUser.getCorreo());
            user.setTelefono(updatedUser.getTelefono());
            user.setDireccion(updatedUser.getDireccion());


            return repositoryUser.save(user);
        }).orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
    }
<<<<<<< HEAD
=======
    public List <ModelUser> deleteUser(Long id) {
        if(repositoryUser.existsById(id)) {
            repositoryUser.deleteById(id);
        }
        return repositoryUser.findAll();
        }





    public Optional<ModelUser> assignRoleToUser(Long userId, ModelRole newRole) {
        Optional<ModelUser> userOpt = repositoryUser.findById(userId);
        if (userOpt.isPresent()) {
            ModelUser user = userOpt.get();
            newRole.setUser(user); // Asignar el usuario al rol
            user.getRole().add(newRole); // Agregar el rol al usuario
            repositoryRole.save(newRole); // Guardar el rol
            ModelUser updatedUser = repositoryUser.save(user); // Guardar el usuario (opcional)
            return Optional.of(updatedUser);
        }
        return Optional.empty();
    }



>>>>>>> 4ebc66e (Finalizacion de user)
}
