package com.accenture.russiaatc.irentservice.service.transport;

import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.model.dto.TransportShortDto;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
public interface TransportService {

    TransportDto create (TransportDto transportDto);

    TransportDto save (TransportDto transportDto);

    void delete (Long id);

    TransportDto findById (Long id);

    List<TransportDto> findAll();

    List<TransportShortDto> findAllFree();

    Transport getById (Long id);

    boolean free(Transport transport);

    void rent(Transport transport);

    void freeTransport(Transport transport);

    TransportShortDto findBySerial(String string);
}
