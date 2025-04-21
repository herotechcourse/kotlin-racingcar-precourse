# kotlin-racingcar-precourse
# 🚗 Racing Car Game

A simple command-line racing game implemented in Kotlin. Cars race across multiple rounds, moving forward based on random chance. The game tracks and displays progress, then announces the winner(s).

## 📋 Features

### 🎮 Game Mechanics

- **Car Name Input**
  - Accepts comma-separated car names from the user.
  - Each name:
    - Must be non-empty.
    - Must not exceed 5 characters.
    - Must be unique.
  - Throws `IllegalArgumentException` on invalid input.

- **Number of Rounds**
  - Accepts a positive integer input.
  - Throws `IllegalArgumentException` for invalid or non-positive inputs.

- **Car Movement**
  - Each round, each car may move forward based on a random number (0–9).
  - If the number is **4 or greater**, the car moves forward by 1 position.
  - Random numbers are generated via:
    ```kotlin
    Randoms.pickNumberInRange(0, 9)
    ```

- **Progress Display**
  - Each round prints car progress using hyphens:
    ```
    pobi : --
    woni : -
    jun  : ---
    ```

- **Winner Display**
  - After the final round, the car(s) with the furthest distance win.
  - Multiple winners are comma-separated:
    ```
    Winners : pobi, jun
    ```

---

## ⚙️ Technical Details

- **Language**: Kotlin 1.9.24
- **Entry Point**: `main()` function inside the `Application` class.
- **Libraries**: Only standard Kotlin and:
  - `camp.nextstep.edu.missionutils.Randoms`
  - `camp.nextstep.edu.missionutils.Console`

- **Coding Rules**:
  - Max 2 levels of indentation.
  - No `System.exit()` or `exitProcess()`.
  - Follow Kotlin Coding Conventions.

---

## 🧪 Testing

- Frameworks:
  - JUnit 5
  - AssertJ

- Test Coverage:
  - Car movement logic
  - Input validation
  - Race results output
  - Winner calculation

