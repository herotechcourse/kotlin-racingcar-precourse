# kotlin-racingcar-precourse

# Car Racing Game

This is a simple console-based car racing game written in Kotlin. Players can specify car names and the number of rounds for the race. Each car will either move forward or stay still during a round based on a randomly generated number. The game announces the winners once the race ends.

## Features

- **User Input for Car Names**: Players can specify car names as comma-separated values (e.g., `pobi,woni,jun`).
- **Rounds Specification**: Players can define the number of rounds the race will run.
- **Random Movement**: Each car moves forward if a randomly generated number between 0 and 9 is 4 or greater. Otherwise, the car stays still.
- **Progress Display**: After each round, each car's progress is displayed with the car's name and a sequence of dashes (`-`) representing how far the car has moved.
- **Winner(s) Announcement**: The game displays the winners at the end of the race. If multiple cars reach the same final position, they will all be declared winners.
- **Error Handling**: The program checks for invalid input and throws an `IllegalArgumentException` if the user enters incorrect data.

## Requirements

- **Kotlin** 1.9.24 or later
- **JUnit 5** for testing
- The project uses only the `camp.nextstep.edu.missionutils` package, which provides utilities for reading input and generating random numbers.

## Setup and Execution

### Prerequisites

Ensure you have the following installed:

1. **JDK 11 or higher**
2. **Gradle** (optional, if you want to run from the command line)
3. ```bash
   git clone https://github.com/HariDarshan2321/car-racing-game.git
   cd car-racing-game
4. Run the application via the terminal with the following command:
   ```bash
   ./gradlew build
   ./gradlew run

