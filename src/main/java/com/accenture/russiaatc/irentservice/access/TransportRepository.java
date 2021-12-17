package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.Transport;
import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TransportRepository extends JpaRepository <Transport, Long> {
    List<Transport> findAllByState (TransportState state);
    Transport findBySerial(String serial);
}
