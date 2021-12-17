package com.accenture.russiaatc.irentservice.model.entity;


import com.accenture.russiaatc.irentservice.model.entity.enums.RentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Parking startLocation;

    @ManyToOne
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
    private RentStatus status;

    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", startLocation=" + startLocation +
                ", finalLocation=" + finalLocation +
                ", user=" + user +
                ", transport=" + transport +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
