FROM openjdk:8-alpine
ADD target/apiportfolio-0.0.1-SNAPSHOT.jar /usr/share/apiportfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/apiportfolio-0.0.1-SNAPSHOT.jar"]