FROM eclipse-temurin:17-jdk-jammy

MAINTAINER brunoporfidio

ENV PORT 8087

EXPOSE 8087

copy target/apiportfolio-0.0.1-SNAPSHOT.jar api-portfolio.jar

entrypoint ["java","-jar","/api-portfolio.jar"]

CMD ["/bin/sh"]