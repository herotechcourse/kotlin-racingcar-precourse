# kotlin-racingcar-precourse
## 🚗 Racing Car Game

### 🧱 Project Structure

This project follows a layered structure to separate concerns and improve maintainability.

```
└── racingcar
    ├── Application.kt          // Entry point of the program
    ├── domain
    │   ├── Car.kt              // Represents a car and its movement logic
    │   └── Cars.kt             // Manages a collection of cars and determines winners
    ├── view
    │   ├── InputView.kt        // Handles user input
    │   └── ResultView.kt       // Displays game results
    ├── controller
    │   └── RacingGame.kt       // Manages game rounds and progression
    └── util
        └── RandomGenerator.kt  // Generates random numbers (used for car movement)
```

### 🧪 Test Structure

```
└── test
    └── racingcar
        ├── domain
        │   ├── CarTest.kt          // Unit tests for Car movement logic
        │   └── CarsTest.kt         // Unit tests for Cars winner logic
        └── controller
            └── RacingGameTest.kt   // Tests full round progression and game flow
        
```


### ✅ Feature Requirements

- [x] **Receive car names and number of rounds from the user**
    - [x] Prompt the user to input car names separated by commas (`,`).
    - [x] Prompt the user to input the number of racing rounds.
    - [x] If the input is invalid, throw an `IllegalArgumentException`.

- [x] **Handle car movement logic**
    - [x] For each round, generate a random number between 0 and 9 for each car.
    - [x] If the number is 4 or higher, the car moves forward by one space.
    - [x] If the number is less than 4, the car does not move.

- [x] **Display race status for each round**
    - [x] After each round, print the current status of all cars.
    - [x] Each car’s movement should be displayed using `-` symbols (e.g., `pobbi : ---`).

- [x] **Determine and print the winner(s)**
    - [x] After all rounds, determine which car(s) moved the farthest.
    - [x] If there are multiple winners, print all their names separated by commas.

- [x] **Validate user input**
    - [x] Throw an exception if any car name is empty or contains only whitespace.
    - [x] Throw an exception if a car name exceeds the allowed length.
    - [x] Throw an exception if the number of rounds is not a valid positive integer.



### 🛠 Tech Stack
- Kotlin 1.9.24
- JUnit 5
- AssertJ



>### 🚫 Restrictions
>- Only Kotlin is allowed (no Java).
>- Do not modify `build.gradle.kts`.
>- Do not use any external libraries other than those provided.
>- Do not use `System.exit()` or `exitProcess()` to terminate the program.
>- Maximum indentation depth: 2 levels.
>- Entry point must be `main()` in the `Application` class.