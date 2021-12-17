package com.accenture.russiaatc.irentservice;


import com.accenture.russiaatc.irentservice.access.ParkingRepository;
import com.accenture.russiaatc.irentservice.access.TransportRepository;
import com.accenture.russiaatc.irentservice.access.TransportTypeRepository;
import com.accenture.russiaatc.irentservice.model.converters.TransportMapper;
import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.model.entity.*;
import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransportRepositoryTest {

    @Autowired
    TransportRepository transportRepo;

    @Autowired
    ParkingRepository pzRepo;

    @Autowired
    TransportTypeRepository ttRepo;

    @Autowired
    TransportMapper converter;

    @Test
    @Transactional
    void FindAllTransportTest() {

        System.out.println("Trying to get all transport from DB:");
        var l = transportRepo.findAll();

        for ( var t : l ) {
            if (t instanceof Bike) {
                System.out.print("Велосипед: " + t);
            }
            else if (t instanceof Scooter) {
                System.out.print("Электричка: " + t);
            }
            System.out.println();
        }
        System.out.println();

        Parking parkingZone = pzRepo.getById(1L);
        TransportType transportType = ttRepo.getById(1L);

        Bike b = new Bike();
        b.setSerial("XXX");
        b.setState(TransportState.FREE);
        b.setCondition("GOOD");
        b.setParking(parkingZone);
        b.setType(transportType);
        transportRepo.save(b);

        TransportDto t1 = converter.map((Transport)b);

        Scooter e = new Scooter();
        e.setSerial("Самокат-5");
        e.setState(TransportState.FREE);
        e.setCondition("GOOD");
        e.setParking(parkingZone);
        e.setType(transportType);
        e.setChargeLevel(99);
        e.setMaxSpeed(20);
        transportRepo.save(e);

        TransportDto t2 = converter.map((Transport)e);

        System.out.println("Trying to get all transport from DB:");
        l = transportRepo.findAll();
        for ( var t : l ) {
            if (t instanceof Bike) {
                System.out.print("Велосипед: " + t);
            }
            else if (t instanceof Scooter) {
                System.out.print("Электричка: " + t);
            }
            System.out.println();
        }
        System.out.println();
    }
}
