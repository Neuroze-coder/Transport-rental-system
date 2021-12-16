package com.accenture.russiaatc.irentservice.controller;

import com.accenture.russiaatc.irentservice.model.dto.ParkingDto;
import com.accenture.russiaatc.irentservice.service.parking.ParkingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkings")
public class ParkingController {
    @Autowired
    ParkingServiceImpl parkingService;

    @GetMapping("")
    public List<ParkingDto> parkingDtoList(){
        return parkingService.findAll();
    }

    @GetMapping("/{id}")
    public ParkingDto getParking (@PathVariable Long id) {
        return parkingService.findById(id);
    }

    @PostMapping
    public ParkingDto createParking (@RequestBody ParkingDto parkingDto) {
        return parkingService.saveParking(parkingDto);
    }

    @PostMapping("/{id}")
    public ParkingDto updateParking (@RequestBody ParkingDto parkingDto) {
        return parkingService.saveParking(parkingDto);
    }

    @DeleteMapping
    public void deleteParking (@RequestBody ParkingDto parkingDto ) {
        parkingService.deleteParking(parkingDto.getId());
    }

}
