# build project 

FROM maven:3.5-jdk-8-alpine as build 
WORKDIR /app
COPY / /app 
RUN mvn install

# run app

FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 9999
ARG JAR_FILE=target/accountService.jar
COPY --from=build /app/${JAR_FILE} /app
CMD ["java -jar accountService.jar"]
