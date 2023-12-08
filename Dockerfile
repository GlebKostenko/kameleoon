FROM openjdk:8-jdk-alpine
COPY target/kameleoon-1.0.jar kameleoon-rest.jar
ENTRYPOINT ["java","-jar","/kameleoon-rest.jar"]