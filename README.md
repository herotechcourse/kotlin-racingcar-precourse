# Car Racing Game

## Overview
A command-line racing game implemented in Kotlin where multiple cars compete across several rounds. The game features random movement mechanics and supports multiple winners.

## Features

### Input Processing
- Car name validation
  - Length check (1-5 characters)
  - Empty name check
  - Space character check
- Multiple car name input (comma-separated)
- Round number validation (positive integer)

### Game Mechanics
- Random movement based on generated numbers (0-9)
- Forward movement when number ≥ 4
- Position tracking for each car
- Multiple winner support

### Output Display
- Real-time race progress
- Winner determination and announcement
- Formatted display with proper spacing

## Technical Implementation

### Architecture
- MVC pattern
  - Model: Car, Cars, RacingGame
  - View: InputView, OutputView
  - Controller: RacingGameController

### Error Handling
- Input validation
- Proper exception messages
- Graceful error termination

### Testing
- Unit tests for all components
- Integration tests for game flow
- Edge case coverage
- Exception testing

## Getting Started

### Prerequisites
- JDK 21
- Kotlin 1.9.24

### Running the Game
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run the main function in Application.kt

### Running Tests
```bash
./gradlew test
```

## Example Usage
```
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

Race Results
pobi : -
woni : 
jun : -
...

Winners : pobi, jun
```

## Development Notes

### Code Style
- Following Kotlin conventions
- Maximum nesting depth of 2
- Single responsibility principle
- Small, focused functions

### Testing Strategy
- JUnit 5 for testing framework
- AssertJ for assertions
- Parameterized tests for comprehensive coverage
- Mocking of random number generation for predictable tests
