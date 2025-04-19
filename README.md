# kotlin-racingcar-precourse

A simple racing game written in Kotlin, using an object-oriented approach.

---

## 💡 Feature Plan (OOP-based)

### 1. Input handling
- Parse and validate user input for car names and number of rounds.
- Ensure car names are not empty and up to 5 characters.
- Ensure round count is a positive integer.
- Includes unit & integration tests.

### 2. Car model
- Define a `Car` class with name and position.
- Implement movement logic based on random number generation.
- Includes unit tests.

### 3. Race logic
- Implement the `Race` class that handles multiple rounds.
- Determine winners based on final position.
- Includes unit tests with random input control.

### 4. Formatter
- Implement a formatter service to output:
    - Car progress (e.g. `pobi : ---`)
    - Final winners (e.g. `Winners : pobi, jun`)
- Includes unit tests.

### 5. Application flow
- Combine all components in `main()`:
    - Read input
    - Run race  
    - Display final result
- Includes full integration tests.

---

## 🧪 Test Coverage

- Unit tests for all components
- Integration tests simulating user input/output
- Controlled randomness using `assertRandomNumberInRangeTest`

---

## 🛠 Tech Stack

- Kotlin 1.9.24
- Gradle (preconfigured)
- [camp.nextstep.edu.missionutils](https://github.com/woowacourse-projects/mission-utils)
- JUnit 5, AssertJ

---

## How to Run

```bash
./gradlew clean test
