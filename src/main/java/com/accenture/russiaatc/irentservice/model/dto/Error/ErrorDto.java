package com.accenture.russiaatc.irentservice.model.dto.Error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {

    private Integer code;
    private String message;

    public ErrorDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
