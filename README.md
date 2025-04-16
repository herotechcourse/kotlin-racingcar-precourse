# kotlin-racingcar-precourse

## Features

### Car

- Each car has a **name** and a **position** (number of moves).
- Car names can be up to **5 characters**. If a name exceeds this limit, an `IllegalArgumentException` is thrown.
- In each round, cars determine whether to move forward using a random number between **0 and 9**.
    - If the random number is **4 or higher**, the car moves one step forward.
- The current position is visualized using dashes (`-`).  
  Example: `pobi : ---`

---
    
### RacingGame

- The game runs for the specified number of rounds, and in each round, all cars move.
- Once all rounds are completed, the **winner(s)** are determined and displayed.
    - If multiple cars have the same final position, they are considered **joint winners**, and their names are displayed separated by commas.  
      Example: `Winners : pobi, jun`

---

### Input

- The user is prompted to enter a **comma-separated list of car names**.
- The user is prompted to enter the **number of rounds**.
- If any input is invalid, the program throws an `IllegalArgumentException` and terminates.

- Car Names: A comma-separated list of car names (each name up to 5 characters).
  - Example input: "pobi, jun, alice"
- Rounds: A positive integer representing the number of rounds to play.
  - Example input: 5

---

### Output
For each round, display the movement result of each car in the following format:
```
pobi : ---
jun  : ----
alice: ---
```

