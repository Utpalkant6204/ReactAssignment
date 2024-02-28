FROM maven:latest AS build

COPY . /app
WORKDIR /app

RUN mvn clean package

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/ReactAssignment.jar ReactAssignment.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
