FROM openjdk:8-jdk-alpine
COPY client.properties /home/properties/
COPY target/client-0.0.1-jar-with-dependencies.jar /home/client-0.0.1-jar-with-dependencies.jar
CMD ["java","-jar","/home/client-0.0.1-jar-with-dependencies.jar"]
EXPOSE 8888
