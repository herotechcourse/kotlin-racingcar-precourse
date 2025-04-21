# kotlin-racingcar-precourse

# Racing Car Game

## Mission Overview
- This is a simple car racing simulation based on user input.
- The user enters a list of car names and the number of rounds to play.
- Each car moves forward randomly based on predefined rules.
- The car(s) that travel the farthest win the race.
- Input validation, output format, and exception handling must meet the specified requirements.

---

## Feature List

### 1. User Input Handling
- [X] Receive a comma-separated list of car names
- [X] Validate that each name is 1–5 characters long
- [X] Receive the number of rounds to play
- [X] If input is invalid or empty, throw `IllegalArgumentException`

### 2. Race Logic
- [X] Create car objects from the given names
- [X] For each round, generate a random number (0–9) per car
- [X] If the number is 4 or greater, the car moves forward
- [X] After each round, print each car’s position

### 3. Result Output
- [X] Print the final winners after all rounds
- [X] Handle ties: print all winners separated by commas
- [X] Match the output format exactly as specified in the requirements

### 4. Testing
- [X] Test for invalid input and exceptions
- [X] Test random movement logic
- [X] Test multiple winners logic
- [X] Integration test to verify final output matches example

---

## How to Run

```bash
./gradlew clean test
./gradlew clean build
```
