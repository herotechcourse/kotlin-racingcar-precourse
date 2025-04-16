# kotlin-racingcar-precourse

A small command‑line car‑racing game built with Kotlin and TDD.  
You type car names and the round count; the program picks winners with simple random rules.

---

## Objective

- Use Git / GitHub / IntelliJ
- Split code into small, one‑job functions
- Test with JUnit 5 + AssertJ
- Work with Gradle and Kotlin in a real workflow

---

## How It Works

- Input: car names (comma‑separated) and number of rounds.
- Each round every car gets a random 0‑9 number.
- Number ≥ 4 → car moves one step (`-`).
- Print car lines after each round.
- The farthest cars win.
- Wrong input must throw `IllegalArgumentException`.

---

## Features to Implement

### User Input
- [ ] Prompt user to input car names
- [ ] Split names by commas
- [ ] Each car name must be between 1 and 5 characters
- [ ] Throw `IllegalArgumentException` if any name is invalid
- [ ] Prompt user to input number of racing rounds
- [ ] Round count must be a valid integer

### Car Movement
- [ ] Initialize each car's move count to 0
- [ ] For each round, generate a random number between 0 and 9 for each car
- [ ] If the number is 4 or higher, increase the car’s move count by 1
- [ ] Car movement should depend on the random number

### Race Output
- [ ] After each round, print each car’s movement (e.g., `pobi : --`)
- [ ] Use `-` to represent car movement (1 dash per move)

### Determine Winner
- [ ] Find the cars with the maximum number of moves
- [ ] If there are multiple winners, separate names with commas
- [ ] Print winners in the format: `Winners : pobi, jun`

---

## Example
```
Input:

Enter the names of the cars (comma-separated):
pobi,woni,jun

Enter number of rounds:
5

Output:

Execution Result
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

...

Winners : pobi, jun
```
---

## Tech Stack

- Kotlin 1.9.24
- Gradle 8.7
- JUnit 5, AssertJ
- IntelliJ IDEA (recommended)

---

## How to Run Tests
```
bash
./gradlew clean test
```
All tests must pass. If even one fails, the submission will be considered invalid.