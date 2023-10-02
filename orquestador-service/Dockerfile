FROM openjdk:17
ADD target/orquestador-service-0.0.1-SNAPSHOT.jar orquestador-service.jar
EXPOSE 6060
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/orquestador-service.jar"]