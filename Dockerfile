FROM openjdk:11-jre

WORKDIR /usr/app

COPY ./target/*.jar app.jar

CMD ["java", "-Dserver.port=80", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
