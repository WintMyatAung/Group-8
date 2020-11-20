FROM openjdk:latest
COPY ./target/Group-8.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Group-8.jar", "db:3306"]