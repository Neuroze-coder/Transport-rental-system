package com.accenture.russiaatc.irentservice.model.entity;

import com.accenture.russiaatc.irentservice.model.entity.enums.TypeRole;
import lombok.*;

import javax.persistence.*;
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
    private String login;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "password")
    private String password;

    @Column (name = "balance")
    private BigDecimal balance;

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private TypeRole role;

}
