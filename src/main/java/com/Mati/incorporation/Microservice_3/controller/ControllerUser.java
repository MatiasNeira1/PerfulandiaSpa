package com.Mati.incorporation.Microservice_3.controller;

import com.Mati.incorporation.Microservice_3.model.ModelUser;
import com.Mati.incorporation.Microservice_3.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;


    @PostMapping("/create")
    public ResponseEntity<ModelUser> createUser(@RequestBody ModelUser user) {
        return ResponseEntity.ok(serviceUser.createUser(user));
    }

    @GetMapping("/users")
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


        @PutMapping("/{rut}/update")
        public ResponseEntity<ModelUser> updateUser ( @PathVariable Long rut, @RequestBody ModelUser user){
            return serviceUser.updateUser(rut, user);

        }
    }
