package com.omm.MYWEBAPP.service;

import com.omm.MYWEBAPP.DTO.UserDTo;

import java.util.List;

public interface UserServiceInetrface {
    List<UserDTo> getUsers();

    UserDTo getUserById(Integer id);

    String addUser(List<UserDTo> dTos);

    String updateUser(UserDTo dTos);

    String deleteUser(Integer id);
}
