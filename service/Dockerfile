FROM adoptopenjdk:16-jdk as builder

WORKDIR /assets

COPY . ./
RUN ./gradlew bootJar

FROM adoptopenjdk:16-jre as production

WORKDIR /home/todo/app

COPY --from=builder /assets/build/libs/*.jar app.jar

CMD ["java", "-Dserver.port=80", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
