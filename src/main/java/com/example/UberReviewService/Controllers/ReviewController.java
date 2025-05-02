package com.example.UberReviewService.Controllers;

import com.example.UberReviewService.Services.ReviewService;
import com.example.UberReviewService.models.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> publishReview(@RequestBody Review review) {
        Review reviewSaved = this.reviewService.publishReview(review);
        return new ResponseEntity<>(reviewSaved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable long reviewId) {
        try {
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            if (review.isPresent()) {
                return new ResponseEntity<>(review.get(), HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return null;
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable long reviewId) {
        try{
            boolean success = this.reviewService.deleteReviewById(reviewId);
            if (success) {
                return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Review could not be deleted",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReviewById(@PathVariable long reviewId, @RequestBody Review review) {
        try{
            Review newReview = this.reviewService.updateReview(reviewId,review);
            return new ResponseEntity<>(newReview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
