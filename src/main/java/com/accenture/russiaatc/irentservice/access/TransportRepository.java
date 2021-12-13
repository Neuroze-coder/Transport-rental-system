package com.accenture.russiaatc.irentservice.access;

import com.accenture.russiaatc.irentservice.model.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository <Transport, Long> {
}
