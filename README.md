# kotlin-racingcar-precourse


This is a console-based **Car Racing Game** written in Kotlin. Users input car names and a number of rounds. Each car advances based on random chance, and at the end of the game, the winner(s) are announced.

---

## 📌 Features

- Accepts multiple car names (comma-separated)
- Car names are validated (non-empty, max 5 characters)
- Customizable number of race rounds
- Movement determined by random numbers (0–9)
- Displays each car’s progress per round
- Supports multiple winners in case of a tie
- Gracefully handles invalid input with `IllegalArgumentException`

---

## 🧾 Rules

1. **Input**:
    - Car names: comma-separated, each ≤ 5 characters
    - Number of rounds: positive integer

2. **Race Logic**:
    - For each round, every car randomly generates a number from 0 to 9 using:

      ```kotlin
      Randoms.pickNumberInRange(0, 9)
      ```

    - If the number is **4 or higher**, the car moves forward by 1 unit.
    - Progress is visualized using `-` characters.
    - The race continues for the specified number of rounds.

3. **Result**:
    - Car(s) with the **furthest distance** are declared winner(s).
    - Multiple winners are shown if they share the max distance.

---

## ✅  Tests
1. **Car Class**:
   - Creates car with valid name
   - Throws exception when car name is too long
   - Car moves when random number is greater than or equal to 4
   - Car does not move when random number is less than 4`
   - GetProgress returns correct progress string

1. **Race Class**:
   - Car that moves most should be the winner
   - Both cars win when same number of moves
   - Capture and assert console output (for )