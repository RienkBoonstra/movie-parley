FROM gradle:7-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17
EXPOSE 80:8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/movieparley-backend.jar
ENTRYPOINT ["java","-jar","/app/movieparley-backend.jar"]
