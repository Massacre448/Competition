# ATM-Service

This project is a simple eco friendly REST API service that calculates the optimal order for servicing ATMs based on their region and the request type.

## Prerequisites

- Java JDK 17
- Maven 3.6.3
- Spring Boot 2.5.5

## Building and Running the Project

1. Clone the repository to your local machine.
2. Navigate to the project's root directory in the terminal.
3. Run [build.sh](ATM-Service/build.sh) or use the following command to build the project:

```bash
mvn clean install
```

4. After the build is successful, run this file: [run.sh](ATM-Service/run.sh) or use the following command to start the application:
```bash
java -jar target/atm-service-0.0.1-SNAPSHOT.jar
```

## API Endpoints

### Calculate Order

- **POST** `http://localhost:8080/atms/calculateOrder`
- Request Body: A list of tasks with the following structure:

```json
[
  {
    "region": <int>,
    "requestType": <string>,
    "atmId": <int>
  },
  ...
]

Response: A list of ATMs in the optimal order for servicing:

[
  {
    "region": <int>,
    "atmId": <int>
  },
  ...
]
