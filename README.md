# kotlin-racingcar-precourse

## Overview
A simple car racing game implemented in Kotlin 1.9.24 for the purpose of pre course mission for the Tech Course. The game simulates a race between cars, where each car moves forward based on a random number.

---

## Feature Checklist

### Input Handling
- [x] Prompt user for comma-separated car names.
- [x] Validate car names:
  - [x] Names must not be empty.
  - [x] Names must not exceed 5 characters.
- [x] Prompt user for number of rounds.
- [x] Validate that the number of rounds is a positive integer.
- [x] Throw `IllegalArgumentException` and terminate if input is invalid.

---

### Core Game Logic
- [x] Initialize cars based on input names.
- [x] For each round:
    - [x] Generate a random number between 0 and 9 for each car using `Randoms.pickNumberInRange()`.
    - [x] If the number is **4 or greater**, move the car forward.
    - [x] Store and track each car's movement/progress.

---

### Output Handling
- [x] Print the race result after each round in the format:
  ```commandline
    pobi : --
    woni : -
    jun : ---
  ```
- [x] After all rounds, determine the winner(s):
- [x] Print a single winner like: `Winners : pobi`
- [x] Print multiple winners if tied like: `Winners : pobi, jun`

---

### Testing
- [x] Write unit tests using **JUnit 5** and **AssertJ**.
- [x] Test the following cases:
  - [x] Valid input handling.
  - [x] Invalid input (throws exceptions).
  - [x] Movement logic based on random number.

---

### Technical Requirements
- [x] Entry point must be the `main()` function in `Application.kt`.
- [x] Use `Randoms.pickNumberInRange()` from `camp.nextstep.edu.missionutils`.
- [x] Use `Console.readLine()` from `camp.nextstep.edu.missionutils`.
- [x] Follow Kotlin coding conventions.
- [x] Do not exceed 2 levels of indentation.
- [x] Break down large functions into small, single-responsibility functions.
- [x] Do not use `System.exit()` or `exitProcess()`.

---

## Notes
- This README will be updated as features are implemented.
- All Git commits will follow the [AngularJS Commit Message Guidelines](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#commit).

