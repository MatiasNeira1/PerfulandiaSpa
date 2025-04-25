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

    public ResponseEntity<ModelUser> getUser(@PathVariable int rut) {
        for(ModelUser user :repositoryUser.findAll()){
            if(user.getRut().equals(rut)){
                return ResponseEntity.ok(user);
            }

        }
        return ResponseEntity.notFound().build();
    }

    //public ResponseEntity<ModelUser> updateUser(int rut)

}

