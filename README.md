# Kotlin Racing Car Precourse 🏎️💨


## Overview
The **Kotlin Racing Car Precourse** is a console application that simulates a car racing game, demonstrating object‑oriented design with Strategy and Observer patterns, strict input validation, and testing.

## 📄 Table of Contents
- [Overview](#overview)
- [Key Features and Highlights](#key-features-and-highlights)
- [Technologies Used](#technologies-used)
- [Architecture Overview](#architecture-overview)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Game Description](#game-description)
- [Design Patterns and SOLID Principles](#design-patterns-and-solid-principles)
- [Exceptions](#exceptions)
- [Project Structure](#project-structure)
- [Contact Information](#contact-information)

## Key Features and Highlights
- **Modular Design:** Clear separation of frontend, domain, strategy, observer, and validation layers.
- **Validation:** Robust checks for car names and race rounds.
- **Randomized Car Movement:** Configurable movement thresholds with pluggable strategies.
- **Real-time Updates:** Observer pattern for race progress and results.
- **Testing:** Extensive unit and integration tests using JUnit.
- **Docker Support:** Containerization for consistent environments.
- **Code Quality:** Linting and adherence to Kotlin coding conventions.

## Technologies Used
- **Language:** Kotlin 1.9+
- **Build Tool:** Gradle 7.2+
- **Testing:** JUnit 5
- **Containerization:** Docker

## Architecture Overview
- **Frontend:** Reads user input and displays output.
- **Domain:** Core race logic in `Race.kt`.
- **Strategy:** Defines `MovementStrategy` for car motion.
- **Observer:** `RaceObserver` notifies listeners of race events.
- **Validation:** Ensures correct input via validators.

## Running the Application
### Prerequisites
- JDK 1.8+ / Kotlin 1.9+
- Gradle 7.2+
- Docker (optional)

### Steps
1. **Clone repository**
    ```bash
    git clone https://github.com/yourusername/kotlin-racingcar-precourse.git
    cd kotlin-racingcar-precourse
    ```
2. **Build & Run**
    ```bash
    ./gradlew build
    ./gradlew run
    ```
3. **Docker (optional)**
    ```bash
    docker build -t racing-car .
    docker run racing-car
    ```

## Testing
Run unit tests with:
```bash
./gradlew test
```

## Game Description
Players input comma‑separated car names and the number of rounds:
```
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5
```
**Example Execution:**
```
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

## Design Patterns and SOLID Principles
**Design Patterns**
- **Strategy:** Pluggable `MovementStrategy`.
- **Singleton:** Configuration and core services as singletons.
- **Observer:** `RaceObserver` dispatches race events.

**SOLID Principles**
- **SRP:** Each class has one responsibility.
- **OCP:** Extend behaviors without modifying existing code.
- **LSP:** Subtypes replace base types safely.
- **ISP:** Interfaces are minimal and focused.
- **DIP:** High‑level modules depend on abstractions.

## Exceptions
The application throws `IllegalArgumentException` for:
- Blank or empty car names.
- Non-alphanumeric or over‑length names.
- Duplicate car names.
- Non-positive or non-numeric rounds.

## Project Structure
```
src/
├── main/kotlin/racingcar/
│   ├── Application.kt
│   ├── config/Config.kt
│   ├── domain/Race.kt
│   ├── frontend/Frontend.kt
│   ├── model/Car.kt
│   ├── observer/
│   │   ├── ConsoleListener.kt
│   │   ├── RaceListener.kt
│   │   └── RaceObserver.kt
│   ├── strategy/
│   │   ├── MovementStrategy.kt
│   │   └── RandomMovementStrategy.kt
│   └── validation/
│       ├── CarNameValidator.kt
│       ├── RoundValidator.kt
│       └── Validator.kt
└── test/kotlin/racingcar/
    ├── ApplicationTest.kt
    ├── observer/RaceObserverTest.kt
    ├── strategy/RandomMovementStrategyTest.kt
    ├── validation/CarNameValidatorTest.kt
    ├── model/CarTest.kt
    ├── domain/RaceTest.kt
    └── frontend/FrontendTest.kt
```

## Contact Information
- **Author:** Alaa Ismail
- **Email:** alaaismail286@gmail.com
- **GitHub:** https://github.com/3laaHisham
