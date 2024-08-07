FROM openjdk:17-jdk-slim
WORKDIR /app
COPY  target/demoexercise-0.0.1-SNAPSHOT.jar dockerExercise.jar
RUN ls -l /app
ENTRYPOINT ["java", "-jar", "dockerExercise.jar"]