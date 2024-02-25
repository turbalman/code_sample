FROM amazoncorretto:17

COPY target/score-segment-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9021

ENTRYPOINT ["java","-jar","app.jar"]