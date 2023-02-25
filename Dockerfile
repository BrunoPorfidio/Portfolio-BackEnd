FROM openjdk:17jdk-alpine

MAINTAINER brunoporfidio

copy target/apiportfolio-0.0.1-SNAPSHOT.jar api-portfolio.jar

entrypoint ["java","-jar","/api-portfolio.jar"]

CMD ["/bin/sh"]