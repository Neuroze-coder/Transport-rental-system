package com.accenture.russiaatc.irentservice.controller;

import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.model.dto.UserDto;
import com.accenture.russiaatc.irentservice.security.CallContext;
import com.accenture.russiaatc.irentservice.security.SecurityContext;
import com.accenture.russiaatc.irentservice.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/current")
    public UserLoginDto getCurrent () {
        CallContext callContext = SecurityContext.get();
        return UserLoginDto.builder().login(callContext.getLogin()).role(callContext.getRole()).balance(new BigDecimal(0)).build();
    }

    @GetMapping("/{id}")
    public UserDto user (@PathVariable Long id) {
        return userServiceImpl.findById(id);
    }

    @PostMapping
    public UserDto createUser (@RequestBody @Validated UserDto user) {
        return userServiceImpl.createUser(user.getLogin(), user.getName(), user.getSurname(), user.getPassword(), user.getRole());
    }

    @PostMapping("/{id}")
    public UserDto updateUser(@RequestBody @Validated UserDto user) {
        return userServiceImpl.saveUser(user);
    }

    @DeleteMapping
    public void deleteUser (@RequestBody UserDto user) {
        userServiceImpl.deleteUser(user.getId());
    }




}
