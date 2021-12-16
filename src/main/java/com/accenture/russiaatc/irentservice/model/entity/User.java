package com.accenture.russiaatc.irentservice.model.entity;

import com.accenture.russiaatc.irentservice.model.entity.enums.RoleType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table (name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString (exclude = "password")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    private Long id;

    @Column (name = "login")
    @NotBlank
    @Size (max = 20)
    private String login;

    @Column (name = "name")
    @NotBlank
    private String name;

    @Column (name = "surname")
    @NotBlank
    private String surname;

    @Column (name = "password")
    @NotBlank
    @Size (max = 20)
    private String password;

    @Column (name = "balance")
    @PositiveOrZero
    private BigDecimal balance;

//    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    @NotNull (message = "Роль не может быть пустой")
    private RoleType role;

}
