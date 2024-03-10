FROM openjdk:17-alpine
COPY ./target/k8sonedemoone-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]