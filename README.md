# Kotlin Racing Car Precourse 🏎️💨

A console‑based car racing game in Kotlin, designed with clean architecture and testability in mind.

## Functional Requirements
- Implement a console application for capturing user input.
- Add validation logic for car names and number of rounds (using `CarNameValidator`, `RoundValidator`).
- Implement car movement computation for a single race round via a pluggable `MovementStrategy`.
- Build core racing logic (`Race`) that loops rounds, moves cars, and determines winners.
- Add logic for printing race progress and final results via an Observer (`RaceObserver` + `ConsoleListener`).

## Non‑Functional Requirements
- Modular code organization (frontend, domain, strategy, observer, validation, config).
- Apply Strategy and Observer design patterns.
- Extract magic numbers into a central `Config` object.
- Write unit tests following TDD (using JUnit 5).
- Dockerize the application for consistent deployment.
- Maintain code quality with linting and Kotlin conventions.
- Provide clear documentation.

## Assumptions
- Input car names are unique (no duplicate‑elimination logic needed).
- Cars move based on a random number generator (0-9) and a threshold (4) for movement.
- At least one car should be given as an input in the console.
- Winner names are printed in the order they were entered.
- Car names are alphanumeric and at most 5 characters long.
- Rounds number must be a positive integer.
