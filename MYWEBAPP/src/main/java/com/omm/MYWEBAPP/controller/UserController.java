package com.omm.MYWEBAPP.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.omm.MYWEBAPP.DTO.UserDTo;
import com.omm.MYWEBAPP.DTO.View;
import com.omm.MYWEBAPP.service.UserServiceInetrface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController

public class UserController {

    private final UserServiceInetrface userServiceInetrface;



    @GetMapping("/users")
    @JsonView(View.Public.class)
    public ResponseEntity < List<UserDTo>> getUsers(){
      return ResponseEntity.ok(userServiceInetrface.getUsers());
    }
    @GetMapping("/users/{id}")
    @JsonView(View.Detailed.class)
    public  ResponseEntity<UserDTo> getUserById(@PathVariable  Integer id)
    {
        UserDTo dTo= userServiceInetrface.getUserById(id);
        return ResponseEntity.ok(dTo);
    }
    @PostMapping  ("/users")
        public ResponseEntity<String> addUser( @RequestBody @JsonView(View.Input.class) List<UserDTo> user){
            return ResponseEntity.ok(userServiceInetrface.addUser(user));
        }
    @PutMapping ("/users/{id}")
    public String updateUser(@PathVariable Integer id ,@Valid @RequestBody @JsonView(View.Input.class) UserDTo user){
        return  userServiceInetrface.updateUser(user);
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userServiceInetrface.deleteUser(id);
    }

}
