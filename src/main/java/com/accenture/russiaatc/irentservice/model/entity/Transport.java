package com.accenture.russiaatc.irentservice.model.entity;


import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "transport")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String condition;

    @ManyToOne
    @JoinColumn (name = "type_id")
    private TransportType type;

    @ManyToOne
    @JoinColumn (name = "parking_id")
    private Parking parking;

    @Column (name = "serial")
    private String serial;

    @Enumerated(EnumType.STRING)
    private TransportState state;

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", condition='" + condition + '\'' +
                ", type=" + type +
                ", parking=" + parking +
                ", serial='" + serial + '\'' +
                ", state=" + state +
                '}';
    }
}
