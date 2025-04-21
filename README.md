# Car Racing Game - Kotlin Pre-course Mission1

## Project Description

This project is a simple text-based car racing game written in Kotlin.  
The application accepts car names and a number of rounds from the user, simulates the race, and displays the winner(s).

This repository follows strict clean code practices, Kotlin conventions, and Git commit message standards (AngularJS-style).

---

## ✅ Planned Feature List

Each of the following features will be implemented in a separate, well-scoped commit.

### 1. User Input
- To receive user input, use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console`
- [x] Prompt user to enter car names as a comma-separated string
- [x] Prompt user to enter number of race rounds

### 2. Input Validation
- [x] Validation of Car names:
    - [x] Not be empty
    - [x] No empty space between commas
    - [x] Not exceed 5 characters
- [x] Validation of Rounds:
    - [x] Not be empty
    - [x] Is a number
    - [x] Number of rounds must be a positive integer
- [x] Throw `IllegalArgumentException` for invalid input and terminate the program
    - Do not use `System.exit()` or `exitProcess()` to terminate the program

### 3. Car Implementation
- [x] Create 'car' class with:
    - [x] Name property
    - [x] Initialize Position
    - [x] Movement logic

### 4. Game Logic
- [ ] Initialize cars
- [ ] Generate a random number from 0 to 9 for each car per round
    - Use `Randoms.pickNumberInRange(0, 9)` from `camp.nextstep.edu.missionutils.Randoms`
- [ ] Move car forward **only if** the random number is 4 or greater
- [ ] Store each car’s progress internally (e.g., position counter)
- [ ] Repeat this process for the number of rounds entered by the user

### 5. Round Output
- [ ] For each round, display:
    - Each car's name
    - A dash (`-`) for every move the car makes
    - Example: `pobi : --`

### 6. Final Winner(s) Result
- [ ] Determine the car(s) that moved the furthest
- [ ] Display the winner(s) in the following format:
    - Single winner: `Winners : pobi`
    - If multiple cars tie for the lead, show all as winners
    - For multiple winners case, display the winners in a comma-separated list
    - Multiple winners (tie): `Winners : pobi, jun`

---

## ✅ Testing List
- Use **JUnit 5** and **AssertJ** for testing
- Test cases will include:
    - Valid and invalid input handling
    - Car movement based on controlled randomness
    - Winner determination logic
- Use parameterized tests for efficient test coverage

---

## Example Execution

```
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

Race Results
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Winners : pobi, jun
```

---

## Tech & Tools

- **Language**: Kotlin 1.9.24
- **Build Tool**: Gradle (Kotlin DSL)
- **Testing**: JUnit 5, AssertJ
- **Utilities**: `camp.nextstep.edu.missionutils.Randoms` and `Console`

---

## Project Rules & Constraints

- Only Kotlin may be used (no Java)
- Entry point must be `main()` in the `Application` class
- Do **not** modify `build.gradle.kts`
- Do **not** use `System.exit()` or `exitProcess()`
- Keep function indentation at **maximum 2 levels**
- Each function must do **only one thing**
- Follow **Kotlin coding conventions**
- Use **AngularJS-style commit messages** for all commits

