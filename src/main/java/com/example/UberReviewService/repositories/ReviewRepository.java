package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Passenger;
import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//Tablename(Type), PrimaryKey(Type)
/*JpaRepository is interface, will have all the methods unimplemented so,
if we extend that as class we need to implement all the methods, instead we extend it
by changing our class to interface and provide out table type and primary key type

 */

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    Integer countAllByRatingIsLessThanEqual(Double rating);

    List<Review> findAllByRatingIsLessThanEqual(Double rating);

    List<Review> findAllByCreatedAtBefore(Date createdAt);

    @Query("select r from Booking b inner join Review r where b.Id = :bookingId")
    Review findReviewByBookingId(Long booklingId);

}