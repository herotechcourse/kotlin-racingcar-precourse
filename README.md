# 🏎️ Car Racing Game (Kotlin)

A console-based car racing simulation built in **Kotlin 1.9.24** as part of the Nextstep pre-course mission. This game allows users to enter car names and number of race rounds, simulates movement based on randomness, and determines the final winner(s). Developed under strict coding, testing, and formatting constraints.

---

## 📌 Overview

This project fulfills both functional and programming requirements set by the mission:

- ✅ Console-based gameplay using **provided I/O & RNG utilities**
- ✅ Clean, testable Kotlin code using **JUnit 5** and **AssertJ**
- ✅ Compliant with **Kotlin Coding Conventions** (max 2-level indentation)
- ✅ No external libraries or modified build files

---

## 🎮 Game Rules

1. User enters car names (comma-separated, max 5 characters each).
2. User enters the number of race rounds (must be a positive integer).
3. Each round:
    - Each car moves forward by 1 step **if a random number between 0 and 9 is 4 or more**.
4. After all rounds:
    - The car(s) with the greatest distance are declared winners.
5. If input is invalid:
    - The program throws an `IllegalArgumentException` and exits **without using `exitProcess()`**.

---

## 🧩 Planned Features

### 🎮 Game Functionality
- [ ] Accept user input for car names (comma-separated)
- [ ] Validate car names (non-empty, ≤ 5 characters)
- [ ] Accept user input for number of race rounds
- [ ] Validate number of rounds (positive integer)
- [ ] Move cars based on random numbers (0–9)
    - Car moves if number ≥ 4
- [ ] Display car progress after each round (e.g., `pobi : --`)
- [ ] Determine and display winner(s) with the maximum distance
- [ ] Support displaying multiple winners (comma-separated)
- [ ] Throw `IllegalArgumentException` for invalid input

### 🛠 Technical Constraints
- [ ] Use only `Console.readLine()` for user input
- [ ] Use only `Randoms.pickNumberInRange(0, 9)` for randomness
- [ ] Do not use `System.exit()` or `exitProcess()` to terminate
- [ ] Do not modify `build.gradle.kts` or use external libraries
- [ ] Ensure entry point is `main()` in `Application.kt`

### 💡 Code Style & Structure
- [ ] Follow Kotlin Coding Conventions (indentation ≤ 2 levels)
- [ ] Keep functions small, focused, and single-responsibility
- [ ] Organize code into logical packages (domain, view, util, etc.)

### 🧪 Testing
- [ ] Write unit tests using **JUnit 5**
- [ ] Use **AssertJ** for fluent assertions
- [ ] Include tests for input validation
- [ ] Include tests for car movement logic
- [ ] Include tests for race progression and result calculation

---

## 🧰 Technologies & Constraints

| Category         | Specification                                         |
|------------------|-------------------------------------------------------|
| Language         | Kotlin 1.9.24                                         |
| Entry Point      | `main()` function in `Application.kt`                 |
| Random Generator | `Randoms.pickNumberInRange(0, 9)` from `missionutils` |
| Input Reader     | `Console.readLine()` from `missionutils`              |
| Exit Handling    | ❌ No `System.exit()` or `exitProcess()` allowed       |
| Indentation      | ✅ Max 2 levels per Kotlin Coding Conventions          |
| Testing          | ✅ JUnit 5 + AssertJ                                   |
| Build File       | ❌ No modifications allowed to `build.gradle.kts`      |

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/binunair005/kotlin-racingcar-precourse
cd kotlin-racingcar-precourse
