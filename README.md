# Kotlin Racing Car Game

A console-based racing game developed in Kotlin.  
Cars move based on random values, and the winners are determined after a set number of rounds.  
Built under Woowacourse precourse constraints with full test coverage.

---

## ✅ Features

- [x] Accept user input for car names (comma-separated)
- [x] Validate each car name:
  - [x] Not empty
  - [x] Max 5 characters
- [x] Accept user input for number of rounds
- [x] Each round:
  - [x] Generate random number (0–9) for each car
  - [x] Move car forward if number ≥ 4
  - [x] Show progress for each car
- [x] Determine the winner(s)
- [x] Show winners (comma-separated if multiple)
- [x] Throw `IllegalArgumentException` on invalid input
- [x] Use `camp.nextstep.edu.missionutils.Console` for input
- [x] Use `camp.nextstep.edu.missionutils.Randoms` for randomness
- [x] All logic tested with JUnit 5 and AssertJ

---

## 🗂️ Project Structure

```
src/
├── main/
│   └── kotlin/
│       └── racingcar/
│           ├── Application.kt     // Entry point
│           ├── Car.kt             // Car class
│           └── Game.kt            // Game logic and flow
└── test/
  └── kotlin/
    └── racingcar/
      └── ApplicationTest.kt       // Provided tests using JUnit 5 and AssertJ
```

---

## 🚀 How to Run

```bash
./gradlew run
```

---

## 🧪 How to Test

```bash
./gradlew clean test
```

---

## 📋 Requirements

- Kotlin 1.9.24
- JUnit 5 and AssertJ for testing
- Only standard and provided libraries (`missionutils`)
- No modifications to `build.gradle.kts`
```