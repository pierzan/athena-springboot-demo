# athena-springboot-demo


1. configure aws credentials:

 rename **gradle.properties.default**.to **gradle.properties** and fill in the template base on file provided on workshop

1. Change database configuration in **_src/main/resources/application.yaml_**:
    - replace \[jdbcURL] with proper athena jdbc URL
    - replace \[awsAccessKey] and \[awsSecretKey] with credentials provided during workshop

1. Prepare the query - edit file **_src/main/resources/application-athena-query.yaml_**
    - replace \[THE_QUERY] with query that will return top 50 reviewed states (states in which businesses totaly have most reviews)
    - the query needs to return 2 columns: state, totlNoOfReviews

1. Run
   ```
   ./gradlew bootRun
   ```
  and go to [http://localhost:8080] and click the button to see the results.

