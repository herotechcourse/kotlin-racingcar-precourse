# 🏎 Racing Car Game

![Build](https://img.shields.io/badge/build-passing-brightgreen)
![Test](https://img.shields.io/badge/test-passing-brightgreen)
![Language](https://img.shields.io/badge/language-Kotlin-orange)
![Commit Style](https://img.shields.io/badge/commit%20style-AngularJS-blue)

## Table of Contents
- [📌 Program Summary](#program-summary)
- [🏌 Approach](#approach)
- [🛠️ Development Process](#development-process)
- [🌿 Branch Structure & Refactor History](#branch-structure--refactoring-history)
- [🏗️ Hierarchy (MVC+SR structure)](#hierarchy-mvcsr-structure)
- [🗂️ Feature List](#feature-list)
- [🎯 Game Flow Overview](#game-flow-overview)
- [🏁 Execution flow](#execution-flow)
- [📩 Input Example](#input-example)
- [📤 Output Example](#output-example)
- [🧪 Test](#test)
- [📝 Development Notes](#development-notes)
- [✍️ Naming Convention](#naming-convention)
- [💡 What I Learned](#what-i-learned)

---

## Program summary
 - Implemented the Racing Car game according to the precourse mission guidelines.<br>
The project is structured with clear separation of concerns based on the MVC architecture.<br>
All functional and programming requirements were carefully checked and followed.

---

## Approach
    Break down the Game flow into small testable feature modules.

---

## Development Process
- Each feature was developed on a separate branch using TDD.
- Features included independent unit tests to verify correctness.
- All branches were merged into the `Taekeundo` branch for integration.
- After integration, redundant logic was removed,
- Refactored and reorganized based on the MVC + SR structure.
- Improved readability and maintainability through clean code practices.

---

## Branch Structure & Refactoring History
### 1. Initial Branch Strategy (TDD Phase)
```
Each main feature was developed on its own branch using a TDD approach.

Branch Name              Role Description
---------------------------------------------------------
🎮 Game flow manager     Manages overall game logic
🧾 Input                 Handles user input
📢 Output                Handles result display
✅ Validation            Validates input values
🏁 Race execution        Car movement logic
⚠️ Error handling        Handles invalid input/output
```

### 2. Refactor Phase
```
After feature completion, all branches were merged into `Taekeundo`.
The entire codebase was refactored into the final MVC form.
```

### 3. Conclusion
```
This evolution from TDD by feature → MVC structure helped<br>
improve readability, separation of concerns, and maintainability.
```

---

## Hierarchy (MVC+SR structure)
### (1) Overview
[ Controller ]<br>
└─ [Game](#game)<br>
└─ [GameConfigurator](#gameconfigurator)

[ Service ]<br>
├─ [GameInit](#gameinit)<br>
├─ [GameLoop](#gameloop)<br>
└─ [RaceExecution](#raceexecution)<br>
└─ [Validation](#validation)

[ Model ]<br>
└─ [Car](#car)

[ Interface ]<br>
└─ [Interface](#Interface)

[ View ]<br>
├─ [ConsoleInputModule](#consoleinputmodule)<br>
└─ [ConsoleOutputModule](#consoleoutputmodule)

[ Repository ]<br>
└─ [Not currently implemented](#repository)

### (2) Detail
### Game
- **Type:** Application Controller
- **Role:** Orchestrator who oversees the flow of the game.
- **Features:**
    - Manages high-level flow:<br>
      Configuration → Initialization → GameLoop.
    - Delegates specific tasks to appropriate modules.<br>
      (Input Controller, Service, View)
---
### GameConfigurator
- **Type:** Input Controller
- **Role:** Controller specialized in input preprocessing.<br>
- **Features:**
    - Handles raw input from the user.
    - Validates the input.
    - Returns a structured config object (`GameConfig`).
      <br><br>
> **Why are `Game` and `GameConfigurator` separated?** <br>
> → **SRP (Single Responsibility Principle).**<br>
> - Each controller has a single focused responsibility.<br>
> - `Game` manages the overall game flow.
> - `GameConfigurator` handles input and validation.
---
### GameInit
- **Type:** Service(1)
- **Role:** Initializes cars based on input config.
- **Features:**
    - Validates car names and the number of rounds.
    - Converts raw input into a list of `Car` objects and nRounds.
    - Returns a structured result object (`GameInitResult`).
---
### GameLoop
- **Type:** Service(2)
- **Role:** Repeats the game logic for `nRounds`.
- **Features:**
    - Iterates through each round.
    - Delegates movement logic to RaceExecution.
    - Calls movement logic to determine car positions.
    - Delegates round results and winner(s) to the output module.
---
### RaceExecution
- **Type:** Service(3)
- **Role:** Contains the logic for moving cars.
- **Features:**
    - Generates random numbers.
    - Checks if movement conditions are met.
    - Updates each car’s position accordingly.
---
### Validation
- **Type:** Service(4)
- **Role:** Provides input validation logic.
- **Features:**
  - Ensures car names meet length and format requirements.
  - Ensures number of rounds is a positive integer.
  - Throws IllegalArgumentException for invalid input.
---
### Car
- **Type:** Domain Model
- **Role:** Represents a single car participating in the race.
- **Features:**
    - Holds name and current position.
    - Can move forward when needed.
    - Represents the car’s state during the game.
---
### Interface
- **Type:** Abstraction Layer
- **Role:** Defines simple "rules" for how input and output should work.
- **Features:**
  - InputModule: Defines how to read user input (ex: car names, nRounds).
  - OutputModule: Defines how to print race progress by round and winners.
  - Used through ConsoleInputModule and ConsoleOutputModule.
---
### ConsoleInputModule
- **Type:** Input View
- **Role:** Reads user input from the console
- **Features:**
    - Request user for car names and number of rounds.
    - Passes the user's input for checking and setup.
---
### ConsoleOutputModule
- **Type:** Output View
- **Role:** Displays game results and messages.
- **Features:**
    - Prints round-by-round results.
    - Prints final winner(s).
    - Prints error messages for invalid input.
---
### Repository
- **Status:** Not currently implemented.
- **Reason:** Due to one-time,in-memory gameplay.
- **Extension Possibility:**<br>
    - If a DB is introduced later, separating the logic<br>
      into a Repository layer makes the architecture<br>
      cleaner and easier to maintain.
- **Example:**
    - Storing game history
    - Retrieving past results
    - Tracking winner statistics

---

## Feature List
- ### Full Feature Table → [Click here](./docs/README.md)

---

## Game Flow Overview
1. Game starts -> User input (Request)
2. GameConfigurator validates input and returns GameConfig
3. GameInit creates Car list & parses rounds
4. GameLoop repeats:
    - RaceExecution: move cars using random logic
    - Output: print round result
5. Output prints final winners

---

## Execution flow
````markdown
    [start()]              // Game.kt
        ↓
    [configure()]          // GameConfigurator.kt
        ↓
    [gameInit()]           // GameInit.kt
        ↓
    [gameLoop()]           // GameLoop.kt
        ↓
    [raceUpdateTrack()]    // RaceUpdateTrack.kt
        ↓
    [moveCars()]           // RaceMoveCars.kt
        ↓
    [printEachRound()]     // ConsoleOutputModule.kt
        ↓
    [printFinalWinners()]  // ConsoleOutputModule.kt
````
---

## Input Example
- Car names (comma-separated): `pobi,woni,jun`
- Number of rounds: `5`

---

## Output Example
- Race results by round <br>
  ex) <br>
  `pobi : --`  
  `woni : ----`  
  `jun  : ---`

- Message for a single winner <br>
  ex) `Winners : pobi`

- Message for multiple winners <br>
  ex) `Winners : pobi, jun`

---

## Test
    1. Run test
    = ./gradlew clean test

    2. Manual run on IntelliJ
    = Run main() from Application.kt

---

## Development Notes
- Kotlin 1.9.24
- mission-utils (Console, Randoms) used
- build.gradle.kts was adjusted during local test, reverted before commit
- TDD approach used: all modules individually tested before integration
- Commit format followed AngularJS convention

---

## Naming Convention
| Style | Usage |
|:------|:------|
|UpperCamelCase|Class, Object, Interface, File|
|lowerCamelCase|Function, Variable|
|lowercase|Package name|

---

## What I Learned
- How to structure code with MVC and SR patterns.
- Importance of separating input / process / output layers.
- How to write test-first, refactor-later.
- How to manage complexity through clean architecture.