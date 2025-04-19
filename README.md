# kotlin-racingcar-precourse

## Overview
A simple car racing game implemented in Kotlin 1.9.24 for the purpose of pre course mission for the Tech Course. The game simulates a race between cars, where each car moves forward based on a random number.

---

## Feature Checklist

### Input Handling
- [ ] Prompt user for comma-separated car names.
- [ ] Validate car names:
    - [ ] Names must not be empty.
    - [ ] Names must not exceed 5 characters.
    - [ ] No duplicate names allowed.
- [ ] Prompt user for number of rounds.
- [ ] Validate that the number of rounds is a positive integer.
- [ ] Throw `IllegalArgumentException` and terminate if input is invalid.

---

### Core Game Logic
- [ ] Initialize cars based on input names.
- [ ] For each round:
    - [ ] Generate a random number between 0 and 9 for each car using `Randoms.pickNumberInRange()`.
    - [ ] If the number is **4 or greater**, move the car forward.
    - [ ] Store and track each car's movement/progress.

---

### Output Handling
- [ ] Print the race result after each round in the format:
  ```commandline
    pobi : --
    woni : -
    jun : ---
  ```
- [ ] After all rounds, determine the winner(s):
- [ ] Print a single winner like: `Winners : pobi`
- [ ] Print multiple winners if tied like: `Winners : pobi, jun`

---

### Testing
- [ ] Write unit tests using **JUnit 5** and **AssertJ**.
- [ ] Test the following cases:
  - [ ] Valid input handling.
  - [ ] Invalid input (throws exceptions).
  - [ ] Movement logic based on random number.
  - [ ] Final winner calculation and tie conditions.

---

### Technical Requirements
- [ ] Entry point must be the `main()` function in `Application.kt`.
- [ ] Use `Randoms.pickNumberInRange()` from `camp.nextstep.edu.missionutils`.
- [ ] Use `Console.readLine()` from `camp.nextstep.edu.missionutils`.
- [ ] Follow Kotlin coding conventions.
- [ ] Do not exceed 2 levels of indentation.
- [ ] Break down large functions into small, single-responsibility functions.
- [ ] Do not use `System.exit()` or `exitProcess()`.

---

## Notes
- This README will be updated as features are implemented.
- All Git commits will follow the [AngularJS Commit Message Guidelines](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#commit).

