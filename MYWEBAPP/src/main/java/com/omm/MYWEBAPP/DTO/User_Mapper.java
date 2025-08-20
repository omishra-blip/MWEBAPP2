package com.omm.MYWEBAPP.DTO;

import com.omm.MYWEBAPP.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface User_Mapper {

    UserDTo toDto(User user);
    User toModel(UserDTo userDTo);


}
