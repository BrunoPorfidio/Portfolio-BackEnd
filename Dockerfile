FROM amazoncorretto:19

MAINTAINER brunoporfidio

COPY target/apiportfolio-0.0.1-SNAPSHOT.jar apiportfolio.jar

ENTRYPOINT ["java","-jar","/apiportfolio.jar"]

