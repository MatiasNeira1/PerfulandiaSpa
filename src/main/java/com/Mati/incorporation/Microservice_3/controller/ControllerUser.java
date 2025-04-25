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




}


