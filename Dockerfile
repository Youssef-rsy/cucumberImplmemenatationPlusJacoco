# build project 

FROM maven:3.5-jdk-8-alpine as build 
WORKDIR /app
RUN mvn -X install
EXPOSE 9999
ARG JAR_FILE=target/accountService.jar
COPY  /${JAR_FILE} /app
CMD ["java", "-jar" , "/app/accountService.jar"]
