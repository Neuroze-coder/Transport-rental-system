package com.accenture.russiaatc.irentservice.model.entity;


import com.accenture.russiaatc.irentservice.model.entity.enums.TransportState;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeCondition;
import lombok.*;

import javax.persistence.*;

@Inheritance (strategy = InheritanceType.JOINED)
@Entity
@Table(name = "transport")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    private Long id;

    @Column (name = "condition")
    @Enumerated(EnumType.STRING)
    private TypeCondition typeCondition;

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


}
