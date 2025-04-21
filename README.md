# kotlin-racingcar-precourse
A simple, console-based racing car game implemented in Kotlin 1.9.24.
The project features user-driven input, round-based random movement,
precise winner calculation, robust validation, and clear output—all following clean code principles.

---

## ❛ Overview
This program asks the user for car names and the number of rounds,
simulates a race using random movement rules, displays the progress and results in the required format,
and provides strict input validation with informative error handling.

---

## ❛ Features

### Domain
- [ ] Car
  - Create cars with validated names (1–5 characters, non-blank, unique)
  - Track and update car positions through movement logic
  - Move cars forward if the current movement strategy allows

- [ ] Race
  - Manage a list of Cars objects and the number of rounds
  - Advance the game round by round, applying the movement strategy to each car
  - Record the position of each car after every round
  - Determine winner(s) (all cars at the farthest position) after the last round
  - Support multiple winners in the case of a tie

- [ ] Movement
  - Use a random movement strategy that picks a number (0~9) and moves the car if the value is 4 or higher

---

### Input / Output
- [ ] Input
  - Read and parse user input for car names (comma-separated, trimmed)
  - Read and validate the number of rounds (positive integer)

- [ ] Output
  - Print the "Race Results" header
  - Print each car's progress after each round (name and hyphens)
  - Print winners' names, comma-separated, matching the required format

---

### Validation
- [ ] Car names are checked for the following:
  - Non-empty and not just whitespace
  - Length between 1 and 5 characters
  - No duplicate names allowed

- [ ] Round count is checked for the following:
  - A valid integer
  - Greater than zero
  
----

### Error Handling
- [ ] Throw IllegalArgumentException and terminate the program for any invalid input
- [ ] Provide exception messages that are clear and match the requirements

---

### Testing
- [ ] Unit tests using JUnit 5 and AssertJ for fluent assertions
- [ ] Tests cover:
  - Input validation for car names and round count
  - Correct movement according to the movement strategy
  - Accurate race progression and position updates across rounds
  - Correct determination of winner(s)
  
---

### Program Structure
- [ ] Place the main entry point in Application.kt
- [ ] Handle all input only with Console.readLine()
- [ ] Generate all randomness using Randoms.pickNumberInRange(0,9)
- [ ] Avoid using System.exit() or exitProcess()
- [ ] Do not modify build.gradle.kts or project structure
- [ ] Use only Kotlin (no Java or external dependencies)
- [ ] Keep indentation to a maximum of 2 levels
- [ ] Commit each feature atomically with meaningful messages

---
