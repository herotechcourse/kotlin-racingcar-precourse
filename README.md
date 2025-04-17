# 🏎️ Kotlin Racing Car Project 🏁

## 🚀 Features to Implement

### 1. Input Handling and Validation ✅
- Read car names as comma-separated input
- Validate that each car name is non-empty and doesn't exceed 5 characters
- Implement error handling for invalid car names (`throw IllegalArgumentException`)
- Read and validate the number of rounds for the race

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

### 3. Game Logic 🎮
- Implement random movement algorithm (move forward if random number ≥ 4)
- Track car positions throughout the race
- Execute the specified number of rounds
- Determine winner(s) after all rounds are complete

### 4. Output Formatting 📊
- Display race results after each round
- Format car progress using dashes to represent position
- Display the final winner(s)
- Handle multiple winners with comma-separated output

### 5. Testing 🧪
- Unit tests for car movement logic
- Unit tests for winner determination
- Tests for input validation
- Integration tests for the complete race workflow

## 📁 Project Structure
```
src/
├── main/kotlin/
│   ├── racingcar/
│   │   ├── domain/
│   │   │   ├── Car.kt         ✅
│   │   │   └── Race.kt        ✅
│   │   ├── ui/
│   │   │   ├── InputView.kt
│   │   │   └── OutputView.kt
│   │   └── Application.kt
└── test/kotlin/
    └── racingcar/
        ├── domain/
        │   ├── CarTest.kt
        │   └── RaceTest.kt
        └── ApplicationTest.kt
```

## 💡 Implementation Approach

I will follow these principles in my implementation:
- ✨ Keep functions small and focused, each one doing only one thing
- 🔍 Limit nesting depth to a maximum of 2 levels
- 🛡️ Use proper exception handling for invalid inputs
- 📏 Follow Kotlin coding conventions
- 📝 Make small, feature-focused commits following AngularJS commit message conventions
- 🧪 Write comprehensive tests with JUnit 5 and AssertJ

## 📅 Development Plan
1. 🏗️ Set up basic project structure ✅
2. 🚗 Create the domain model classes ✅
3. ⌨️ Implement input handling and validation
4. ⚙️ Implement the core game logic
5. 🖼️ Add output formatting
6. 🧪 Write tests for all components
7. 🔄 Refactor as needed to improve code quality

## 🔄 Progress Tracker
- [x] Project setup
- [x] Domain model
- [ ] Input handling
- [ ] Game logic
- [ ] Output formatting
- [ ] Unit tests
- [ ] Integration tests
- [ ] Final review and refactoring

_Happy coding and racing! 🏎️💨_