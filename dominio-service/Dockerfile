FROM openjdk:17
ADD target/dominio-service-0.0.1-SNAPSHOT.jar dominio-service.jar
EXPOSE 6060
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dominio-service.jar"]