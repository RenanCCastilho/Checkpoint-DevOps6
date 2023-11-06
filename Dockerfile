FROM openjdk:17
EXPOSE 9090
ADD target/motor-app-docker.jar motor-app-docker.jar
ENTRYPOINT ["java","-jar","/motor-app-docker.jar"]