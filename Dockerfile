FROM maven:latest AS build

COPY . /app
WORKDIR /app

RUN mvn clean package

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /app/target/demo-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
