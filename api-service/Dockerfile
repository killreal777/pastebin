FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/api-service-0.0.1-SNAPSHOT.jar /app/api-service.jar
ENTRYPOINT ["java", "-jar", "api-service.jar"]
EXPOSE 8080