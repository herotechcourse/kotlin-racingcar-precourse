# kotlin-racingcar-precourse
## 🚗 Racing Car Game

### ✅ Feature Requirements

- [ ] **Receive car names and number of rounds from the user**
    - [ ] Prompt the user to input car names separated by commas (`,`).
    - [ ] Prompt the user to input the number of racing rounds.
    - [ ] If the input is invalid, throw an `IllegalArgumentException`.

- [ ] **Handle car movement logic**
    - [ ] For each round, generate a random number between 0 and 9 for each car.
    - [ ] If the number is 4 or higher, the car moves forward by one space.
    - [ ] If the number is less than 4, the car does not move.

- [ ] **Display race status for each round**
    - [ ] After each round, print the current status of all cars.
    - [ ] Each car’s movement should be displayed using `-` symbols (e.g., `claire's car : ---`).

- [ ] **Determine and print the winner(s)**
    - [ ] After all rounds, determine which car(s) moved the farthest.
    - [ ] If there are multiple winners, print all their names separated by commas.

- [ ] **Validate user input**
    - [ ] Throw an exception if any car name is empty or contains only whitespace.
    - [ ] Throw an exception if a car name exceeds the allowed length.
    - [ ] Throw an exception if the number of rounds is not a valid positive integer.

---

### 🛠 Tech Stack
- Kotlin 1.9.24
- JUnit 5
- AssertJ

---

### 🚫 Restrictions
- Only Kotlin is allowed (no Java).
- Do not modify `build.gradle.kts`.
- Do not use any external libraries other than those provided.
- Do not use `System.exit()` or `exitProcess()` to terminate the program.
- Maximum indentation depth: 2 levels.
- Entry point must be `main()` in the `Application` class.