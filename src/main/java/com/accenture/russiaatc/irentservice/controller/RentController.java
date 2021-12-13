package com.accenture.russiaatc.irentservice.controller;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.service.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/rents")
public class RentController {

    @Autowired
    RentServiceImpl rentService;

    @GetMapping("/{id}")
    public RentDto getRentByUserId(@PathVariable Long id) {
        RentDto r = rentService.findByUserId(id);
        return r;
    }
}
