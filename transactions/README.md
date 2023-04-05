# Transactions
 
This is a solution to the Transactions Challenge.

## Requirements

- Java 17 or higher
- Maven 3.8.3 or higher
- OpenJDK 17 or higher

## Usage

1. Clone the repository and navigate to the project directory:
```bash
git clone https://github.com/Massacre448/Competition.git
cd transactions
```
2. Compile the project using Maven:
```bash
mvn clean package
```
3. Run the application using the provided shell scripts or use:
```bash
./run.sh example_request.json output.txt 
``` 
or

```bash 
./run.bat example_request.json output.txt
```
The first argument is the input file path, and the second argument is the output file path.

## Description

The application reads a list of transactions from a JSON file and processes them to generate a report of the account balances. The report includes the account number, debit count, credit count, and balance for each account, sorted by account number.

The application consists of four classes:

- `Transaction`: Represents a single transaction, with a debit account, credit account, and amount.
- `Account`: Represents an account, with a debit count, credit count, and balance.
- `TransactionUtils`: Contains a utility method for reading transactions from a JSON file.
- `TransactionProcessor`: Contains a method for processing a list of transactions and generating a map of accounts.

## Design

The application uses the following design principles:

- Separation of concerns: Each class has a single responsibility and does it well.
- Low coupling: Each class is independent and does not depend on other classes except through well-defined interfaces.
- High cohesion: Each class is highly cohesive, with all of its methods and properties related to its purpose.

The application uses the following libraries:

- Jackson: For reading JSON files.
- JUnit: For unit testing.
