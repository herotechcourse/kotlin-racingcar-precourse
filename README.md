# kotlin-racingcar-precourse

## 🚗 Racing Car Game - Planned Features

### ✅ User Input
- Accept comma-separated car names from the user.
- Accept number of racing rounds from the user.
- Validate that each car name is non-empty and no longer than 5 characters.
- Validate that the number of rounds is a positive integer.

### ✅ Error Handling
- Throw `IllegalArgumentException` for invalid input.
- Terminate the game cleanly without using `exitProcess()`.

### ✅ Game Logic
- Each car has a position starting from 0.
- In each round, every car randomly decides whether to move:
    - Move forward if a random number (0-9) is **4 or greater**.
- Repeat the race for the specified number of rounds.

### ✅ Output
- After each round, print the current position of each car using dashes (`-`) to show progress.
    - Example: `pobi : ---`
- After the final round, print the name(s) of the winner(s).
    - If multiple cars have the highest position, print all separated by commas.

### ✅ Constraints
- Follow Kotlin coding conventions.
- Indentation limited to 2 levels deep.
- Each function should do only one thing (single responsibility).
- No external libraries outside of `camp.nextstep.edu.missionutils`.

### ✅ Testing
- Use **JUnit 5** and **AssertJ** to test:
    - Input validation
    - Movement logic
    - Race result and winner determination