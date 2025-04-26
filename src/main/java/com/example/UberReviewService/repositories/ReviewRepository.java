package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Tablename(Type), PrimaryKey(Type)
/*JpaRepository is interface, will have all the methods unimplemented so,
if we extend that as class we need to implement all the methods, instead we extend it
by changing our class to interface and provide out table type and primary key type

 */

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

}
