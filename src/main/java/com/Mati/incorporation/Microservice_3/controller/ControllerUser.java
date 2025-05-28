package com.Mati.incorporation.Microservice_3.controller;

import com.Mati.incorporation.Microservice_3.model.Message;
import com.Mati.incorporation.Microservice_3.model.ModelRole;
import com.Mati.incorporation.Microservice_3.model.ModelUser;
import com.Mati.incorporation.Microservice_3.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
@RequestMapping("/users")
>>>>>>> 4ebc66e (Finalizacion de user)
@RestController
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

<<<<<<< HEAD
=======
    @Autowired
    private Message message;
>>>>>>> 4ebc66e (Finalizacion de user)

    @PostMapping("/create")
    public ResponseEntity<ModelUser> createUser(@RequestBody ModelUser user) {
        try {
            ModelUser createdUser = serviceUser.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users")
<<<<<<< HEAD
    public ResponseEntity<List<ModelUser>> getUsers() {
        return ResponseEntity.ok(serviceUser.getUsers());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<ModelUser> getUser(@PathVariable Long rut) {
        return serviceUser.getUser(rut);
    }

        @DeleteMapping("/delete/{rut}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long rut){
            serviceUser.deleteUser(rut);
            return ResponseEntity.ok().build();
        }
=======
    public ResponseEntity <List<ModelUser>> getUsers(){
        try{
            List<ModelUser> users = serviceUser.getUsers();
            return ResponseEntity.status(HttpStatus.OK).body(users);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{rut}")
    public ResponseEntity<ModelUser> getUser(@PathVariable Long id) {
        try{
            Optional<ModelUser> user = serviceUser.getUser(id);
                    if (user.isPresent()) {;
                return ResponseEntity.status(HttpStatus.OK).body(user.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{rut}")
    public ResponseEntity<ModelUser> Updateuser(@PathVariable Long id,
                                                @RequestBody ModelUser user){
        try {
            ModelUser updatedUser = serviceUser.updateUser(id, user);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/delete/{rut}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            try {
                Optional<ModelUser> user = serviceUser.getUser(id);
                if(user.isPresent()) {
                    serviceUser.deleteUser(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

    @PostMapping("/{userId}/roles")
    public ResponseEntity<ModelUser> assignRoleToUser(
            @PathVariable Long userId,
            @RequestBody ModelRole role) {
        Optional<ModelUser> updatedUser = serviceUser.assignRoleToUser(userId, role);
        if (updatedUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
>>>>>>> 4ebc66e (Finalizacion de user)


        @PutMapping("/{rut}/update")
        public ResponseEntity<ModelUser> updateUser ( @PathVariable Long rut, @RequestBody ModelUser user){
            return serviceUser.updateUser(rut, user);

        }
    }
