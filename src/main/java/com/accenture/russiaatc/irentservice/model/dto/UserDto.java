package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.enums.TypeRole;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserDto {
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private BigDecimal balance;
    private TypeRole typeRole;
}
