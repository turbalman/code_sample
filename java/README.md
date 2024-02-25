# Demo
Demo is a SprintBoot demo demonstrating the data stream produced from native business orders and associated SKUs, through Kafka streaming platform, consumed by Flink clients for online-processing statistics, using the following well-known web services:
Kafka for streaming platform, 
Flink for online processing, 
Redis for cache, Mysql for RDB, 
Prometheus with Grafana for metrics collection and visualization, 
OpenTelemetry and Jasper for trace, 
Metabase for BI and so on.
![overview.png](images%2Foverview.png)

Please replace '192.168.2.30' without quotes with you own host IP for testing.

## Prerequisite
### Protobuf
Suggest installation through
https://grpc.io/docs/protoc-installation/
and an advised Version is 3.23.2 which is compatible with this demo.

### Docker and docker compose
Suggest installation through
https://docs.docker.com/compose/install/

### Java 17
Suggest installation through
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

#### Maven 3.9.6
Suggest installation through
https://maven.apache.org/install.html

## How to run?
### Generate java codes from protobuf
```
protoc --proto_path=./protobuf --java_out=./spring-demo-data-pipeline/src/main/java **/*.proto
protoc --proto_path=./protobuf --java_out=./spring-demo-stream-processing/src/main/java **/*.proto
```
### Code quality check(Java)
Including Checkstyle for code style check, PMD with Spotbugs for static code analyzer, CPD for duplicated code check, and OpenClove for code coverage. 

Run the following command for verification with various combinations on demand.
```
mvn clean verify -Dmaven.test.skip=true -Dmaven.clover.skip=true
mvn clean verify -Dspotbugs.skip=true -Dfindbugs.skip=true -Dpmd.skip=true -Dcpd.skip=true -Dcheckstyle.skip
```
Run test by
```
mvn clean test
```

### Run docker compose
#### Start services including Redis, Kafka, Mysql, Metabase, Jaeger and OpenTelemetry so on.
```
sudo touch /etc/otel-collector-config.yml
sudo chmod 0755 /etc/otel-collector-config.yml
docker-compose up
```
#### Start services including Prometheus and Grafana.
```
cd docker/prometheus-grafana
docker-compose up
```

### Build & Run spring-demo-data-pipeline
* Run by
```
cd spring-demo-data-pipeline && mvn clean package && java -jar ./target/spring-demo-data-pipeline-0.0.1-SNAPSHOT.jar
```  
* Doc hosted at
  * http://192.168.2.30:9010/swagger-ui/index.html
* Monitoring endpoint hosted at 
  * http://192.168.2.30:9010/actuator/prometheus

### Build & Run spring-demo-stream-processing
Run by
```
cd spring-demo-stream-processing && mvn clean package && java  -Dsun.misc.URLClassPath.disableJarChecking=true  --add-opens jdk.naming.rmi/com.sun.jndi.rmi.registry=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED  --add-opens java.base/sun.security.action=ALL-UNNAMED --add-opens java.base/sun.net=ALL-UNNAMED  --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.util.concurrent.atomic=ALL-UNNAMED -jar ./target/spring-demo-stream-processing-0.0.1-SNAPSHOT.jar
```
* Doc hosted at
  * http://192.168.2.30:9011/swagger-ui/index.html
* Monitoring endpoint hosted at
  * http://192.168.2.30:9011/actuator/prometheus

## Monitoring
### Metrics collected by Prometheus hosted at
* http://192.168.2.30:9090 
  * Given a registered metric such as jvm_memory_used_bytes, it would be visualized as follows.

![prometheus.png](images%2Fprometheus.png)

### Metrics visualized by Grafana hosted at
* http://192.168.2.30:3001
  * GF_SECURITY_ADMIN_USER=admin
  * GF_SECURITY_ADMIN_PASSWORD=foobar
* Then you need to connect the Prometheus source mentioned above
* In the end monitor a given service after creation of a grafana panel such as the following ones

* ![metric_monitoring.png](images%2Fmetric_monitoring.png)

### Trace visualized by Jaeger hosted at
* http://192.168.2.30:16686/search
  * Given a registered metric such as jvm_memory_used_bytes, it could be visualized as follows.

![jaeger.png](images%2Fjaeger.png)

### Business info visualized by Metabase hosted at
* http://192.168.2.30:3000 An account should be created and then login before exploring the data.
  * Given a data table such as OrderSkuSummary, it could be visualized as follows.

![metabase.png](images%2Fmetabase.png)