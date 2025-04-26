package com.example.UberReviewService.models;

import jakarta.persistence.Column;
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

public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();


}
