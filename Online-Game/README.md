# Online Game Challenge

This project provides an efficient algorithm to calculate the order and structure of players' entry into a special event in an online game.

## Problem Description

In a popular online game, special events are organized where players can earn the most points. Players are grouped into clans, and the strength of a clan is determined by the sum of its members' points. The order of entry to the special event is based on the sum of the clan members' points. Due to performance issues, players are allowed to enter in groups with a maximum size (m).

The algorithm determines the order and structure of players' entry into the special event based on the given number of places in a group (m), the number of players in a clan (l), and the total number of points (p). The algorithm optimizes the grouping of players to allow as many players as possible to enter the event during a single entry.

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
3. Run the following file Run [build.sh](build.sh) or use the following command to build the project:
```bash 
mvn clean install
```



4. Run the following file [run.sh](run.sh) or run the following command to execute the project:
```bash 
java -jar target/onlinegame-1.0-SNAPSHOT.jar
```

The algorithm will read the input data from the `example_request.json` file and calculate the order of players' entry into the special event. The results will be displayed in the console.
