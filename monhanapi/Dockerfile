FROM amazoncorretto:17-alpine3.17-jdk
LABEL authors="eliezxrts"
WORKDIR /app
COPY ./target/monhanapi-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]