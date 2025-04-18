# Car Racing Game

## Project Overview
A command-line racing game where multiple cars compete across several rounds, with random movement mechanics and winner determination.

## Features

### 1. Input Handling
- Car name validation (1-5 characters)
- Multiple car name input (comma-separated)
- Race rounds validation (positive integer)
- Exception handling for invalid inputs

### 2. Car Management
- Car object creation and initialization
- Movement logic implementation
  - Random number generation (0-9)
  - Forward movement when number ≥ 4
- Position tracking for each car

### 3. Race System
- Round-based racing mechanism
- Simultaneous position updates
- Progress tracking per round
- Multiple winner support

### 4. Output Display
- Real-time race progress visualization
  - Current position display using "-" markers
  - Car name and position formatting
- Final results announcement
  - Winner(s) determination
  - Multiple winner handling

### 5. Technical Implementation
- Clean code principles
- Single responsibility principle
- Comprehensive error handling
- Unit test coverage
- No external dependencies

## Getting Started
1. Clone the repository
2. Build the project using Gradle
3. Run the main application
4. Follow the on-screen prompts

## Testing
Run tests using:
- macOS/Linux: `./gradlew test`
- Windows: `gradlew.bat test`
