package com.omm.MYWEBAPP.DTO;

import com.omm.MYWEBAPP.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T13:03:08+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class User_MapperImpl implements User_Mapper {

    @Override
    public UserDTo toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTo.UserDToBuilder userDTo = UserDTo.builder();

        userDTo.id( user.getId() );
        userDTo.name( user.getName() );
        userDTo.email( user.getEmail() );
        userDTo.phno( user.getPhno() );

        return userDTo.build();
    }

    @Override
    public User toModel(UserDTo userDTo) {
        if ( userDTo == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTo.getId() );
        user.setName( userDTo.getName() );
        user.setEmail( userDTo.getEmail() );
        user.setPhno( userDTo.getPhno() );

        return user;
    }
}
