# Kotlin Car Racing

A simple console-based car racing game implemented in Kotlin.

## Features

### Car Class

- Implement a Car class to represent each racing car
- Track the position of each car during the race
- Method to move the car

### RaceGame Class

- Represents the core game state and rules
- Stores the collection of cars
- Contains methods to move cars based on random numbers
- Provides methods to query car positions and determine winners

### Input Validation

- Ensure that all inputs are valid before proceeding
- Throw IllegalArgumentException for invalid user inputs

#### CarNameParser

- Accept comma-separated car names from the user
- Validate that each car name does not exceed 5 characters
- Car names must be unique

#### RoundsParser

- Round must be an integer
- Round must be greater than 0 and less than 15

### Race Controller

- Accept the number of racing rounds and car names from the user
- Configure the race based on user inputs

### Race Result Display

- Show the progress of each car after each round
- Display the final positions of all cars
- Identify and announce the winner(s) of the race
- Handle multiple winners if they reach the same final position

### Testing with JUnit and AssertJ

- Implement unit tests for Car and RaceGame class
- Implement unit tests for CarNameParser and RoundsParser
- Implement unit tests for RaceController
