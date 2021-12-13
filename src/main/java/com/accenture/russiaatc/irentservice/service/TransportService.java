package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TransportService {

    TransportDto create (TransportDto transportDto);

    TransportDto save (TransportDto transportDto);

    void delete (Long id);

    TransportDto findById (Long id);

    List<TransportDto> findAll();
}
