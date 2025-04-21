# kotlin-racingcar-precourse
# 🚗 Racing Car Game

A simple console-based racing game where cars move forward based on random numbers. The car that moves the farthest after all rounds wins!

## 🧩 Features

### 📥 InputReader
Handles user input and validates car names and number of rounds.

### 🏁 RaceExecutor
Runs the core racing simulation.

- Generates random values per car for the given number of rounds.
- Tracks the sequence of moves for each car.

### 🖥️ RaceResultRenderer
Handles scoring and formatting of race results.

- Tracks scores per round.
- Computes final scores.
- Determines winners.
- Renders visual output for race progress.

### 🚦 RacingCarOrchestrator
This class serves as the **main coordinator** of the racing game by managing the flow between input, race execution, and output rendering.



