# Crear una nueva imagen basada en OpenJDK 17
FROM openjdk:17-jre-slim-buster

# Exponer el puerto que utilizará la aplicación
EXPOSE 8087

# Copiar el archivo JAR construido desde la etapa anterior
COPY /app/target/apiportfolio-0.0.1-SNAPSHOT.jar /app/api-portfolio.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/api-portfolio.jar"]