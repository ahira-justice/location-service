# syntax = docker/dockerfile:1.2

FROM adoptopenjdk/openjdk11:latest as build

RUN --mount=type=secret,id=maven_repo_password,dst=/etc/secrets/maven_repo_password

RUN export MAVEN_REPO_PASSWORD="$(cat /etc/secrets/maven_repo_password)"

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY settings.xml .
COPY src src

RUN chmod +x /mvnw
RUN ./mvnw install -s settings.xml -DskipTests

FROM adoptopenjdk/openjdk11:latest

VOLUME /tmp

COPY --from=build target/*.jar app.jar

EXPOSE 80
EXPOSE 443

USER root
ENTRYPOINT ["java", "-jar", "/app.jar"]