package com.accenture.russiaatc.irentservice.service.rent;

import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.entity.Rent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentService {

    RentDto saveRent(RentDto rent);

    void deleteRent(Long id);

    RentDto findById(Long id);

    List<RentDto> findByUserId(Long id);

    List<RentDto> findAll();

    RentDto createRent(Long userId, Long transportId);

    RentDto closeRent(Long rentId);

    Rent getById(Long id);

}
