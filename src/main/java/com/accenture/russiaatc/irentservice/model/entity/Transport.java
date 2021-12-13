package com.accenture.russiaatc.irentservice.model.entity;


import com.accenture.russiaatc.irentservice.model.entity.enums.TypeCondition;
import com.accenture.russiaatc.irentservice.model.entity.enums.TypeTransport;
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

    @OneToOne
    private Parking parking;

    @Column (name = "condition")
    @Enumerated(EnumType.STRING)
    private TypeCondition typeCondition;

    @Column (name = "type")
    @Enumerated(EnumType.STRING)
    private TypeTransport typeTransport;




}
