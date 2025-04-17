# kotlin-racingcar-precourse
A simple Kotlin implementation of a car racing game with name validation.

## Features
### 1. Handling Input
* **Car Name Parsing**: Parses and trims comma-separated car names.

* **Validation**:

  * Car names must be at most 5 characters long.

  * Empty or blank names are ignored.

  * Throws `IllegalArgumentException` if user inputs invalid data as per the requirements.
  * Add input and checks for number of rounds for the race.

### 2. Create a car class
* A class representing a car in a race with features:

  * Track the car's position, starting from 0

  * Should attempt to move, depending on the boolean input


## Tests
### Input Handler Tests
Test cases to ensure proper name parsing and validation.
They can be run individually with the command:

 `./gradlew test --tests "racingcar.InputHandlerTest"
`


