# kotlin-racingcar-precourse 
## Application.kt
- `main()`
  Entry point of the program
- `runRace()`
  - Prompts the user for car names and the number of rounds.
  - Validates the inputs by calling helper functions `getCarNames()` and `getNumberOfRounds()`.
  - Initializes the list of cars and then runs the race logic by calling `GameLogic.logicRace()`.
  - Finally, it displays the results for each round and the winners by calling `Output.printResultsRound()` and `Output.printWinners()`.
- `getCarNames()`
  - Prompts the user to enter a comma-separated list of car names.
  - Uses `Input.parseCarNames()` to parse and validate the input, ensuring that only valid car names are accepted.

- `getNumberOfRounds()`
  - Prompts the user for the number of rounds to be played.
  - Uses `Input.parseNumberOfRounds()` to parse and validate the input, ensuring that the number of rounds is a valid integer.
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
### Object: `GameLogic`
Handles the core race logic.

**Methods:**
- `logicRace(cars: List<Car>, rounds: Int): List<List<RaceResult>>`
  Executes the race logic for the specified number of rounds.
- `fun playOneRound(cars: List<Car>): List<RaceResult>`
   Handles one round of the race. Moves each car if the condition is met and records the round results. Used internally by `logicRace`.
- `moveCar(car: Car): Unit`
  Randomly decides if a car should move forward (random number ≥ 4).
- `searchWinners(cars: List<Car>): List<String>`
  Returns the list of car names that have the maximum position.
## Output.kt
### Object: `Output`
Handles output formatting and printing.

**Methods:**
- `printResultsRound(results: List<List<RaceResult>>)`
  Prints the progress of each car after each round.
- `printWinners(winners: List<String>)`
  Prints the final list of winners in the required format.
## ApplicationTest
### Additional tests
    A test helper functions to simulate race with predetermined random values.

## Custom Validations and Race Constraints

In this project, I have implemented several custom validations and constraints for the car racing game. These are designed  improve clarity, and prevent potential errors or confusion. Below are the key limitations I introduced:

1. **Car Name Validation**:
  - **Only Letters Allowed**: Car names can only contain alphabetic characters (i.e., `isLetter`). This ensures that the names are meaningful and readable, and prevents special characters or numbers that might interfere with the race logic or cause confusion.

2. **Unique Car Names**:
  - **No Duplicate Names**: Duplicate car names are not allowed. If the same name is entered more than once, an `IllegalArgumentException` will be thrown. This prevents confusion about which car is which and ensures that each participant is uniquely identifiable throughout the race.

3. **Maximum Number of Rounds**:
  - **Max Limit for Rounds**: To avoid excessive computations and maintain performance, I decided to introduce a limit on the number of rounds. The maximum value for rounds is set to the maximum `Int` value in Kotlin. This ensures that no excessively large number of rounds can be entered, which could potentially cause performance issues or make the game too lengthy.

4. **Maximum Number of Cars**:
  - **Limiting the Number of Cars**: Although I initially considered restricting the number of cars in the race, I couldn't finalize a hard limit. The program might be tested with various numbers of cars, and while it's possible to set a limit, I need further insights into the testing conditions to make an informed decision.

5. **One Car Race**:
  - **Single-Car Race Consideration**: I thought about implementing a restriction that prevents a race from having just one car, but I ultimately left this out. It is theoretically possible to race with a single car, though the race outcome would be obvious. However, I believe the game should allow for such cases if desired.

