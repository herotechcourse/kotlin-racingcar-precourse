# kotlin-racing car-precourse

A simple Kotlin implementation of a car racing game with name validation. The project is implemented a focus on separation of concerns, testability, and readable structure.

## Features

### 1. Handling Input

* **Car Name Parsing**: Parses and trims comma-separated car names.

* **Validation**:

    * Car names must be at most 5 characters long.

    * Empty or blank names are ignored.

    * Throws `IllegalArgumentException` if user inputs invalid data as per the requirements.
    * Add input and checks for number of rounds for the race.
    * Add Input Handler tests to ensure the validation and parsing is correct

Test cases to ensure proper name parsing and validation.

### 2. Create a car class

* A class representing a car in a race with features:

    * Track the car's position, starting from 0

    * Should attempt to move, depending on the boolean input

### 3. Implement the RacingGame class

* read a class to handle:
    * Reading input
    * Initializing cars
    * implementing change of position based on the requirements
    * Getting the winner
    * Printing the winner through the Output Handler(To be implemented)

### 4. Restructure the RacingGame class to handle concerns separately

* Implement the OutputHandler class to handle the output, maintaining the code functionality
    * prints race start
    * Prints race results
    * prints race winners

### 5. Tests the OutputHandler

* Add testcases for the various cases
    * Printing race start
    * Printing race results in the correct format
    * Printing single winner in the correct format
    * Printing multiple winners in the correct format

### 6. Add tests to the Racing game class

* Ensure the racing game class calls the relevant functions and prints the results correctly

## Project Structure

```
racingcar
├── Application.kt
├── Car.kt
├── InputHandler.kt
├── OutputHandler.kt
├── RacingGame.kt

test
└── racingcar
├── ApplicationTest.kt
├── CarTest.kt
├── InputHandlerTest.kt
├── OutputHandlerTest.kt
└── RacingGameTest.kt
```

## Tech Stack

* Kotlin 1.9.x

* Gradle (Kotlin DSL)

* JUnit 5

* AssertJ

* Woowahan MissionUtils

## Learning Objectives

* Practice clean Kotlin development with proper architecture and validation

* Learn how to break down responsibilities using small, focused classes

* Apply unit testing to verify correctness






