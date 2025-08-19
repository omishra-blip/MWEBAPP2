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
             return userrepo.findById(id).orElse(new User());


    }
    public String addUser(List<User> user){
         userrepo.saveAll(user);
         return "User added successfully";

    }
    public String updateUser(User user){
        userrepo.save(user);
        return "User Updated Successfully";
    }
    public String deleteUser(Integer id){
        userrepo.deleteById(id);
        return "User Deleted Successfully";

    }
}

