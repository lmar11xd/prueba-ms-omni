FROM openjdk:17
ADD target/eureka-service-0.0.1-SNAPSHOT.jar eureka-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-service.jar"]