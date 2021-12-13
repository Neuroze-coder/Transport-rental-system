package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.access.UserRepository;
import com.accenture.russiaatc.irentservice.model.converters.UserMapper;
import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeRole;
import com.accenture.russiaatc.irentservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(String login, String name, String surname, String password, TypeRole typeRole) {
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setRole(typeRole);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User savedUser = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Long userID) {
    userRepository.deleteById(userID);
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.userToUserDto(userRepository.findById(id));
    }

    @Override
    public UserDto findByLogin(String login) {
        User users = userRepository.findByLogin(login);
        if (users != null) {
            return userMapper.userToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UserLoginDto> findByAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserLoginDto)
                .collect(Collectors.toList());
    }
}
