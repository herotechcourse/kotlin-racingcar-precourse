# List of Features

## 👾 Feature Breakdown
    ✅ All components are organized according to **MVC + SR principles.**

### 🧩 Controller
| Feature               | Description                                          | Test | Green  | Refactored | Done |
|:----------------------|:-----------------------------------------------------|:----:|:------:|:----------:|:----:|
| Game                  | Main orchestrator that controls game flow            |  ℹ️  |   ℹ️   | ✅ | ✅ |
| GameConfigurator      | Collects and validates input, returns config object  |  ℹ️  |   ℹ️   | ✅ | ✅ |

### 🧩 Service - Main Service
| Feature  | Description                                          | Test code | Green | Refactored | Done |
|:---------|:-----------------------------------------------------|:---------:|:-----:|:----:|:---:|
| GameInit | Creates Car list and parses rounds from input	       |     ✅     |   ✅   | ✅ | ✅ |
| GameLoop | Executes race flow per round and delegates to output |     ✅     |   ✅   | ✅ | ✅ |

### 🧩 Service - RaceExecution
| Feature                  | Description                                                             | Test | Green | Refactored | Done |
|:-------------------------|:------------------------------------------------------------------------|:---------:|:-----:|:----:|:---:|
| RaceGenerateRandomNumber | Random number between 0 - 9                                             |     ✅     |   ✅   |     ✅      |  ✅   |
| RaceIsMoveConditionMet   | Return true if the random number meets or exceeds the movable condition |     ✅     |   ✅   |     ✅      |  ✅   |
| RaceMoveCars             | Move cars forward only if they pass the random check condition          |     ✅     |   ✅   |     ✅      |  ✅   |
| RaceUpdateTrack          | Calls RaceMoveCars to apply movement logic                              |     ✅     |   ✅   |     ✅      |  ✅   |

### 🧩 Service - Validation
| Feature            | Description                                          | Test | Green | Refactored | Done |
|:-------------------|:-----------------------------------------------------|:---------:|:-----:|:----:|:---:|
| validate-car-names | Validate car names for length, emptiness, and format |     ✅     |   ✅   | ✅ | ✅ |
| validate-rounds    | Validate number of rounds for positivity and format  |     ✅     |   ✅   | ✅ | ✅ |

### 🧩 Model
| Class / Data    | Description                                        | Defined |
|:----------------|:---------------------------------------------------|:-------:|
| Car             | Domain model representing a racing car             |    ✅    |
| GameConfig      | Holds input configuration (car names, rounds)      |    ✅    |
| GameInitResult  | Stores initialized cars and rounds                 |    ✅    |

### 🧩 Interface Modules
| Interface        | Description                                |    Implementation     | Defined |
|:-----------------|:-------------------------------------------|:---------------------:|:---:|
| InputModule      | Input abstraction for car names & rounds   |  ConsoleInputModule   | ✅ |
| OutputModule     | Output abstraction for race result display |  ConsoleOutputModule  | ✅ |

### 🧩 View
| Feature             | Description                               | Test | Green | Refactored | Done |
|:--------------------|:------------------------------------------|:----:|:---:|:----------:|:---:|
| ConsoleInputModule  | Reads car names and round count from user |  ℹ️  |   ℹ️   | ✅ | ✅ |
| ConsoleOutputModule | Prints round-by-round results and winners |  ℹ️  |   ℹ️   | ✅ | ✅ |

### 🧩 Repository
- Not currently implemented (in-memory only).
- See [README](../README.md) for details and future extensibility.

### ❌ Omitted Features
| Feature                | Description                                            | Test code | Green | Refactored | Done |
|:-----------------------|:-------------------------------------------------------|:---------:|:-----:|:----------:|:----:|
| ❌ game-track-progress  | Replaced with outputEachRoundResult() function         | ❌ | ❌ | ❌ | ❌ |
| ❌ game-end             | Replaced with outputFinalWinner() function             | ❌ | ❌ | ❌ | ❌ |
| ❌ race-start           | Omitted because it is already handled in gameInit()    | ❌ | ❌ | ❌ | ❌ |
| ❌ output-error-message | Replaced with IllegalArgumentException & println()     | ❌ | ❌ | ❌ | ❌ |
| ❌ error-input          | Replaced with IllegalArgumentException & println()     | ❌ | ❌ | ❌ | ❌ |
| ❌ error-output         | Replaced with IllegalArgumentException & println()     | ❌ | ❌ | ❌ | ❌ |
| ❌ input-request        | ⚠️Display a message prompting the user for inputs      | ✅ | ✅ | ✅ | ✅ |
| ❌ input-read-car-names | ⚠️Read input(1): car names from user                   | ✅ | ✅ | ✅ | ✅ |
| ❌ input-read-rounds    | ⚠️Read input(2): the number of rounds from user        | ✅ | ✅ | ✅ | ✅ |
| ❌ output-round-result  | Prints race results for each round                     | ✅ | ✅ | ✅ | ✅ |
| ❌ output-final-winner  | Check who the winner(s) is based on the final position | ✅ | ✅ | ✅ | ✅ |
⚠️ These three input-related responsibilities have been consolidated into InputModule and its implementation ConsoleInputModule for clearer separation of concerns and reusability.

### Option for status columns <br>
✅ : Finished<br>
⏳ : In progress<br>
—  : Not started yet or not applicable <br>
❌ : Not needed or skipped
ℹ️ : Itself were not tested directly, but all its internal logic is covered by unit tests