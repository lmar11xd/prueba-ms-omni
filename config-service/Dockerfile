FROM openjdk:17
ADD target/config-service-0.0.1-SNAPSHOT.jar config-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-service.jar"]