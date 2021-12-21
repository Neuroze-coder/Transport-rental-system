package com.accenture.russiaatc.irentservice;

import com.accenture.russiaatc.irentservice.access.UserRepository;
import com.accenture.russiaatc.irentservice.model.entity.User;
import com.accenture.russiaatc.irentservice.model.entity.enums.RoleType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class UserRepositoryTest {
    @Test
    void ListUsersList(@Autowired UserRepository usersRepo) {

        System.out.println("Trying to get all users from DB:");
        var l = usersRepo.findAll();
        for ( var t : l ) {
            System.out.println(t);
        }
        System.out.println();
    }

    @Test
    void BigTest(@Autowired UserRepository repository) {

        System.out.println("Trying to get all users from DB:");
        var l = repository.findAll();
        for ( var t : l ) {
            System.out.println(t);
        }
        System.out.println();
        System.out.println("Trying to add user");
        User user = new User();
        user.setLogin("123@mail.com");
        user.setName("123name");
        user.setSurname("123surname");
        user.setPassword("123pass");
        user.setRole(RoleType.USER);
        user.setBalance(new BigDecimal("1000"));
        repository.save(user);
        System.out.println("Added user id: " + user.getId());
        System.out.println("Trying to get all users from DB:");
        l = repository.findAll();
        for ( var t : l ) {
            System.out.println(t);
        }
        System.out.println();
        System.out.println("Trying to delete user by Id");
        repository.deleteById(user.getId());
        System.out.println("Trying to get all users from DB:");
        l = repository.findAll();
        for ( var t : l ) {
            System.out.println(t);
        }
        System.out.println();
    }
}
