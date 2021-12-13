package com.accenture.russiaatc.irentservice.service;

import com.accenture.russiaatc.irentservice.access.TransportRepository;
import com.accenture.russiaatc.irentservice.model.TransportFactory;
import com.accenture.russiaatc.irentservice.model.converters.TransportMapper;
import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportServiceImpl implements TransportService {

    private final TransportRepository repository;
    private final TransportMapper mapper;
    private final TransportFactory factory;

    @Autowired
    public TransportServiceImpl(TransportRepository repository, TransportMapper mapper, TransportFactory factory) {
        this.repository = repository;
        this.mapper = mapper;
        this.factory = factory;
    }

    @Override
    public TransportDto create(TransportDto transportDto) {
        Transport t = factory.createFromTransportDto(transportDto);
        Transport saved = repository.save(t);
        return mapper.map(saved);
    }

    @Override
    public TransportDto save(TransportDto parking) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TransportDto findById(Long id) {
        return mapper.map(repository.findById(id).orElseThrow());
    }

    @Override
    public List<TransportDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
