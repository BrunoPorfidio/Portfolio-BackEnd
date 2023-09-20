# Crear una nueva imagen basada en OpenJDK 17
FROM eclipse-temurin:17-jdk-jammy

# Exponer el puerto que utilizará la aplicación
EXPOSE 8087

# Copiar el archivo JAR construido desde la etapa anterior
COPY target/apiportfolio-0.0.1-SNAPSHOT.jar /app/api-portfolio.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "api-portfolio.jar"]