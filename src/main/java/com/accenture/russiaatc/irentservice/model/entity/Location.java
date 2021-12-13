package com.accenture.russiaatc.irentservice.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "location")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    private Long id;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private String name;


}
