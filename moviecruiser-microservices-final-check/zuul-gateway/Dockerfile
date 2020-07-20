FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8765
ADD target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]