FROM openjdk:17
ADD target/gateway-service-0.0.1-SNAPSHOT.jar gateway-service.jar
EXPOSE 6060
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-service.jar"]