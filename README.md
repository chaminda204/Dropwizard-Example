# Dropwizard-Example

Sample app using Dropwizard, JDBI, Swagger, AssertJ etc.

========================================================
# Building and running the Example

Build the example

$ mvn clean package

To deploy dropwizard sample
 
 java -jar target/DestinationAPI-1.0-SNAPSHOT.jar server config.yml
 
# To access the destination API
    http://localhost:8096/destinations
    
# For API documentation
    http://localhost:8096/swagger
    


TODO :  create integration test target to run Integration tests
        refactor integration tests
        

    

