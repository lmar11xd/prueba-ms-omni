FROM openjdk:17
ADD target/config-service-0.0.1-SNAPSHOT.jar config-service.jar
EXPOSE 6060
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-service.jar"]