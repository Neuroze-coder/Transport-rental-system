package com.accenture.russiaatc.irentservice.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserLoginDto {
    private Long id;
    private String login;
    private String role;
    private BigDecimal balance;
}
