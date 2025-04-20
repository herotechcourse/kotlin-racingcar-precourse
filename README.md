# kotlin-racingcar-precourse
This is a simple command-line car racing simulation game built in Kotlin. The program allows users to input car names and the number of rounds for a race, and then simulates the race, showing the progress of each car at every round and determining the winner(s).

---

## Features

- **Input Handling**:
  - The user provides a comma-separated list of car names and the number of rounds.
  - Input validation ensures car names are unique, not empty, and do not exceed 5 characters. At least 2 cars must be provided to start the race.
  - The number of rounds must be a positive integer, cannot be empty, and must be at least 1.

- **Game Logic**:
  - For each round, a car moves forward if a randomly generated number between 0 and 9 is greater than or equal to 4.
  - After each round, the car's progress is displayed, showing the car’s name along with the number of moves it made.
  - The race continues for the specified number of rounds.

- **Output**:
  - After all rounds, the winner(s) are determined and displayed. In case of a tie, all cars that reached the final position are shown.
  - Invalid input results in an `IllegalArgumentException`, terminating the program.

---

## Requirements Fulfilled

✅ **Programming Requirements**

✅ **Process Requirements**

✅ **Functional Requirements**

---

## Testing

- **Unit Tests**: Unit tests are implemented to verify the correctness of the input validation logic, game mechanics, and exception handling.
- **Integration Tests**: Integration tests are written to test the overall flow of the game, including user input, race simulation, and result display.

To run the tests, use the following command:

```bash
./gradlew test
```
