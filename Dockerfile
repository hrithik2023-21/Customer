FROM eclipse-temurin:17-jre-alpine
WORKDIR /customer
RUN echo "just checking the run command"
COPY target/Customer-0.0.1-SNAPSHOT.jar customer.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "customer.jar"]