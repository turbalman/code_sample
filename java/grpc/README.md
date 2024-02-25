# A Sample Spring Boot Microservices Project with gRPC
This is a sample microservices project developed with Spring Boot and gRPC, using Java version 16.

<img src="https://img.shields.io/badge/Language-Java-orange.svg">

## Submodules:
- City Score
    - It calculates a city score value.
    - Request parameter uses a custom "ValidCityCode" validation.

- Score Segment
    - It calculates a score segment value.
    - Request parameter uses a custom "ValidIdNumber" validation.

- Score Calculator
    - It calls CityScore and Score Segment services to calculate a final score.
    - H2 is used for database implementation.

## Usage
To test score service API call, you can perform a cURL request (or import it to Postman):
```
curl -L -X GET 'http://localhost:8200/calculate-score?idNumber=3654118644&name=senorita&surname=dev&phoneNumber=5007665432&cityCode=-35&incomeBracketMultiplierId=1'
```
To reach H2 database UI, please visit [http://localhost:8200/h2-console](http://localhost:8200/h2-console).

**JDBC URL**: jdbc:h2:mem:testdb

**User Name**: sa

**Pasword**: _no password required, leave empty
