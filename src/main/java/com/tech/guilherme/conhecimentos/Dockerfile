FROM openjdk:21
WORKDIR app
COPY target/conhecimentos 0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80800
ENTRYPOINT ["java", "-jar", "app.jar"]