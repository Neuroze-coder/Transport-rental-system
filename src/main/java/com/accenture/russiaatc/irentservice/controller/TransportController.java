package com.accenture.russiaatc.irentservice.controller;

import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.service.transport.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class TransportController {

    private final TransportService transportService;

    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping("")
    public List<TransportDto> list () {
        return transportService.findAll();
    }

    @GetMapping ("/{id}")
    public TransportDto get (@PathVariable Long id) {
        return transportService.findById(id);
    }
    @PostMapping
    public TransportDto create (@RequestBody TransportDto transport) {
        return transportService.create(transport);
    }

    @PutMapping ("/{id}")
    public TransportDto updateUser (@RequestBody TransportDto transport) {
        return transportService.save(transport);
    }

    @DeleteMapping
    public void deleteUser (@RequestBody TransportDto transport) {
        transportService.delete(transport.getId());
    }
}
