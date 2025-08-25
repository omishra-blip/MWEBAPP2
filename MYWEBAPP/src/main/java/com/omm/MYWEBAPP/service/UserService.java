package com.omm.MYWEBAPP.service;

import com.omm.MYWEBAPP.DTO.UserDTo;
import com.omm.MYWEBAPP.DTO.MAPPER.User_Mapper;
import com.omm.MYWEBAPP.model.User;
import com.omm.MYWEBAPP.repo.Userrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceInetrface {

    private final Userrepo userrepo;
    private final User_Mapper user_mapper;


    @Override
    public List<UserDTo> getUsers() {
        return userrepo.findAll().stream().map(user_mapper::toDto).toList();
        }

    @Override
    public UserDTo getUserById(Integer id) {
       return userrepo.findById(id).map(user_mapper::toDto).orElse(null);


    }

    @Override
    public String addUser(List<UserDTo> dTos) {
        userrepo.saveAll(dTos.stream().map(user_mapper::toModel).toList());
        return "User added successfully";

    }

    @Override
    public String updateUser(UserDTo dTos) {
        User user=userrepo.save(user_mapper.toModel(dTos));
        return "User Updated Successfully";
    }

    @Override
    public String deleteUser(Integer id) {
        userrepo.deleteById(id);
        return "User Deleted Successfully";

    }
}

