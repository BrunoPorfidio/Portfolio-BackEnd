FROM eclipse-temurin:17-jre-alpine

MAINTAINER brunoporfidio

ENV PORT 8080

EXPOSE 8080

copy target/apiportfolio-0.0.1-SNAPSHOT.jar api-portfolio.jar

entrypoint ["java","-jar","/api-portfolio.jar"]

CMD ["/bin/sh"]