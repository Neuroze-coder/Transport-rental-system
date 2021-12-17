package com.accenture.russiaatc.irentservice.service.cash;

import com.accenture.russiaatc.irentservice.model.entity.TransportType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public interface CashService {
    BigDecimal getTotal (LocalDateTime start, LocalDateTime end, TransportType transportType);
}
