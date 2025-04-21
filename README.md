# Kotlin Car Racing Game
This project is a simple command-line car racing simulator built in Kotlin as part of the Hero Tech Course pre-course weekly mission. It allows users to input car names and the number of rounds they will race for.

During each round, each car will generate a random number between 0 and 9:
- If the number is between 4 to 9, the car moves forward by one lap (graphically represented by a dash `-`).
- If the number is between 0 to 3, the car does not move during that round.

The progress of each car is displayed after each round, showing how many laps they have completed.
The car that has the longest string of dashes at the end of all rounds is declared the winner.
A race can have multiple winners if more than one car has the same number of dashes.

<br>
<br>

# Table of Contents

- [Required features](#required-features)
- [Technical Requirements](#technical-requirements)
- [Project Structure](#project-structure)
- [Testing](#testing)

> **Note:**
> This README will be continuously updated as the project evolves and expands until submission.
> Documentation and test descriptions may be revised to reflect improvements and implementation details added during development.

<br>
<br>

# Required features

### 1. Input: handle car name input and validation.
Prompts the user to enter car names, which must be:
- Comma-separated.
- Non-empty.
- No longer than 5 characters.
In case this is founnd, an `IllegalArgumentException` is thrown and program is terminated.

Prompted input example:
```
Enter the names of the cars:
pobi,woni,jun
```

### 2. Input: handle and validate number of rounds.
Prompts the user to enter the number of rounds, which must be:
- A valid number
In case this is found, an `IllegalArgumentException` is thrown and program is terminated.


Prompted input example:
```
How many rounds will be played?
2
```

### 3. Simulation: track car movements per round.
- For every round, each car will generate a random number between **0 and 9**:
	- If the number is **4 or greater**, the car moves forward by one lap (represented by a dash `-`).
	- If the number is less than 4, the car stays in place for that round.
- Movement is cumulative per car.

### 4. Output: print car progress.
- Tracks and prints the cars progress after each round:
```
Race Results:

pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

```


### 5. Output: print the winner.
- Once all rounds are terminated, the winner is printed based on which car moved the farthest.
```
Winners : pobi
```
- If multiple cars are tied with the same number of dashes, all of them are declared winners, separated by commas.
```
Winners : pobi, jun
```
[Move Back to Table of Contents](#table-of-contents)

<br>
<br>

# Technical Requirements

- Kotlin version: **1.9.24**
- Testing: **JUnit 5** and **AssertJ**

[Move Back to Table of Contents](#table-of-contents)

<br>
<br>

# Project Structure
The project separates the code into distinct packages with a specific responsability to ensure maintainability and testability. The structure is as follows:

## ▶ `player/`
**Manages player-specific logic.**
- **`Car.kt`**
  Defines the behavior and state of each car.
  Handles:
  - Randomized movement attempts
  - Position tracking
  - Visual progress of position (as `-` dashes)



## ▶ `race/`
**Controls the racing simulation and output.**

#### **`Simulation.kt`**: executes the race logic.
  - Runs each round
  - Triggers car movement
  - Determines winners

#### **`SimulationOutput.kt`**: handles how race data is displayed.
  - Prints racing header
  - Displays car progress for each round
  - Handles message formatting
  - Displays final winner(s) and my personal choice of printing a “no winner” message if no cars moved during the whoole race

## ▶ `setup/`
**Handles input return, parsing, validation, and utility functions.**

#### **`PromptNames.kt`**: parses and validates user input for car names.
- As required throws error when input is:
	- Not comma-separated.
	- Not empty.
	- Longer than 5 characters.

- Additionally it also throws an error if:
	- Only one player is entered (it would not be a real race with only one player)
	- the number of players surpasses a system safe limit ( 10 was added as a reference to prevent performance issues)
	- No duplicates (parsing converts input to lowercase in parsing process to better handle this)
	- Only lowercase letters/numbers to avoid invalid  and shell sensitive characters
	- A player name is empty is split by space

#### **`PromptRounds.kt`**: parses and validates the number of race rounds.
- As required it throws error when input is:
  - Is not a number
- Additionally it also throws an error if:
  - the number of rounds surpasses a system safe limit (10 was added as a reference to prevent performance issues)
  - the number of rounds is 0 or less
  - multiple numbers are entered

#### **`Utils.kt`**: contains utility functions.
- `throwErrorIf()`: used throughout to throw custom validation errors cleanly

---

### ▶ `Application.kt`
**The entry point of the program.**

- Displays prompts for car names and number of rounds.
- Collects car nemae and number of rounds with `PromptNames` and `PromptRounds`
- Instantiates `Car` object to the list of players
- Runs the race via `Simulation`

[Move Back to Table of Contents](#table-of-contents)

<br>
<br>


# Testing

This project includes unit tests written using JUnit 5 and AssertJ to ensure reliability and correctness.
Current coverage includes:

- **`CarBehaviour.kt`**
  Tests car movement behavior and progress tracking

- **`SimulationTest.kt`**
  Tests race mechanics, round execution, and winning logic

- **`PromptNamesTest.kt`**
  Tests name input parsing and all validation rules

- **`PromptRoundsTest.kt`**
  Tests round input parsing and validation

### Run the following command to verify that all tests pass:

For macOS/Linux:
```
./gradlew clean test
```

For Windows:
```
gradlew.bat clean test or .\gradlew.bat clean test
```
[Move Back to Table of Contents](#table-of-contents)