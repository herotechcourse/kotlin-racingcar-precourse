# 🏎️ Kotlin Racing Car Project 🏁

## 🚀 Features to Implement

### 1. Input Handling and Validation ✅
- Read car names as comma-separated input
- Validate that each car name is non-empty and doesn't exceed 5 characters
- Implement error handling for invalid car names (`throw IllegalArgumentException`)
- Read and validate the number of rounds for the race
- Validate that number of rounds is a positive integer

### 2. Domain Model ✅
- Create a `Car` class to represent racing cars
  - Store car name
  - Track car position
  - Implement movement logic based on random number generation
- Create a `Race` class to manage the race
  - Store collection of cars
  - Track current round
  - Execute rounds
  - Determine winners

### 3. Game Logic ✅
- Implement random movement algorithm (move forward if random number ≥ 4)
- Track car positions throughout the race
- Execute the specified number of rounds
- Determine winner(s) after all rounds are complete

### 4. Output Formatting ✅
- Display race results after each round
- Format car progress using dashes to represent position
- Display the final winner(s)
- Handle multiple winners with comma-separated output

### 5. Testing ✅
- Unit tests for car movement logic
- Unit tests for winner determination
- Tests for input validation
- Integration tests for the complete race workflow

## 🚨 Completed Tasks
1. Created a `Validator` class to handle input validation
- Implemented method to validate car names
- Implemented method to validate round count
2. Modified `Application` class to use the validator
3. Improved exception handling to match requirements
4. Created tests for the validation logic
5. Created integration tests for the complete workflow
6. Refactored code to improve performance and readability
- Optimized winner determination algorithm
- Improved separation of concerns in Application class
- Simplified imports and removed redundant comments

## 📁 Project Structure
```
src/
├── main/kotlin/
│   ├── racingcar/
│   │   ├── domain/
│   │   │   ├── Car.kt          ✅
│   │   │   ├── Race.kt         ✅
│   │   │   └── Validator.kt    ✅  
│   │   ├── ui/
│   │   │   ├── InputView.kt    ✅
│   │   │   └── OutputView.kt   ✅
│   │   └── Application.kt      ✅
└── test/kotlin/
    └── racingcar/
        ├── domain/
        │   ├── CarTest.kt       ✅
        │   ├── RaceTest.kt      ✅
        │   └── ValidatorTest.kt ✅
        ├── RacingCarIntegrationTest.kt ✅
        └── ApplicationTest.kt   ✅
```
## 🏗️ Project Architecture

The project follows a layered architecture with clear separation of concerns:

### Layers
1. **Presentation Layer** (`ui` package)
  - `InputView`: Handles user input collection
  - `OutputView`: Manages formatting and displaying results to the user

2. **Application Layer** (`Application.kt`)
  - Coordinates the flow between UI and domain layers
  - Handles high-level application logic
  - Manages the race execution process

3. **Domain Layer** (`domain` package)
  - `Car`: Core entity representing a racing car with its state and behavior
  - `Race`: Aggregate that manages the racing process and car collection
  - `Validator`: Domain service for validating input data

### Design Patterns
- **Model-View-Controller (MVC)**: Separates the application into input handling, business logic, and output formatting
- **Single Responsibility Principle**: Each class has one primary responsibility
- **Command Pattern**: Race execution follows a command-based approach where rounds are executed sequentially

### Data Flow
````
User → InputView → Application → Validator → Cars/Race → OutputView → User
                                    ↓
                              Race Execution
                             (loop for rounds)
                                    ↓
                            Winner Determination
                                    ↓
                              Results display
````

### This architecture ensures:
- **Testability**: Components can be tested in isolation
- **Maintainability**: Changes to one layer have minimal impact on others
- **Separation of Concerns**: Each class has a clear, focused responsibility
- **Extensibility**: New features can be added with minimal changes to existing code
## 💡 Implementation Approach

I followed these principles in my implementation:
- ✨ Kept functions small and focused, each one doing only one thing
- 🔍 Limited nesting depth to a maximum of 2 levels
- 🛡️ Used proper exception handling for invalid inputs
- 📏 Followed Kotlin coding conventions
- 📝 Made small, feature-focused commits following AngularJS commit message conventions
- 🧪 Wrote comprehensive tests with JUnit 5 and AssertJ

## 📅 Development Plan
1. 🏗️ Set up basic project structure ✅
2. 🚗 Create the domain model classes ✅
3. ⌨️ Implement input handling and validation ✅
4. ⚙️ Implement the core game logic ✅
5. 🖼️ Add output formatting ✅
6. 🧪 Write tests for all components ✅
7. 🔄 Refactor as needed to improve code quality ✅

## 🔄 Progress Tracker
- [x] Project setup
- [x] Domain model
- [x] Input validation
- [x] Game logic
- [x] Output formatting
- [x] Tests for Car and Race
- [x] Tests for input validation
- [x] Integration tests
- [x] Final review and refactoring

## 🧪 Testing Strategy
- **Unit Tests**: Verify individual components work correctly in isolation
- **Integration Tests**: Ensure all components work together properly
- **Test Coverage**: Aim for comprehensive test coverage of all code paths
- **Edge Cases**: Test boundary conditions and error handling

## 🔍 Code Quality Improvements
- Optimized winner determination algorithm to use a single pass
- Improved separation of concerns in `Application` class
- Enhanced readability by simplifying imports and removing redundant comments
- Made error messages more descriptive and user-friendly
- Used a proper structure for game execution flow

*Happy coding and racing! 🏎️💨*