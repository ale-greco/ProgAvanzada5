# Etapa 1: Imagen base con OpenJDK 17
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar el JAR generado previamente por Maven
COPY target/crud-personas-1.0.0.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
