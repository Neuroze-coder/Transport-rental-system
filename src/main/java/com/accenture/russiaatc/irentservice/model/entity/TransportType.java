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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

}
