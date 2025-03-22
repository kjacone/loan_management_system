FROM eclipse-temurin:17-jdk as build
WORKDIR /workspace/app

COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY shared shared
COPY middleware-service middleware-service

RUN ./gradlew :middleware-service:bootJar -x test

FROM eclipse-temurin:17-jre
VOLUME /tmp
COPY --from=build /workspace/app/middleware-service/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]