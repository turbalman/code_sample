FROM amazoncorretto:17

COPY target/score-calculator-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9022

ENTRYPOINT ["java","-jar","app.jar"]