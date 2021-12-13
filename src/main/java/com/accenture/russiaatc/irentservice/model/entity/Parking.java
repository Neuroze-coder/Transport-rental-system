package com.accenture.russiaatc.irentservice.model.entity;

import com.accenture.russiaatc.irentservice.model.entity.enums.TypeParking;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_parking")
    @Enumerated(EnumType.STRING)
    private TypeParking typeParking;

    @Column(name = "radius")
    private Integer radius;

    @OneToOne
    private Location location;

}
