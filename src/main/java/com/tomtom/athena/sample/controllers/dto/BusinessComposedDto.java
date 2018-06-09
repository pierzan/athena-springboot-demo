package com.tomtom.athena.sample.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BusinessComposedDto {
    private String state;
    private Long totalNoOfReviews;
}
