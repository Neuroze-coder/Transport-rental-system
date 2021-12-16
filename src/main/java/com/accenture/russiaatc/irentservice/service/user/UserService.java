package com.accenture.russiaatc.irentservice.service.user;

import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.model.entity.User;
import com.accenture.russiaatc.irentservice.model.entity.enums.RoleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser (String login, String name, String surname, String password, RoleType typeRole);

    UserDto saveUser (UserDto user);

    void deleteUser (Long userID);

    UserDto findById (Long id);

    UserDto findByLogin (String login);

    List<UserLoginDto> findByAll();

    User getById (Long id);

    boolean canRent(User user);

    boolean UserExistByLogin(String userName);

}
