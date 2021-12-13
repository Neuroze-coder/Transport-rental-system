package com.accenture.russiaatc.irentservice.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "transport_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransportType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    private Long id;

    private String type;

}
