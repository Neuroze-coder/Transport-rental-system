package com.accenture.russiaatc.irentservice.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Scooter extends Transport{

    @Column
    private int maxSpeed;

    @Column
    private int chargeLevel;


}
