# kotlin-racingcar-precourse

# Racing Car Game

A simple text-based racing car game written in Kotlin. Built as part of the Nextstep pre-course mission.

---

## Features

- Input car names (comma-separated) and number of rounds
- Car names validated to be 1–5 characters
- Each car randomly moves forward if the generated number (0–9) is 4 or more
- Race progress displayed after each round
- Declare one or more winners based on final positions
- Handles invalid inputs with appropriate exceptions

---

## Feature List (Implemented)

- [x] Input parsing for car names and rounds
- [x] Name validation (non-empty, max 5 characters)
- [x] Random movement logic using `Randoms.pickNumberInRange(0, 9)`
- [x] Car movement and position tracking
- [x] Display race progress per round
- [x] Determine and display winners (including ties)
- [x] Error handling with `IllegalArgumentException`
- [x] Modular functions for single-responsibility
- [x] Unit tests with JUnit 5 and AssertJ
- [x] Integration test using `camp.nextstep.edu.missionutils.test` utils

---

## Tech Stack

- Kotlin 1.9.24
- Visual Studio
- JUnit 5
- AssertJ
- MissionUtils (Randoms, Console)

---

## How to Run

````bash
# On macOS/Linux
./gradlew clean run


---

## Final Checklist

- [x] Program runs using Kotlin 1.9.24
- [x] No indentation deeper than 2 levels
- [x] All tests pass (`./gradlew clean test`)
- [x] Followed AngularJS Git commit message conventions
- [x] Used only approved libraries

---

## Testing

Run tests with:

```bash
./gradlew clean test
````

Includes:

- Unit tests (car logic, game logic, validation)
- Integration test with mocked input and randomness

---

## Submission

1. Commit with clear messages based on feature list
2. Push to GitHub
3. Finalize submission on the Application Platform

---

## Reflections (optional)

Feel free to write about:

**What I learned:**
I learned how to break down complex logic into smaller, focused functions that follow the single-responsibility principle. I also gained experience using Kotlin's standard features and writing effective unit and integration tests.

**What was tricky:**
Handling random behavior in tests required understanding how to mock values using the provided testing tools. Also, ensuring the correct output formatting to pass all tests was more detailed than expected.

**Where I spent the most time:**
Most of my time went into validating input rules and refactoring to maintain two-level indentation. Writing and refining the test cases to cover both happy paths and edge cases also took significant effort.

---
