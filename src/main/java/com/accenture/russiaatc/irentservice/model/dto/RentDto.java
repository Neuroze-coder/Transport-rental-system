package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.enums.TypeRent;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RentDto {
    private Long id;
    private TypeRent status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
