# clone repos

FROM alpine/git as clone 
WORKDIR /app
ARG GIT_REPO = https://github.com/Youssef-rsy/cucumberImplmemenatationPlusJacocoPlusFlyway.git
RUN git clone ${GIT_REPO}

# build project 

FROM maven:3.5-jdk-8-alpine as build 
WORKDIR /app
COPY --from=gitImg /app/cucumberImplmemenatationPlusJacocoPlusFlyway /app 
RUN mvn install

# run app

FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 9999
ARG JAR_FILE=target/accountService.jar
COPY --from=build /app/${JAR_FILE} /app
CMD ["java -jar accountService.jar"]
