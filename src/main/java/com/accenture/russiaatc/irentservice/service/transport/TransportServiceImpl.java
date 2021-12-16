package com.accenture.russiaatc.irentservice.service.transport;

import com.accenture.russiaatc.irentservice.error.BusinessRuntimeException;
import com.accenture.russiaatc.irentservice.error.ErrorCodeEnum;
import com.accenture.russiaatc.irentservice.access.TransportRepository;
import com.accenture.russiaatc.irentservice.model.TransportFactory;
import com.accenture.russiaatc.irentservice.model.converters.TransportMapper;
import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportShortDto;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
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
        return save(transportDto);
    }

    @Override
    public TransportDto save(TransportDto transportDto) {
        Transport t = factory.createFromTransportDto(transportDto);
        Transport saved = repository.save(t);
        return mapper.map(saved);
    }



    @Override
    public void delete(Long id) {
        Transport transport = getById(id);
        transport.setState(TransportState.DELETED);
        repository.save(transport);
    }

    @Override
    public TransportDto findById(Long id) {
        return mapper.map(getById(id));
    }

    @Override
    public List<TransportDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<TransportShortDto> findAllFree() {
        return repository.findAllByState(TransportState.FREE)
                .stream()
                .map(mapper::entityShortDto)
                .collect(Collectors.toList());
    }

    @Override
    public Transport getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessRuntimeException(ErrorCodeEnum.USER_NO_FOUND, id));
    }

    @Override
    public boolean free(Transport transport) {
        return transport.getState() == TransportState.FREE;
    }

    @Override
    public void rent(Transport transport) {
        transport.setState(TransportState.BUSY);
        repository.save(transport);
    }

    @Override
    public void freeTransport(Transport transport) {
        transport.setState(TransportState.FREE);
        repository.save(transport);
    }

    @Override
    public TransportShortDto findBySerial(String serial) {
        return mapper.entityShortDto(repository.findBySerial(serial));
    }


}
