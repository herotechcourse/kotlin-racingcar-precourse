# kotlin-racingcar-precourse

This project is a simple command-line racing car game implemented in **Kotlin**, created as part of the **Hero Tech Course Pre-Course Mission**.

---

## Features

### Game Setup
- [x] Prompt the user to input car names (comma-separated).
- [x] Prompt the user to input the number of racing rounds.
- [x] Validate car names:
    - Must not be empty.
    - Must not exceed 5 characters.
- [x] Validate round input:
    - Must be a positive integer.

### Game Mechanics
- [x] Each car can move forward or stay still in each round.
- [x] A car moves forward if a random number (0–9) is **4 or higher**.
- [x] Repeat movement logic for the number of rounds specified.

### Game Output
- [x] After each round, display each car’s name and current position using dashes (`-`).
  - Each `-` represents one successful move forward.
- [x] After all rounds are complete, display the winner(s).
    - [x] If there’s a tie, display all winners separated by commas.
- Example:
```
Input:
Car names: pobi,woni,jun
Number of rounds: 3

Output:
Round 1:
pobi : -
woni : 
jun  : -

Round 2:
pobi : --
woni : -
jun  : -

Round 3:
pobi : --
woni : --
jun  : --
```
In this example:
- `pobi` moved in rounds 1 and 2
- `woni` moved in rounds 2 and 3
- `jun` moved in rounds 1 and 3

All have 2 -, so the output is:
```
Winners : pobi, woni, jun
```

### Input Validation & Error Handling
- [x] Throw an `IllegalArgumentException` for any invalid input.
- [x] The program should terminate upon encountering invalid input.

### Testing
- [x] Unit tests using **JUnit 5** and **AssertJ**.
- [x] Test car movement logic.
- [x] Test input validation scenarios.
- [x] Test winner determination logic.

---

## Tech Stack & Constraints

- Kotlin `1.9.24`
- JUnit 5
- AssertJ
- `camp.nextstep.edu.missionutils` (Console, Randoms)
- No external libraries or dependencies are allowed.
- Must follow Kotlin Coding Conventions.
- Maximum indentation depth: **2 levels**

---

## Commit Guidelines

Follow the [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) for structured, meaningful commit messages.

Example:
```bash
git commit -m "feat: implement car movement based on random number"
```

## Project Status
- [x] Full feature set implemented and passing all tests.