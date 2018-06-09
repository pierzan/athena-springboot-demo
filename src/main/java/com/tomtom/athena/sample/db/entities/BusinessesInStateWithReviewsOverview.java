package com.tomtom.athena.sample.db.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusinessesInStateWithReviewsOverview {

    private String state;
    private Long totalNoOfReviews;

}
