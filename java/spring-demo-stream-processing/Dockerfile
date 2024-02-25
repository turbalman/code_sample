FROM amazoncorretto:17

COPY target/spring-demo-stream-processing-0.0.1-SNAPSHOT.jar spring-demo-stream-processing-0.0.1-SNAPSHOT.jar

EXPOSE 9011

ENTRYPOINT ["java","-Dsun.misc.URLClassPath.disableJarChecking=true", \
"--add-opens", "jdk.naming.rmi/com.sun.jndi.rmi.registry=ALL-UNNAMED", \
"--add-opens", "java.base/java.lang=ALL-UNNAMED", \
"--add-opens", "java.base/sun.security.action=ALL-UNNAMED", \
"--add-opens", "java.base/sun.net=ALL-UNNAMED", \
"--add-opens", "java.base/java.util=ALL-UNNAMED", \
"--add-opens", "java.base/java.util.concurrent.atomic=ALL-UNNAMED", \
"-jar", "/spring-demo-stream-processing-0.0.1-SNAPSHOT.jar"]
