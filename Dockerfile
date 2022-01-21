FROM openjdk:18-alpine
COPY /target/group_spider-*.jar app.jar
EXPOSE 443
CMD ["java", "-jar", "app.jar"]