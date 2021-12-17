package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportTypeRepository extends JpaRepository<TransportType, Long> {
}
