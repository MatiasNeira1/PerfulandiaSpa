package com.Mati.incorporation.Microservice_3.controller;

import com.Mati.incorporation.Microservice_3.model.ModelUser;
import com.Mati.incorporation.Microservice_3.repository.RepositoryUser;
import com.Mati.incorporation.Microservice_3.service.ServiceUser;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController

public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

    @PostMapping("/create")
    public ResponseEntity<ModelUser> createUser(@RequestBody ModelUser user) {
        return ResponseEntity.ok(serviceUser.createUser(user));
    }



    @GetMapping("/users")
    public ResponseEntity<List<ModelUser>> getAllUsers() {
        return ResponseEntity.ok(serviceUser.getUsers());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<ModelUser> getUser(@PathVariable Long rut) {
        return serviceUser.getUser(rut);
    }
    @PutMapping("/{rut}/update")
    public ResponseEntity<ModelUser> updateUser(@PathVariable int rut, @RequestBody ModelUser user) {
        return serviceUser.updateUser(rut, user);

    }

    @DeleteMapping("/delete/{rut}")
    public ResponseEntity<ModelUser> deleteUser(@PathVariable Long rut) {
        serviceUser.deleteUser(rut);
        return ResponseEntity.ok().build();
    }
}


