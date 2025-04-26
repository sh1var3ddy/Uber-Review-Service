package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    CascadeType.REMOVE will ensure deleting record from booking will delete the associated review from Review table
    private Review driverReview;
    // we have defined a one to one relation between booking and review

    @Enumerated(value= EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(value= TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value= TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

}
