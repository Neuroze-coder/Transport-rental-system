package com.accenture.russiaatc.irentservice;

import com.accenture.russiaatc.irentservice.access.ParkingRepository;
import com.accenture.russiaatc.irentservice.access.RentRepository;
import com.accenture.russiaatc.irentservice.access.TransportRepository;
import com.accenture.russiaatc.irentservice.access.UserRepository;
import com.accenture.russiaatc.irentservice.model.converters.RentMapper;
import com.accenture.russiaatc.irentservice.model.entity.Parking;
import com.accenture.russiaatc.irentservice.model.entity.Rent;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import com.accenture.russiaatc.irentservice.model.entity.User;
import com.accenture.russiaatc.irentservice.model.entity.enums.RentStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
@Slf4j
public class TripRepositoryTest {

    @Test
    void FindAllTest(@Autowired RentRepository repository) {
        log.info("Trying to get all trips from DB:");
        var l = repository.findAll();
        for (var t : l) {
            log.info(t.toString());
        }
    }

    @Test
    void AddNewTrip(@Autowired RentRepository rentRepo,
                    @Autowired UserRepository userRepository,
                    @Autowired TransportRepository transportRepo,
                    @Autowired ParkingRepository parkingRepository,
                    @Autowired RentMapper converter) {

        User user = userRepository.getById(2L);
        Transport transport = transportRepo.getById(2L);
        Parking parking = parkingRepository.getById(1L);

        Rent rent = new Rent();
        rent.setStatus(RentStatus.IN_PROGRESS);
        rent.setUser(user);
        rent.setTransport(transport);
        rent.setStartTime(LocalDateTime.now());
        rent.setEndTime(LocalDateTime.now());
        rent.setStartLocation(parking);
        rent.setFinalLocation(parking);

        assertNull(rent.getId());

        rentRepo.save(rent);

        assertNotNull(rent.getId());

        log.info(rent.toString());
    }
}
