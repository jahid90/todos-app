FROM openjdk:14-alpine

WORKDIR /usr/app

COPY ./target/*.jar app.jar

CMD ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]