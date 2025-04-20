# 🚗 Kotlin Racing Car Precourse

This is a simple car racing game developed as part of the precourse mission.  
The goal is to practice real-world development skills, including clean coding, testing, and Git/GitHub usage.

---

## 📋 Feature List

### Setup and Input
- Prompt the user to enter car names (comma-separated, e.g., `pobi,woni,jun`).
- Validate car names:
   - No name can be empty.
   - Each name must be **5 characters or fewer**.
- Prompt the user to enter the number of racing rounds.
- Validate the number of rounds:
   - Must be a positive integer.

### Game Logic
- For each round:
   - For each car:
      - Generate a random number between **0 and 9**.
      - If the number is **4 or higher**, move the car forward.
- After each round:
   - Print each car's name and its progress using hyphens (e.g., `pobi : --`).

### Result Output
- After all rounds:
   - Determine the winner(s) — the car(s) with the farthest distance moved.
   - Print the winner(s)' names separated by commas.

### Error Handling
- If the user provides invalid input:
   - Throw an `IllegalArgumentException` and terminate the program.

---

## ✅ Requirements Checklist
- Kotlin 1.9.24
- No external libraries other than provided (`Randoms`, `Console`).
- Tests written using JUnit 5 and AssertJ.
- Followed Kotlin coding conventions (indentation depth ≤ 2).

---

## 📚 References
- [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ Core API](https://assertj.github.io/doc/)
