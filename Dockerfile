FROM eclipse-temurin:17-jdk-jammy

MAINTAINER brunoporfidio

COPY target/apiportfolio-0.0.1-SNAPSHOT.jar /app/api-portfolio.jar

ENV PORT 8080

EXPOSE 8080

entrypoint ["java","-jar","/app/api-portfolio.jar"]

CMD ["/bin/sh"]