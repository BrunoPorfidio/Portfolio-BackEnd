FROM eclipse-temurin:19-jdk

MAINTAINER brunoporfidio

COPY target/apiportfolio-0.0.1-SNAPSHOT.jar apiportfolio.jar

ENTRYPOINT ["java","-jar","/apiportfolio.jar"]

