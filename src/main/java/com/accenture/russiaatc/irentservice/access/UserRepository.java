package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, Integer> {

    User findByLogin (String login);

    User findById (Long id);

    void deleteById(Long userID);
}
