package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentService {

    RentDto createRent (RentDto rent);

    RentDto saveRent (RentDto rent);

    void deleteRent (Long id);

    RentDto findById (Long id);

    RentDto findByUserId(Long id);

    List <RentDto> findAll();
}
