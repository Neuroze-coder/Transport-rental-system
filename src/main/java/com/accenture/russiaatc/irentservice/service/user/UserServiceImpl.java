package com.accenture.russiaatc.irentservice.service.user;

import com.accenture.russiaatc.irentservice.error.BusinessRuntimeException;
import com.accenture.russiaatc.irentservice.error.ErrorCodeEnum;
import com.accenture.russiaatc.irentservice.access.UserRepository;
import com.accenture.russiaatc.irentservice.model.converters.UserMapper;
import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.model.entity.enums.RoleType;
import com.accenture.russiaatc.irentservice.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(String login, String name, String surname, String password, RoleType typeRole) {
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
        return userMapper.userToUserDto(getById(id));
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

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(ErrorCodeEnum.USER_NO_FOUND, id));
    }

    @Override
    public boolean canRent(User user) {
        return user.getBalance().compareTo(BigDecimal.ZERO) != 0;
    }


    @Override
    public boolean userExistByLogin(String userName) {
        User user = userRepository.findByLogin(userName);
        return user != null;
    }
}
