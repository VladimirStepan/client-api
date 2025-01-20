FROM openjdk:17-jdk-slim-buster
WORKDIR /app-client
COPY target/client-api.jar /app-client/client-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "client-api.jar"]