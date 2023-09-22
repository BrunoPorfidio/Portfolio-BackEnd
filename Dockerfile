FROM amazoncorretto:17-alpine-jdk

maintainer brunoporfidio

ENV PORT 8080

EXPOSE 8080

COPY target/apiportfolio-0.0.1-SNAPSHOT.jar /api-portfolio.jar

CMD ["java", "-jar", "/api-portfolio.jar"]