package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.TransportType;
import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class TransportShortDto {
    private Long id;
    private TransportState state;
    @Column (name = "serial")
    private String serial;
    private TransportType type;
}
