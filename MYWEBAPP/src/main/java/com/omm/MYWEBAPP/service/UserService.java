package com.omm.MYWEBAPP.service;

import com.omm.MYWEBAPP.model.User;
import com.omm.MYWEBAPP.repo.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    Userrepo userrepo;


    public UserService(Userrepo userrepo) {
        this.userrepo = userrepo;
    }
    public List<User> getUsers(){
        return userrepo.findAll();
    }
    public User getUserById(Integer id){
        return   userrepo.findById(id).orElse(new User());

    }
    public  List<User> addUser(List<User> user){
          return userrepo.saveAll(user);

    }
    public void updateUser(User user){
        userrepo.save(user);
    }
    public void deleteUser(Integer id){
        userrepo.deleteById(id);

    }
}

