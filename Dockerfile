FROM eclipse-temurin:17-jdk-jammy

MAINTAINER brunoporfidio

COPY target/apiportfolio-0.0.1-SNAPSHOT.jar api-portfolio.jar

ENV PORT 8080

EXPOSE 8080

entrypoint ["java","-jar","api-portfolio.jar"]