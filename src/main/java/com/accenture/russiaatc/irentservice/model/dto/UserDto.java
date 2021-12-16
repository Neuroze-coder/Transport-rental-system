package com.accenture.russiaatc.irentservice.model.dto;

import com.accenture.russiaatc.irentservice.model.entity.enums.RoleType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
public class UserDto {

    private Long id;
    @NotBlank
    @Size (max = 20)
    private String login;
    private String name;
    private String surname;
    @NotBlank
    @Size (max = 20)
    private String password;

    @PositiveOrZero
    private BigDecimal balance;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "Роль не может быть пустой")
    private RoleType role;
}
