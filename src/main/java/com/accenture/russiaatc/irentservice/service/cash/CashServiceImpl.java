package com.accenture.russiaatc.irentservice.service.cash;

import com.accenture.russiaatc.irentservice.model.entity.TransportType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class CashServiceImpl implements CashService{
    @Override
    public BigDecimal getTotal(LocalDateTime start, LocalDateTime end, TransportType transportType) {
        BigDecimal moneyPerSecond;
        BigDecimal initialCost = new BigDecimal("50");

        if (transportType.getType().equals("Bike")) {
            moneyPerSecond = new BigDecimal("0.05");
        } else {
            moneyPerSecond = new BigDecimal("0.2");
        }
        BigDecimal second = new BigDecimal(start.until(end, ChronoUnit.SECONDS));

        return second.multiply(moneyPerSecond).add(initialCost);
    }
}
