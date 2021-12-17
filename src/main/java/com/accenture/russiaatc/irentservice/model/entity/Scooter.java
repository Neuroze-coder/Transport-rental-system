package com.accenture.russiaatc.irentservice.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter


public class Scooter extends Transport{

    private Integer maxSpeed;
    private Integer chargeLevel;


}
