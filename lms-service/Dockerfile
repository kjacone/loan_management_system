FROM eclipse-temurin:17-jdk as build
WORKDIR /workspace/app

COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY shared shared
COPY lms-service lms-service

RUN ./gradlew :lms-service:bootJar -x test

FROM eclipse-temurin:17-jre
VOLUME /tmp
COPY --from=build /workspace/app/lms-service/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]