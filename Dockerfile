FROM amazoncorretto:17.0.11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} customer_service.jar

ENTRYPOINT ["java", "-jar", "/customer_service.jar"]

EXPOSE 9501