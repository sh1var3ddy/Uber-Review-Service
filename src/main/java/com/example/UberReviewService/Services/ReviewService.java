package com.example.UberReviewService.Services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository,DriverRepository driverRepository){
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<Long> driverIds = new ArrayList<Long>(Arrays.asList(1L, 2L,3L,4L));

        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

//        List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);

        for(Driver driver:drivers){
            List<Booking> bookings = driver.getBookings();
            for(Booking booking:bookings){
                System.out.println(booking.getId());
            }
        }



    }
}
