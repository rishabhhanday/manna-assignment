# Assignment 

Spring boot web application that exposed APIs to find the best venue per city.

### Overview of technology and best practices used.

- Deployed the application on OpenShift( kubernetes platform ) to scale the application/PODs on demand and for load balancing.
- Test code coverage including unit test and integration test.
- Auto generated swagger documentation from code.
- Cloud native application
- docker-compose and docker file for quickly running and testing the application.
- Finds the best venue in O(n) time.

## How to run

- Using gradle

```sh
./gradlew bootRun
```

- Using docker-compose

```sh
docker-compose up
```

- Using docker

```sh
docker run -p 8080:8080 rishabhhanday/manna-assignment
```

- Using application already deployed on OpenShift
  base url - http://sojern-assignment-rishhabhhanday-dev.apps.sandbox-m3.1530.p1.openshiftapps.com/swagger-ui/

NOTE - If the application give 404 error it is because I am using OpenShift developer sandbox. PODs deployed in sandbox
account are reduced to 0 every 24 hours.

### Swagger endpoint
- For localhost : http://localhost:8080/swagger-ui/
- For application deployed on OpenShift : http://manna-assignment-rishhabhhanday-dev.apps.sandbox-m2.ll9k.p1.openshiftapps.com/swagger-ui/#/venue-controller/venueUsingPOST

### technology used

- Spring boot
- docker and docker-compose
- OpenShift/ kubernetes


### testing framework

How to run :
```sh 
./gradlew test
```

- Junit
- SpringBootTest


