# Car Racing Game

## Feature List

### 1. User Input Handling
- Read car names as comma-separated input
- Read the number of rounds to be played
- Validate that input follows the required format

### 2. Input Validation
- Validate that car names do not exceed 5 characters
- Validate that car names are not empty
- Validate that the number of rounds is a positive integer
- Throw IllegalArgumentException for invalid inputs

### 3. Car Movement Logic
- Generate random numbers between 0 and 9 using the provided Randoms.pickNumberInRange() method
- Move a car forward when the random number is 4 or greater
- Implement the car movement logic for each round

### 4. Race Execution
- Process the movement of all cars for each round
- Track the position of each car
- Determine the winner(s) after all rounds are complete

### 5. Output Display
- Display round-by-round race results with car names and position indicators
- Display a single winner when there's only one car with the maximum position
- Display multiple winners separated by commas when there's a tie

### 6. Testing
- Write unit tests for the Car class
- Write unit tests for the Race class
- Write unit tests for input validation
- Ensure all tests pass with the Gradle test command

## Development Rules
- Use Kotlin 1.9.24
- Indentation depth must not exceed 2 levels
- Each function must do only one thing
- Follow the Kotlin Coding Conventions
- Use JUnit 5 and AssertJ for testing
- Use the provided Randoms and Console APIs for random values and user input

## Architecture and Design Patterns

This project implements the Model-View-Controller (MVC) architecture pattern to separate concerns and improve maintainability:

### Model
- Car: Represents a car in the racing game with a name and position.
- Race: Manages the collection of cars and racing logic.

### View
- InputView: Handles user input collection through the console.
- OutputView: Manages the display of race results and winners.

### Controller
- RaceController: Coordinates the flow between models and views, processes input, and manages the game logic.

### Key Design Principles Applied

1. Single Responsibility Principle: Each class has a single responsibility and reason to change.
2. Encapsulation: Internal state of objects is hidden and accessed through well-defined interfaces.
3. Immutability: Where appropriate, objects are designed to be immutable to prevent unexpected state changes.
4. Separation of Concerns: Input/output, business logic, and data management are separated.

The implementation follows object-oriented design practices while leveraging Kotlin's language features for clean, concise code.
