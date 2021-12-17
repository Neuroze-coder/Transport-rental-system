package com.accenture.russiaatc.irentservice.controller;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.dto.UserLoginDto;
import com.accenture.russiaatc.irentservice.service.rent.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentController {

    private final RentServiceImpl rentService;

    @Autowired
    public RentController(RentServiceImpl rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/view")
    public List<RentDto> getRentByUserId() {

        return rentService.findAll();
    }

    @PostMapping("/{transportId}")
    public RentDto createRent(@RequestBody UserLoginDto user, @PathVariable Long transportId) {
        return rentService.createRent(user.getId(), transportId);
    }

    @PostMapping("/close/{rentId}")
    public RentDto closeRent (@PathVariable Long rentId) {
        return rentService.closeRent(rentId);
    }
}
