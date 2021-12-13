package com.accenture.russiaatc.irentservice.model.entity;

import com.accenture.russiaatc.irentservice.model.entity.enums.TypeCondition;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeTransport;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "scooter")

@Getter
@Setter
@ToString

public class Scooter extends Transport{

    @Column
    private int maxSpeed;

    @Column
    private int chargeLevel;

    public Scooter () {
        this.setTypeTransport(TypeTransport.SCOOTER);
        this.setTypeCondition(TypeCondition.EXCELLENT);
    }



}
