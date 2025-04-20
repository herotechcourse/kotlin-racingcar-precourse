# kotlin-racingcar-precourse

## Car Racing Game

- A simple command-line car racing game implemented in Kotlin.

## Features

- Create cars with custom names (up to 5 characters)
- Race cars over multiple rounds
- Randomly determine car movement each round
- Display race progress with visual representation
- Identify and announce winners at the end of the race

## Game Rules

- Cars are created with names provided by the user
- A car moves forward if its random number (0-9) is 4 or greater
- After all rounds are complete, the car(s) that moved the furthest are declared winners

## Usage

1. Run the application
2. Enter car names (comma-separated)
3. Enter the number of rounds
4. Watch the race progress
5. See the winner(s) announcement

## Project Structure

- model: Car, Race, and Constants classes
- controller: RaceController to manage game flow
- view: InputView and OutputView for user interaction
- service: InputValidator and RandomService for validation and random number generation
- exception: ExceptionMessage for error handling
