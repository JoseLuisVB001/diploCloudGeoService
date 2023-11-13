# FROM openjdk:17-jdk-alpine
FROM openjdk:17-oracle
MAINTAINER Alfonso Rivero <alfonsorivero@midas-mx.com>
# a default value
ENV MONGO_HOSTNAME mongodb+srv://joseluisvb:lSI0CBjAyE0AGFjQ@cluster0.ta49jnz.mongodb.net/unam
ENV MONGO_DB unam
ENV MONGO_USER joseluisvb
ENV MONGO_PWD lSI0CBjAyE0AGFjQ
ENV TOMCAT_PORT 8080

EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
