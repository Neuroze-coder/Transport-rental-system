package com.accenture.russiaatc.irentservice.model.entity;


import com.accenture.russiaatc.irentservice.model.entity.enums.TypeRent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cust", sequenceName = "seq_cust", allocationSize = 1)
    private Long id;

    @OneToOne
    private Parking startLocation;

    @OneToOne
    private Parking finalLocation;

    @ManyToOne
    private User user;

    @ManyToOne
    private Transport transport;

    @Column (name = "start_time")
    private LocalDateTime startTime;

    @Column (name = "end_time")
    private LocalDateTime endTime;

    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private TypeRent status;

}
