package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.Location;
import com.accenture.russiaatc.irentservice.model.entity.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDto {
    private Long id;

    private String name;

    private Integer radius;

    private Location location;

    private ParkingType typeParking;
}
