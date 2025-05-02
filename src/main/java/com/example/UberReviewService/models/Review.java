package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

// if you want to manually name your table u can use @Table(name="xyz")
@Inheritance(strategy = InheritanceType.JOINED)

public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;

}
