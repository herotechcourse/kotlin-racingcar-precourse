# kotlin-racingcar-precourse


This is a car racing game made using Kotlin.
Users enter car names and race rounds, and the game announces the winner(s) at the end.
---

## Features to be Implemented

1. **User Input for Car Names**
    - Car names should be entered as a comma-separated string.
    - Each car name must not exceed 5 characters.
    - Empty or invalid names will trigger an exception.

2. **User Input for Number of Rounds**
    - The user will specify how many rounds the race should run.
    - Only positive integers are accepted.

3. **Car Movement Logic**
    - For each round, each car will randomly move forward or stay still.
    - If a randomly generated number (0–9) is **4 or higher**, the car moves forward by 1.

4. **Game Progress Output**
    - Each round will print the current progress of all cars.
    - Car progress is displayed using dashes (`-`) corresponding to the number of moves.

5. **Determine Winner(s)**
    - The car(s) with the farthest progress after all rounds will be declared as winners.
    - If there's a tie, multiple winners will be listed.

6. **Validation and Error Handling**
    - Invalid input (e.g., name > 5 chars, non-numeric rounds) throws `IllegalArgumentException`.
    - The game terminates immediately if invalid input is detected.

7. **Testing Compatibility**
    - The program is compatible with tests using the `camp.nextstep.edu.missionutils.test` package.
    - Deterministic behavior supported via `Randoms.pickNumberInRange()`.

---

## Technologies

- Kotlin 1.9.24
- Gradle
- JUnit 5
- IntelliJ IDEA
- MissionUtils (`camp.nextstep.edu.missionutils`)

---

## Getting Started

1. Clone the repo
2. Open in IntelliJ IDEA
3. Set Kotlin version to **1.9.24**
4. Run `Application.kt` or the test suite

---



