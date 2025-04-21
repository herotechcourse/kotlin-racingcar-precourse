# kotlin-racingcar-precourse

## Planned Features
1. **Input Handling**
    - Read comma‑separated car names
    - Read number of rounds

2. **Validation**
    - Each name must be 1–5 non‑blank characters
    - Rounds must be a non‑negative integer

3. **Domain Logic**
    - Represent each car with `Car(name, position)`
    - Advance each car if random ≥ 4
    - Repeat for N rounds via `CarManager`

4. **Output**
    - After each round, display each car’s progress bar
    - After all rounds, display winners (comma‑separated)

5. **Error Handling**
    - Throw `IllegalArgumentException` on invalid input

## Project Structure

    racingcar/
    │
    ├── controller/
    │   └── RacingCarController.kt
    │
    ├── domain/
    │   ├── Car.kt
    │   └── CarManager.kt
    │
    ├── input/
    │   └── InputReader.kt
    │
    ├── util/
    │   ├── InputSplitter.kt
    │   └── RandomUtils.kt
    │
    ├── validator/
    │   └── InputValidator.kt
    │
    └── view/
        └── ViewResult.kt

## Project Architecture

This project follows a simple **Model–View–Controller (MVC)** layering:

- **Model** (`domain/`)
    - `Car.kt` and `CarManager.kt` define the core data structures and business logic.

- **View** (`view/`)
    - `ViewResult.kt` handles all console‑output formatting for race progress and winners.

- **Controller** (`controller/`)
    - `RacingCarController.kt` coordinates input reading, invokes the domain logic, and delegates formatting to the view.

Helper packages (`input/`, `util/`, `validator/`) support MVC by providing input routines, utility functions, and validation logic without mixing concerns.



## Feature Descriptions
- **InputReader** (`input/`)  
  Handles all console prompts and calls `Console.readLine()`.

- **InputValidator** (`validator/`)  
  Checks for blank names, length limits, and numeric rounds.

- **InputSplitter** (`util/`)  
  Splits comma‑separated strings into trimmed lists.

- **RandomUtils** (`util/`)  
  Wraps `Randoms.pickNumberInRange(0, 9)`.

- **Car** (`domain/Car.kt`)  
  Data class holding `name` and `position`, with `race()` method.

- **CarManager** (`domain/CarManager.kt`)  
  Manages a list of cars, advances them, computes winners.

- **ViewResult** (`view/ViewResult.kt`)  
  Formats and prints each car’s progress and final winners.

- **RacingCarController** (`controller/`)  
  Orchestrates reading input, running the race, and displaying results.  

### ✅ Tests

The project includes feature and validation tests using JUnit 5 and AssertJ.

- `InputTest`: Verifies input validation such as empty names, name length, empty or invalid round count, and accepts valid trimmed inputs.
- `ApplicationTest`: Tests game flow including round results, exception handling, and multiple winner scenarios.
