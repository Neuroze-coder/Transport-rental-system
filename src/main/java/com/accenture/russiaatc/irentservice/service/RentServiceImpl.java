package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.access.RentRepository;
import com.accenture.russiaatc.irentservice.model.converters.RentConverter;
import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RentConverter rentConverter;

    @Override
    public RentDto createRent(RentDto rent) {
        return null;
    }

    @Override
    public RentDto saveRent(RentDto rent) {
        return null;
    }

    @Override
    public void deleteRent(Long id) {

    }

    @Override
    public RentDto findById(Long id) {
        return null;
    }

    @Override
    public RentDto findByUserId(Long id) {
        return null;
    }

    @Override
    public List<RentDto> findAll() {
        return null;
    }
}
