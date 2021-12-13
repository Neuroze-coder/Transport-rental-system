package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.TransportType;
import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransportShortDto {
    private Long id;
    private TransportType type;
    private String serial;
    private TransportState state;
}
