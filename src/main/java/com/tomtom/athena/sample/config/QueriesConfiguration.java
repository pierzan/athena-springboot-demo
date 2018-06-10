package com.tomtom.athena.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("application.athena")
public class QueriesConfiguration {

    private String topReviewedStatesQuery;
    private String schema;

    public String getTopReviewedStatesQuery() {
        return topReviewedStatesQuery;
    }

    public void setTopReviewedStatesQuery(
        final String topReviewedStatesQuery) {
        this.topReviewedStatesQuery = topReviewedStatesQuery;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(
        final String schema) {
        this.schema = schema;
    }
}
