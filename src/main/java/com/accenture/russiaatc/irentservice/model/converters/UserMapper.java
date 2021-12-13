package com.accenture.russiaatc.irentservice.model.converters;

import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.model.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto userToUserDto (User user);

    User userDtoToUser (UserDto userDto);

    UserLoginDto userToUserLoginDto (User user);

    User userLoginDtoToUser (UserLoginDto userLoginDto);

}
