# Kotlin Racing Car Game

## Features

- [✅] Accept user input for car names (comma-separated)
- [✅] Validate each car name:
    - [✅] Not empty
    - [✅] Max 5 characters
- [✅] Accept user input for number of rounds
- [✅] Each round:
    - [✅] Generate random number (0–9) for each car
    - [✅] Move car forward if number >= 4
    - [✅] Show progress for each car
- [✅] Determine the winner(s)
- [✅] Show winners (comma-separated if multiple)
- [✅] Throw `IllegalArgumentException` on invalid input
- [✅] Use `camp.nextstep.edu.missionutils.Console` for input
- [✅] Use `camp.nextstep.edu.missionutils.Randoms` for randomness
- [ ] All logic tested with JUnit 5 and AssertJ

## Structure

- `Application.kt` – main function entry point
- `Car.kt`         – Car class and related logic
- `Game.kt`        – Game class and race control logic