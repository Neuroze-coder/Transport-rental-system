package com.accenture.russiaatc.irentservice.model.entity;

import com.accenture.russiaatc.irentservice.model.entity.enums.TypeCondition;
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
