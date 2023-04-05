# ATM-Service
# Online Game Challenge

This project is a simple eco friendly REST API service that calculates the optimal order for servicing ATMs based on their region and the request type.
This project provides an efficient algorithm to calculate the order and structure of players' entry into a special event in an online game.

## Prerequisites
## Problem Description

- Java JDK 17
- Maven 3.6.3
- Spring Boot 2.5.5
In a popular online game, special events are organized where players can earn the most points. Players are grouped into clans, and the strength of a clan is determined by the sum of its members' points. The order of entry to the special event is based on the sum of the clan members' points. Due to performance issues, players are allowed to enter in groups with a maximum size (m).

## Building and Running the Project
The algorithm determines the order and structure of players' entry into the special event based on the given number of places in a group (m), the number of players in a clan (l), and the total number of points (p). The algorithm optimizes the grouping of players to allow as many players as possible to enter the event during a single entry.

1. Clone the repository to your local machine.
2. Navigate to the project's root directory in the terminal.
3. Run [build.sh](build.sh) or use the following command to build the project:
## Implementation

The project is implemented in Java and consists of the following classes:

- `Main`: The main class that reads input data from a JSON file and calls the `CalculateService` to calculate the order.
- `CalculateService`: The core class that contains the algorithm to calculate the order and structure of players' entry into the event.
- `Players`: A data structure representing the input data, including the group count and a list of clans.
- `Group`: A data structure representing a group of clans.
- `Clan`: A data structure representing a clan with a number of players and points.

## Build and Run

To build and run the project, follow these steps:

1. Install Java 17, Maven 3.6.3, and Gradle 8.0.1.
2. Clone the repository and navigate to the project root directory.
3. Run the following command to build the project:

```bash
mvn clean install
```

4. After the build is successful, run this file: [run.sh](run.sh) or use the following command to start the application:
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
```
