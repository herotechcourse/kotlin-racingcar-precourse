# kotlin-racingcar-precourse

This project is a Kotlin-based implementation of a racing car game. The game simulates a race between cars, where each car moves based on random conditions. The goal is to determine the winner(s) after a specified number of rounds.

## Features
- Simulates a racing game with multiple cars.
- Allows users to input car names and the number of rounds.
- Validates car names and input values.
- Displays the progress of the race and the final winner(s).

## Project Structure
- `src/main/kotlin`: Contains the main application code.
  - `racingcar/domain`: Core domain logic for the racing game.
  - `racingcar/model`: Models representing the entities in the game.
  - `racingcar/util`: Utility functions used across the project.
- `src/test/kotlin`: Contains unit tests for the application.

## How to Run
1. Clone the repository.
2. Open the project in an IDE that supports Kotlin (e.g., IntelliJ IDEA).
3. Build the project using Gradle.
4. Run the `Application.kt` file to start the game.

## How to Test
- Run the test cases using the command: `./gradlew test`.
- Test reports can be found in the `build/reports/tests/test` directory.
