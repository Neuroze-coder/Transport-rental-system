package com.accenture.russiaatc.irentservice.controller;

import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {
    @Autowired
     UserServiceImpl userServiceImpl;

    @GetMapping("")
    public List<UserLoginDto> listUsers() {
        return userServiceImpl.findByAll();
    }
    @GetMapping("/{id}")
    public UserDto user (@PathVariable Long id) {
        return userServiceImpl.findById(id);
    }

    @PostMapping
    public UserDto createUser (@RequestBody UserDto user) {
        return userServiceImpl.createUser(user.getLogin(), user.getName(), user.getSurname(), user.getPassword(), user.getTypeRole());
    }

    @PostMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto user) {
        return userServiceImpl.saveUser(user);
    }

    @DeleteMapping
    public void deleteUser (@RequestBody UserDto user) {
        userServiceImpl.deleteUser(user.getId());
    }




}
