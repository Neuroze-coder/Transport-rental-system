package com.accenture.russiaatc.irentservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaDto {
    private LocationDto center;
    private Integer radiusInMeters;
}
