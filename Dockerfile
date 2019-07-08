# Start with a base image containing Java runtime java8 
FROM openjdk:8

RUN apt-get update && apt-get -y install  maven

# Add Maintainer Info
LABEL maintainer="youssef.rsy@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9999 available to the world outside this container
EXPOSE 9999

# The application's jar file
ARG JAR_FILE=target/accountService.jar

# Add the application's jar to the container
ADD ${JAR_FILE} accountService.jar

# Run the jar file 
ENTRYPOINT ["java" , "-jar" , "/accountService.jar"]
