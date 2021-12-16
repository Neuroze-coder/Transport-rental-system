package com.accenture.russiaatc.irentservice.service.rent;

import com.accenture.russiaatc.irentservice.error.BusinessRuntimeException;
import com.accenture.russiaatc.irentservice.error.ErrorCodeEnum;
import com.accenture.russiaatc.irentservice.access.RentRepository;
import com.accenture.russiaatc.irentservice.model.converters.RentMapper;
import com.accenture.russiaatc.irentservice.model.dto.RentDto;
import com.accenture.russiaatc.irentservice.model.entity.Rent;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import com.accenture.russiaatc.irentservice.model.entity.User;
import com.accenture.russiaatc.irentservice.model.entity.enums.RentStatus;
import com.accenture.russiaatc.irentservice.service.transport.TransportService;
import com.accenture.russiaatc.irentservice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    private final UserService userService;
    private final TransportService transportService;
    private final RentMapper rentMapper;

    @Autowired
    public RentServiceImpl(RentRepository rentRepository, UserService userService, TransportService transportService, RentMapper rentMapper) {
        this.rentRepository = rentRepository;
        this.userService = userService;
        this.transportService = transportService;
        this.rentMapper = rentMapper;
    }

    @Override
    public RentDto createRent(Long userId, Long transportId) {
        Rent createdRent;

        User user = userService.getById(userId);
        Transport transport = transportService.getById(transportId);

        if (!userService.canRent(user)) {
            throw new BusinessRuntimeException(ErrorCodeEnum.USER_CANT_RENT, user.getId());
        }

        if (!transportService.free(transport)) {
            throw new BusinessRuntimeException(ErrorCodeEnum.TRANSPORT_NOT_AVAILABLE, transport.getId());
        }

        Rent rent = new Rent();
        rent.setStatus(RentStatus.IN_PROGRESS);
        rent.setUser(user);
        rent.setTransport(transport);
        rent.setStartTime(LocalDateTime.now());
        rent.setEndTime(LocalDateTime.now());
        rent.setStartLocation(transport.getParking());
        rent.setFinalLocation(transport.getParking());

        createdRent = rentRepository.save(rent);

        transportService.rent(transport);

        return rentMapper.map(createdRent);
    }

    @Override
    public RentDto closeRent (Long rentId) {

        Rent rent = getById(rentId);

        rent.setEndTime(LocalDateTime.now());
        rent.setStatus(RentStatus.FINISHED);
        Rent savedRent = rentRepository.save(rent);

        transportService.freeTransport(rent.getTransport());

        return rentMapper.map(savedRent);
    }

    @Override
    public Rent getById (Long id) {
        return rentRepository.getById(id);
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
    public List<RentDto> findByUserId(Long id) {
        return rentRepository.findByUserId(id)
                .stream()
                .map(rentMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentDto> findAll() {
        return null;
    }
}
