FROM openjdk:17
ADD target/producer-app.jar producer-app.jar
ENTRYPOINT ["java", "-jar", "/producer-app.jar"]