# Kotlin Racing Car – Precourse Mission

This repository contains the solution to the Hero Tech Course precourse mission.  
The project is implemented in Kotlin following the Model-View-Intent (MVI) architecture to ensure clarity, testability, and maintainability.

---

## Features

- Enter multiple car names (comma-separated)  
- Simulate car movement over multiple rounds  
- Determine winner(s) based on the farthest distance  
- Render game progress and result in the console  
- Validate input: car name length and number of rounds  

---

## Architecture – MVI Pattern

This project follows a clean MVI architecture, where:

- **Model**: Manages game state and logic  
- **View**: Renders output based on state  
- **Intent**: Captures user input as declarative actions  

```
racingcar
├── intent
│   └── UserIntent.kt
├── model
│   ├── Car.kt
│   ├── GameState.kt
│   └── RacingGame.kt
├── view
│   └── ViewRenderer.kt
└── Application.kt
```

---

## Tests

All tests are written using JUnit 5 and AssertJ, and leverage Woowahan's MissionUtils for input/output control.

```
test
├── racingcar
│   ├── model
│   │   └── CarTest.kt
│   └── ApplicationTest.kt
```

### Test Coverage

- Ensures car movement logic works with deterministic random inputs  
- Validates input constraints and error handling  

---

## How to Run

Run the app using IntelliJ IDEA by executing `Main.kt`.

To run tests:

```bash
./gradlew test
```

---

## Tech Stack

- Kotlin 1.9.x  
- Gradle (Kotlin DSL)  
- JUnit 5  
- AssertJ  
- MissionUtils (Woowahan)

---

## Note

This mission was completed as part of the Hero Tech Course Pre-course Week 1.  
The goal was to implement a complete, testable racing game in Kotlin using clean architecture patterns and modern testing practices.

---

##  Mission Checklist

### Functional
- [x] Allow multiple car name inputs  
- [x] Simulate car movement per round using random values  
- [x] Track and display each round result  
- [x] Determine and display winner(s)  

### Non-Functional
- [x] Follow MVI architecture pattern  
- [x] Validate car name input (length ≤ 5)  
- [x] Write unit tests with AssertJ and MissionUtils  
- [x] Keep logic pure and testable  

### Extras
- [x] Add clear folder structure and architecture diagram  
- [x] Document in README.md
