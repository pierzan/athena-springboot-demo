package com.tomtom.athena.sample.controllers;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomtom.athena.sample.controllers.dto.BusinessComposedDto;
import com.tomtom.athena.sample.db.AthenaRepository;

@RestController
public class MapDataProvider {

    @Autowired
    private AthenaRepository athenaRepository;

    @RequestMapping("/topReviewedStates")
    public Collection<BusinessComposedDto> getTopReviewedStates() {
        return athenaRepository.getTopReviewedBusinesses()
            .stream()
            .map(bo -> new BusinessComposedDto(bo.getState(), bo.getTotalNoOfReviews()))
            .collect(Collectors.toSet());
    }

}
