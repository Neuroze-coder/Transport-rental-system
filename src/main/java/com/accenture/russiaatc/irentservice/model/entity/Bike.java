package com.accenture.russiaatc.irentservice.model.entity;

import com.accenture.russiaatc.irentservice.model.entity.enums.TypeCondition;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeTransport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "bike")

@Getter
@Setter
@ToString

public class Bike extends Transport {

    public Bike () {
        this.setTypeTransport(TypeTransport.BIKE);
        this.setTypeCondition(TypeCondition.EXCELLENT);
    }
}
