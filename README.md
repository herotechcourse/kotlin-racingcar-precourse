# kotlin-racingcar-precourse

## Features

1. **Handling User Input**
   - Display prompts for car names and number of rounds.
   - Parse and Validate user input:
     - Comma-separated car names.
     - Car name requirements (non-empty, max 5 chars).
     - Round count input is a positive integer.
2. **Game Logic**
   - Car movement is determined randomly.
   - Monitoring of car positions during the race.
   - Race progression on a round by round basis.
3. **Race Visualization**
   - Display race progress after each round.
   - Display car positions using dashes.
   - Display car names with their positions.
4. **Result Calculation**
   - Determination of race winner(s).
   - Multiple winners support in case of ties.
   - Formatted display of winner(s) at race conclusion.
5. **Error Handling**
   - Validation of all user inputs with appropriate `IllegalArgumentException`.
   - Descriptive error messages for invalid inputs.
   - Clean program termination on error conditions.
6. **Test Coverage**
   - Unit tested using `JUnit 5` and `AssertJ`.

### Architecture: Domain-Centric Desing

#### Overview

This project implements a domain-centric architectural approach.
The design prioritizes the domain model as the central element, with the other components build around it.

#### Structure

- **Domain Layer:** Contains the core business logic (Car, Race)
- **Controller Layer:** Orchestrates the flow between domain and view layers (GameController)
- **View Layer:** Handles the user input and output (InputView, OutputView)
- **Utils:** Contains validation and helpers functions (Validator)

#### Why Domain-Centric Design?

The design maintains a **bussiness logic isolation**, making it easier to test, modify and/or scale.
It's allows for example, changes to the UI without affect the core game logic.
Each component has a well-defined responsibility. Domain objects don't depend on other layers, reducing coupling.

The design is based **MVC** pattern, both have separation of concerns into different components, a controller that manages flow between components and the UI is separated from the business logic.

The differences are that Domain-Centric focuses on the business logic (Domain), while MVC gives equal importance to all three components.
The domain doesn't depend on any other layer, improving the modularity of the design. The controller orchestrate the flow between domain and view, while MVC, the controller might allow more direct model-view interaction
The testing is also typically easier with Domain-Centric for the isolation of the components.

## Technical Details

- **Language:** Kotlin 1.9.24
- **Build System:** Gradle
- **Testing Framework:** JUnit 5 + AssertJ

### Programming Requirements

This project has the following technical constraints:

- Implemented purely in Kotlin 1.9.24 (no Java)
- Entry points is the `main()` function in the `Application` class
- No modification of build.gradle.kts
- No external libraries beyond those provided
- Follows Kotlin Coding Conventions
- Maximum indentation depth of 2 levels
- Small, focused functions that do one thing
- Comprehensive test coverage using JUnit 5 and AssertJ
- Uses provided `Random` and `Console` APIs from the camp.nextstep.edu.missionutils package

## Functional Requirements

### How to Play

1. Enter car names as a comma-separated list (e.g. "pobi,woni.jun").
   - Names must be non-empty and maximum 5 characters each.
2. Enter the number of rounds to play.
3. Watch as the race progresses round by round.
4. See the final winner(s) at the end of the race.

### Example Execution

```
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

Race Results
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Winners : pobi, jun
```

### Rules

- In each round a car has a chance to either move forward or stay in place.
- A car moves forward if a randomly generated number (0-9) is 4 or greater.
- The race continues for the specified number of rounds.
- Winner(s) are the car(s) that moved the furthest by the end of the race.
