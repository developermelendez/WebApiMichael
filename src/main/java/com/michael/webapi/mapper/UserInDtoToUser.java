package com.michael.webapi.mapper;

import org.springframework.stereotype.Component;

import com.michael.webapi.persistence.entity.User;
import com.michael.webapi.service.dto.UserInDto;

@Component
public class UserInDtoToUser implements IMapper<UserInDto,User>{

    @Override
    public User map(UserInDto in) {        
        User user = new User();
        user.setName(in.getName());
        return user;
    }

}
