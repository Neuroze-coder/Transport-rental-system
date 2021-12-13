package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.Parking;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeCondition;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeTransport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransportDto {

    private Long id;

    private Parking Parking;

    private TypeTransport typeTransport;

    private TypeCondition typeCondition;

}
