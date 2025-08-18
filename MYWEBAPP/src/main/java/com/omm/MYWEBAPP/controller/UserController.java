package com.omm.MYWEBAPP.controller;

import com.omm.MYWEBAPP.model.User;
import com.omm.MYWEBAPP.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getUsers(){
       return userService.getUsers();
    }
    @GetMapping("/users/{id}")
    public void getUserById(Integer id){
        userService.getUserById(id);
    }
    @PostMapping  ("/users")
        public List<User> addUser( @RequestBody List<User> users){
            return userService.addUser(users);
        }
    @PutMapping ("/users")
    public void updateUser(@Valid @RequestBody User user ){
        userService.updateUser(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
