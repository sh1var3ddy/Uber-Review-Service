package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();


}
