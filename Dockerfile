# build project 

FROM maven:3.5-jdk-8-alpine as build 
WORKDIR /app
COPY / /app
RUN mvn -X install
ARG JAR_FILE=target/accountService.jar
COPY /app/${JAR_FILE} /app
EXPOSE 9999
ENTRYPOINT ["java" , "-jar" , "/app/accountService.jar"]
