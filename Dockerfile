FROM amazoncorretto:19

MAINTAINER brunoporfidio

COPY target/apiportfolio-0.0.1-SNAPSHOT.jar apiportfolio-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/apiportfolio-0.0.1-SNAPSHOT.jar"]