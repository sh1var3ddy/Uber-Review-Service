package com.example.UberReviewService.Services;

import com.example.UberReviewService.models.*;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public void run(String... args) throws Exception {
//        Review r = Review.builder()
//                .Content("Great experience")
//                .Rating(4.5)
//                .build();
//        Booking b = Booking
//                .builder()
//                .bookingStatus(BookingStatus.COMPLETED)
//                .startTime(new Date())
//                .endTime(new Date())
//                .driverReview(r)
//                .totalDistance(6L)
//                .build();
//       //reviewRepository.save(r);// this code executes sql query
//        bookingRepository.save(b);
//        Optional<Booking> x  = bookingRepository.findById(2L);
//        List<Driver> drivers = driverRepository.findAll();
//        Optional<Driver> driver = driverRepository.findById(1L);
//
//        if(driver.isPresent()){
//            System.out.println(driver.get().getName());
//            List<Booking> b = driver.get().getBookings();
////            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            for(Booking booking:b){
//                System.out.println(booking.getId());
//            }
//        }
//        Optional<Driver> d = driverRepository.rawFindByIdAndLicenseNumber(1L,"TG4523432");
//        System.out.println(d.get().getName());
        Optional<Driver> d = driverRepository.hqlFindByIdAndLicense(1L,"TG4523432");
        System.out.println(d.get().getName());

    }
}
