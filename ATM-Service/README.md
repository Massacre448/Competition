# ATM Service Order

This project is a simple REST API service that calculates the optimal order for servicing ATMs based on their region and the request type.

## Prerequisites

- Java JDK 17
- Maven 3.6.3
- Spring Boot 2.5.5

## Building and Running the Project

1. Clone the repository to your local machine.
2. Navigate to the project's root directory in the terminal.
3. Run the following command to build the project:

mvn clean install


4. After the build is successful, run the following command to start the application:

java -jar target/atm-service-0.0.1-SNAPSHOT.jar


## API Endpoints

### Calculate Order

- **POST** `/atms/calculateOrder`
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
