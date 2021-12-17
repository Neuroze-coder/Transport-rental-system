package com.accenture.russiaatc.irentservice.model.entity;

import com.accenture.russiaatc.irentservice.model.entity.enums.ParkingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_parking")
    @Enumerated(EnumType.STRING)
    private ParkingType typeParking;

    @Column(name = "radius")
    private Integer radius;

    @OneToOne
    private Location location;

}
