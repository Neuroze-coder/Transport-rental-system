package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.enums.RentStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class RentDto {
    private Long id;
    private RentStatus status;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private UserLoginDto userLoginDto;
    private TransportShortDto vehicle;
    private ParkingDto startParking;
    private ParkingDto finishParking;
    private BigDecimal totalPrice;

}
