package com.tomtom.athena.sample.db;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tomtom.athena.sample.db.entities.BusinessesInStateWithReviewsOverview;

@Component
public class AthenaRepository {

    private static final Logger log = LoggerFactory.getLogger(AthenaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Qualifier("athenaQuery")
    @Autowired
    private String topReviewedStatesQuery;


    public Collection<BusinessesInStateWithReviewsOverview> getTopReviewedBusinesses() {
        log.info("Querying for business with reviews overview records:");
        String query = topReviewedStatesQuery;
        List<BusinessesInStateWithReviewsOverview> businesses =
            jdbcTemplate.query(query,
            new BeanPropertyRowMapper<BusinessesInStateWithReviewsOverview>(BusinessesInStateWithReviewsOverview.class));
        businesses.forEach(business -> log.info(business.toString()));
        return businesses;
    }

}
