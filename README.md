# kotlin-racingcar-precourse 
## Application.kt
#### Entry point
- `main()`
  Entry point of the program.
    - Prompts the user for car names and round count.
    - Parses and validates inputs.
    - Runs the race and displays results.
## Car.kt
### Class: `Car`
Represents a car participating in the race.

**Properties:**
- `name: String` — the name of the car
- `position: Int` — the current position on the track (default is `0`)

**Methods:**
- `move()` — increases the car’s position by 1  
  Called during a race round if the random number is greater than or equal to 4.
## RaceResult.kt
### Class: `RaceResult`
Represents the result of a single car after the race.

**Properties:**
- `carName: String` — the name of the car
- `position: Int` — the final position of the car after the race
## Input.kt
### Object: `Input`
Handles input parsing and validation.

**Methods:**
- `parseCarNames(names: String): List<String>`
  Parses and validates comma-separated car names. Throws `IllegalArgumentException` for invalid names.
- `parseNumberOfRounds(number: String): Int`
  Parses and validates the number of rounds. Throws `IllegalArgumentException` for invalid input.
## GameLogic.kt
### Class || Object: `GameLogic`
Handles the core race logic.

**Methods:**
- `logicRace(cars: List<Car>, rounds: Int): List<RaceResult>`
  Executes the race logic for the specified number of rounds.
- `moveCar(car: Car): Unit`
  Randomly decides if a car should move forward (random number ≥ 4).
- `searchWinners(cars: List<Car>): List<String>`
  Returns the list of car names that have the maximum position.
## Output.kt
### Object: `ResultPrinter`
Handles output formatting and printing.

**Methods:**
- `printResultsRound(results: List<RaceResult>)`
  Prints the progress of each car after each round.
- `printWinners(winners: List<String>)`
  Prints the final list of winners in the required format.
## ApplicationTest
### Additional tests
    A test helper functions to simulate race with predetermined random values.
