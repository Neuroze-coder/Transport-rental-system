package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser (String login, String name, String surname, String password, TypeRole typeRole);

    UserDto saveUser (UserDto user);

    void deleteUser (Long userID);

    UserDto findById (Long id);

    UserDto findByLogin (String login);

    List<UserLoginDto> findByAll();
}
