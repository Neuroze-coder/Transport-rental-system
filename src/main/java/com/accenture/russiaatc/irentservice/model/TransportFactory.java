package com.accenture.russiaatc.irentservice.model;

import com.accenture.russiaatc.irentservice.model.converters.ParkingMapper;
import com.accenture.russiaatc.irentservice.model.dto.TransportDto;
import com.accenture.russiaatc.irentservice.model.entity.Bike;
import com.accenture.russiaatc.irentservice.model.entity.Scooter;
import com.accenture.russiaatc.irentservice.model.entity.Transport;
import com.accenture.russiaatc.irentservice.model.entity.enums.ConditionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportFactory {

    private final ParkingMapper parkingMapper;

    @Autowired
    public TransportFactory(ParkingMapper parkingMapper) {
        this.parkingMapper = parkingMapper;
    }

    public Transport createFromTransportDto (TransportDto transportDto) {
        Transport transport;
        switch (transportDto.getType().toString().toLowerCase()) {
            case "bike":
                transport = new Bike();
                break;
            case "scooter":
                Scooter scooter = new Scooter();
                scooter.setMaxSpeed(transportDto.getMaxSpeed());
                scooter.setChargeLevel(transportDto.getChargeLevel());
                transport = scooter;
                break;
            default:
                throw new IllegalArgumentException();
        }
        transport.setId(transportDto.getId());
        transport.setState(transportDto.getState());
        transport.setSerial(transportDto.getSerial());
        transport.setType(transportDto.getType());
        transport.setParking(parkingMapper.map(transportDto.getParkingDto()));
        transport.setTypeCondition(ConditionType.valueOf(transportDto.getCondition()));
        return transport;
    }
}
