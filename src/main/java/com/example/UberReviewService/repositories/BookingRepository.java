package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findAllByDriverId(Long driverId);
}
