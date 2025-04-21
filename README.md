# kotlin-racingcar-precourse

## Table of Contents

- [Built With](#built-with)  
- [Conventions](#conventions)  
- [Features](#features)  
  - [User Input: Car Names](#user-input-car-names)  
    - [Comma‑Separated Naming](#comma‑separated-naming)  
    - [Blank Name Validation](#blank-name-validation)  
    - [Name Length Validation](#name-length-validation)  
    - [Name Immutability](#name-immutability)  
    - [Minimum Car Count](#minimum-car-count)  
    - [Duplicate Name Check](#duplicate-name-check)  
  - [User Input: Number of Rounds](#user-input-number-of-rounds)  
    - [Numeric Validation](#numeric-validation)  
    - [Minimum Rounds Validation](#minimum-rounds-validation)  
  - [Racing Logic](#racing-logic)  
  - [Distance Tracking](#distance-tracking)  
  - [Determining the Winner(s)](#determining-the-winners)  
  - [Console Output: Prompts](#console-output-prompts)  
  - [Console Output: Race Results](#console-output-race-results)  
  - [Console Output: Winners](#console-output-winners)  

- [Example Execution](#example-execution)  

- [Unit Tests](#unit-tests)  
  - [CarTest](#cartest)  
  - [CarsTest](#carstest)  
  - [RoundTest](#roundtest)  
  - [RandomMoveStrategyTest](#randommovestrategytest)  
  - [RacingGameTest](#racinggametest)  
  - [CarNameParserTest](#carnamenamereser)  
  - [RoundParserTest](#roundparsertest)  

- [Package Structure](#package-structure)  

- [application/](#application)  
  - [GameService](#gameservice)  

- [domain/](#domain)  
  - [generator/NumberGenerator](#generatornumbergenerator)  
  - [generator/RandomNumberGenerator](#generatorrandomnumbergenerator)  
  - [Car](#car)  
  - [Cars](#cars)  
  - [ErrorMessages (domain)](#errormessages-domain)  
  - [RacingGame](#racinggame)  
  - [RandomMoveStrategy](#randommovestrategy)  
  - [Round](#round)  

- [presentation/](#presentation)  
  - [parser/CarNameParser](#parsercarnamenamereser)  
  - [parser/RoundParser](#parserroundparser)  
  - [ErrorMessages (presentation)](#errormessages-presentation)  
  - [InputView](#inputview)  
  - [OutputView](#outputview) 
  
## Built With

- Kotlin 1.9.24  
- JUnit 5  
- AssertJ  
- camp.nextstep.edu.missionutils

## Conventions
- [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)

- [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)

## Features

### User Input: Car Names
- [x] Car names should be comma‑separated when entered by the user.
    - [x] Trim any leading or trailing whitespace around each name.
    - ex. `pobi,woni,jun`

- [x] If a name is missing or consists only of whitespace, throw
    - [x] If a name is missing or consists only of whitespace, throw `IllegalArgumentException` with message "Car name is missing."

- [x] Each car name cannot exceed 5 characters
    - [x]  If violated, throw `IllegalArgumentException` with message "Car name exceeds 5 characters."

- [x] Each car’s name must be immutable after creation.

- [x] At least 2 car names must be provided.
    - [x]  If fewer than 2 names are entered, throw IllegalArgumentException with message "Number of car names must be at least 2."

- [x] Duplicate car names are not allowed.
    - [x] Check for duplicates in a case‑insensitive manner.
    - [x] If duplicates are found, throw IllegalArgumentException with message "Duplicate car names found."


### User Input: Number of Rounds
- [x] The number of rounds must be numeric.
    - [x] If the input is not a valid integer, throw IllegalArgumentException with message "Number of rounds is not a number."

- [x] The number of rounds must be at least 1.
    - [x]  If the value is less than 1, throw IllegalArgumentException with message "Number of rounds must be greater than 0."

### Racing Logic
- [x] For each car and each round, generate a random integer between 0 and 9 (inclusive).
    - [x] If the number is 4 or greater, the car moves forward one unit; otherwise, it stays still.

### Distance Tracking
- [x] Compute and store each car’s cumulative distance traveled after each round.

### Determining the Winner(s)
- [x] The car(s) with the greatest total distance after all rounds are the winner(s).

- [x] If multiple cars share the top distance, they all win.

### Console Output: Prompts
- [x]  Print the prompt for car names exactly as:
    - `Enter the names of the cars (comma-separated):`

- [x]  Print the prompt for rounds exactly as:
    - `How many rounds will be played?`

### Console Output: Race Results
- [x] After reading the inputs, print a blank line, then:
    - `Race Results`

- [x] For each round, print each car’s name and its **cumulative distance** so far, using dashes `-` to represent distance:
    - `<car name> : <dashes equal to cumulative distance>`
    - [x] Include a single space before and after the colon.
    - [x] Insert a blank line between each round’s output block.

### Console Output: Winners
- [x] After all rounds, print:
    - `Winners : <name1>[, <name2>, …]`
    - [x] If multiple winners, separate their names with a comma and a space.
- [x] List winners in the order their names were originally entered.

<br>

## Example Execution
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

<br>

## Unit Tests
### CarTest
- Verifies that a valid name initializes Car.name and starts position at 0.
- Asserts that blank or whitespace‑only names throw IllegalArgumentException(CAR_NAME_MISSING).
- Checks that names longer than 5 characters throw IllegalArgumentException(CAR_NAME_TOO_LONG).

### CarsTest
- Confirms that two or more unique names produce a List<Car> in the original order.
- Ensures that providing fewer than two names throws IllegalArgumentException(CARS_MINIMUM_COUNT).
- Validates that case‑insensitive duplicate names throw IllegalArgumentException(CARS_NO_DUPLICATES).

### RoundTest
- Tests that Round( ≥1 ) constructs successfully.
- Verifies that Round( <1 ) throws IllegalArgumentException(ROUND_LESS_THAN_ONE).

### RandomMoveStrategyTest
- Uses a stubbed NumberGenerator to confirm getDistance() returns 1 when the stub yields 4.
- Confirms it returns 0 when the stub yields 3.

### RacingGameTest
- Injects an “always move” strategy to assert that every car advances each round and snapshots reflect cumulative positions.
- Simulates a tie to verify getWinners() returns all top‑position cars in input order.

### CarNameParserTest
- Confirms that a comma‑separated string is split and each name is trimmed of whitespace (e.g., " pobi , woni,jun" → ["pobi","woni","jun"]).
- Verifies that an empty input ("") yields a single empty string ([""]).

### RoundParserTest
- Asserts that a purely numeric string (e.g., "5") is parsed to the corresponding integer.
- Checks that a non‑numeric input (e.g., "abc") throws IllegalArgumentException with the ROUND_NOT_INTEGER message.

<br>

## Package Structure
```
racingcar/
├── Application.kt
├── application/
│   └── GameService.kt
├── domain/
│   ├── generator/
│   │   ├── NumberGenerator.kt
│   │   └── RandomNumberGenerator.kt
│   ├── Car.kt
│   ├── Cars.kt
│   ├── ErrorMessages.kt
│   ├── RacingGame.kt
│   ├── RandomMoveStrategy.kt
│   └── Round.kt
└── presentation/
    ├── parser/
    │   ├── CarNameParser.kt
    │   └── RoundParser.kt
    ├── ErrorMessages.kt
    ├── InputView.kt
    └── OutputView.kt
```

## application/
### GameService
- Nothing here is about business rules or formatting—just “read → build domain → execute → display.”

<br>

## domain/
### generator/NumberGenerator
- Defines a contract for producing an integer in a given range.

- Allows you to swap in test‑doubles (stubs) or alternative RNGs.


### generator/RandomNumberGenerator
- Wraps the missionutils.Randoms call behind your own interface.

- Decouples the rest of your domain (e.g. RandomMoveStrategy) from a concrete random API.

### Car
- Name validation in the constructor protects against blank or overly long names

- name is a val, so it’s immutable once set

- position is private and only mutated via move(d), exposing its value through getPosition()

- All error messages are centralized in ErrorMessages for consistency and testability.

### Cars
- Cars is a first‑class collection that encapsulates a list of Car instances while enforcing domain rules:

- Size validation: Ensures at least two names are provided, throwing IllegalArgumentException(CARS_MINIMUM_COUNT) otherwise.

- Duplicate check: Performs case‑insensitive duplicate detection, throwing IllegalArgumentException(CARS_NO_DUPLICATES) if any are found.

- Construction: Once validated, maps each name to a Car object in the original input order, exposing them via the cars: List<Car> property.

### ErrorMessages (domain)
- Car errors

    - CAR_NAME_MISSING: thrown when a car’s name is blank

    - CAR_NAME_TOO_LONG: thrown when a car’s name exceeds 5 characters

- Cars collection errors

    - CARS_MINIMUM_COUNT: thrown when fewer than two car names are supplied

    - CARS_NO_DUPLICATES: thrown when duplicate names (case‑insensitive) are detected

- Round errors

    - ROUND_LESS_THAN_ONE: thrown when the number of rounds is less than one

### RacingGame
- Constructor inputs: a validated Cars collection, a Round count, and a MoveStrategy for determining per‑turn movement.

- play(): runs the race for the specified number of rounds, invoking moveStrategy.getDistance() for each car each round, updating its position, and collecting a snapshot of (name, cumulativePosition) after each round.

- getWinners(): computes the maximum distance reached and returns the names of all cars matching that distance, preserving the original input order.

### RandomMoveStrategy
- Dependencies: takes a NumberGenerator (defaulting to RandomNumberGenerator).

- Logic: calls generator.nextInt(0, 9) and returns 1 if the result is greater than 3, otherwise 0.

- Purpose: encapsulates the “4 or greater → move” rule in a testable, replaceable strategy.

### Round
- Constructor: accepts an integer round.

- Validation: in the init block, it throws IllegalArgumentException(ROUND_LESS_THAN_ONE) if the value is less than 1.

- Purpose: ensures any Round instance always represents at least one play round, centralizing this business rule in one place.

<br>

## presentation/
### parser/CarNameParser
- CarNameParser is a simple utility that converts a raw input string into a clean list of car names:

- Input: a single comma‑separated string (e.g., "pobi, woni ,jun").

- Operation: splits on commas and trims leading/trailing whitespace from each segment.

- Output: a List<String> of sanitized names (["pobi", "woni", "jun"]).

### parser/RoundParser
- RoundParser handles converting a raw string into a valid round count:

- Method: parse(rawInput: String): Int

- Behavior: attempts toIntOrNull() on the input; if parsing fails, throws IllegalArgumentException(ROUND_NOT_INTEGER).

- Role: centralizes “numeric rounds” validation in the presentation layer, ensuring only valid integers are passed on.

### ErrorMessages (presentation)
- ErrorMessages in the presentation layer centralizes UI‑specific error text:

- ROUND_NOT_INTEGER: the message used when the user’s input for the number of rounds isn’t a valid integer.

### InputView
- InputView lives in the presentation layer and handles all console I/O for user inputs:

- readCarNames()

    - Prints the prompt "Enter the names of the cars (comma-separated):"

    - Reads a line from Console.readLine()

    - Delegates parsing to CarNameParser.parse() to obtain a List<String> of trimmed names

- readRounds()

    - Prints the prompt "How many rounds will be played?"

    - Reads a line from Console.readLine()

    - Delegates numeric validation to RoundParser.parse() to return a valid Int

### OutputView
- OutputView handles all console output formatting in the presentation layer:

- printPlay(roundPositions)

    - Prints a blank line and the header "Race Results".

    - Iterates each round’s snapshot, printing each car’s name and a series of - characters equal to its cumulative position.

    - Adds a blank line after each round block.

- printWinners(winners)

    - Prints the prefix "Winners : "

    - Joins the winner names with ", " and prints them on the same line.
