# prueba-ms-omni

## Docker
Ejecutar los siguientes comandos en la ruat principal de cada microservicio:

### config-service 
1. Abrir Terminal en /prueba-ms-omni/config-service
2. docker build -t omni-config-service .

### eureka-service
1. Abrir Terminal en /prueba-ms-omni/eureka-service
2. docker build -t omni-eureka-service .

y los siguientes de igual manera

docker build -t omni-gateway-service .
docker build -t omni-orquestador-service .
docker build -t omni-dominio-service .

### Finalmente Ejecutar docker-compose
1. Abrir terminal en /prueba-ms-omni
2. docker-compose up -d