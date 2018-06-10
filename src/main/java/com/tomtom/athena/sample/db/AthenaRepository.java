package com.tomtom.athena.sample.db;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.tomtom.athena.sample.config.QueriesConfiguration;
import com.tomtom.athena.sample.db.entities.BusinessesInStateWithReviewsOverview;

@Component
public class AthenaRepository {

    private static final Logger log = LoggerFactory.getLogger(AthenaRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private QueriesConfiguration queriesConfiguration;


    public Collection<BusinessesInStateWithReviewsOverview> getTopReviewedBusinesses() {
        log.info("Querying for business with reviews overview records:");
        String query = queriesConfiguration.getTopReviewedStatesQuery();
        List<BusinessesInStateWithReviewsOverview> businesses = jdbcTemplate.query(adjustQuerySchema(query),
            new BeanPropertyRowMapper<BusinessesInStateWithReviewsOverview>(BusinessesInStateWithReviewsOverview.class));
        businesses.forEach(business -> log.info(business.toString()));
        return businesses;
    }

    private String adjustQuerySchema(
        final String query) {
        Map<String, String> substitutionMap = Maps.newHashMap();
        substitutionMap.put("schema", queriesConfiguration.getSchema());
        StrSubstitutor substitutor = new StrSubstitutor(substitutionMap);
        return substitutor.replace(query);
    }

}
