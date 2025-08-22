package com.omm.MYWEBAPP.DTO.MAPPER;

import com.omm.MYWEBAPP.DTO.UserDTo;
import com.omm.MYWEBAPP.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface User_Mapper {

    UserDTo toDto(User user);

    User toModel(UserDTo userDTo);


}
