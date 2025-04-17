# kotlin-racingcar-precourse

A Simple Car Racing Game Application built with Kotlin.

---

## 🔧 Features

- ✅ User Validation of car names (maximum of 5 characters)
- ✅ Input Handling for car names (comma-separated)
- ✅ User Validation for number of rounds (must be positive)
- ✅ Car and Race models for race simulation
- ✅ Random movement logic per each round (0–9)
- ✅ Game engine to simulate rounds and update positions
- ✅ Store Output race progress per round
- ✅ Determine winners based on distance covered
- ✅ Display winners (comma-separated if multiple)
- 🚧 Error handling with `IllegalArgumentException` for invalid input
- 🚧 Unit tests using **JUnit 5** + **AssertJ**

---

## 🔄 Progress Log

| Feature                                                          | Status  | Branch                         |
|------------------------------------------------------------------|---------|--------------------------------|
| User Validation of car names                                     | ✅ Done  | `feature/car-name-validation`  |
| Input Handling for car names                                     | ✅ Done  | `feature/car-name-input`       |
| User Validation for number of rounds                             | ✅ Done  | `feature/rounds-validation`    |
| Car and Race models for race simulation                          | ✅ Done  | `feature/car-object`           |
| Random movement logic per each round                             | ✅ Done  | `feature/random-movement`      |
| Game engine to simulate rounds and update positions              | ✅ Done  | `feature/game-engine`          |
| Store Output race progress per round                             | ✅ Done  | `feature/output-round-results` |
| Determine winners based on distance covered                      | ✅ Done  | `feature/determine-winners`    |
| Display winners                                                  | ✅ Done  | `feature/display-winners`      |
| Error handling with `IllegalArgumentException` for invalid input | ✅ Done  | `Integrated with each feature` |
| Unit tests using **JUnit 5** + **AssertJ**                       | ✅ Done  | `Integrated with each feature` |

---

## 🚀 Getting Started

### Prerequisites

- Kotlin 1.9.24
- Gradle
- JUnit 5
- AssertJ

### Run the App

```bash
./gradlew run
```