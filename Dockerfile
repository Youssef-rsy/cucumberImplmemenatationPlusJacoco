# build project 

FROM maven:3.5-jdk-8-alpine as build 
#WORKDIR /app
RUN mvn -X install
ARG JAR_FILE=target/accountService.jar
ADD ${JAR_FILE} accountService.jar
EXPOSE 9999
ENTRYPOINT ["java" , "-jar" , "/accountService.jar"]
