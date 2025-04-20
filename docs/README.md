# List of Features

## 🏎 Game flow
1. Start the program.
2. Request user inputs (2ea)
3. Validate the inputs.
4. Execute the race.
5. Print out the result of each round and final winner(s).

````markdown
    [game-start]                : request & validate input. 
        ↓
    [game-init]                 : split carNames, trim, create Car objects, parse nRounds.
        ↓
    [RaceExecution]             : move cars per round using random value >= 4.
        ↓
    [GameLoop / GameFlowManager]: repeat race-execution as many as nRounds, store each round states. 
        ↓
    [ProgressTracking]          : track car positions per round, store each progress
        ↓
    [GameEnd / Winners]         : check winners based on final position (! multiple winners)
        ↓
    [Output]                    : print round by round state and final result
````
---

## 🏌️ Approach
    Break down the Game flow into small,
    testable feature modules like below.

---

## 👾 Feature Modules
### 🧩 Game flow manager Module (MVC: "Controller")
| Feature               | Description                                    | Test code | Green | Refactored | Done |
|:----------------------|:-----------------------------------------------|:---------:|:-----:|:----------:|:----:|
| game-configurator     | Handles user input collection and validation   |     ✅     |   ✅   |     ✅      |  ✅   |
| game-init             | Make cars based on user input                  |     ✅     |   ✅   |     ✅      |  ✅   |
| game-loop             | Repeat game as many as rounds                  |     ✅     |   ✅   |     ✅      |  ✅   |
| game-class            | Controls the overall game flow by orchestrating configuration, initialization, and game loop execution.                 |     -     |   -   |     ✅      |  ✅   |
| ❌ game-track-progress | Replaced with outputEachRoundResult() function |     ❌     |   ❌   |     ❌      |   ❌   |
| ❌ game-end            | Replaced with outputFinalWinner() function     |     ❌     |   ❌   |     ❌      |   ❌   |

### 🧩 Input Module
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---------:|:---:|:----------:|:---:|
| input-request | Display a message prompting the user for inputs |     ✅     | ✅ |      ✅      | ✅ |
| input-read-car-names | Read input(1): car names from user |     ✅     | ✅ |     ✅      | ✅ |
| input-read-rounds | Read input(2): the number of rounds from user |     ✅     | ✅ |     ✅      | ✅ |
 ⚠️ These three input-related responsibilities have been consolidated into InputModule and its implementation ConsoleInputModule for clearer separation of concerns and reusability.

### 🧩 Validation Module
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---------:|:-----:|:----:|:---:|
| validate-car-names | Validate car names for length, emptiness, and format |     ✅     |   ✅   | - | - |
| validate-rounds | Validate number of rounds for positivity and format |     ✅      |   ✅   | - | - |

### 🧩 Race execution Module (MVC: "Model")
| Feature                     | Description                                                               | Test code | Green | Refactored | Done |
|:----------------------------|:--------------------------------------------------------------------------|:---------:|:-----:|:----------:|:----:|
| ❌ race-start                | Omitted because it is already handled in gameInit()                       |     ❌     |   ❌   |     ❌      | ❌    |
| race-generate-random-number | Random number between 0 - 9                                               |     ✅     |   ✅   |     -      |  -   |
| race-is-move-condition-met  | Return true if the random number meets or exceeds the movable condition   |     ✅     |   ✅   |     -      |  -   |
| race-move-cars              | Move cars forward only if they pass the random check condition            |     ✅     |   ✅   |     -      |  -   |
| race-update-track           | Update track state after each round                                       |     ❌      |   ❌    |     -      |  -   |

### 🧩 Error handling Module
| Feature        | Description                                                                                                     | Test code | Green | Refactored | Done |
|:---------------|:----------------------------------------------------------------------------------------------------------------|:---------:|:---:|:----:|:---:|
| ❌ error-input  | Replaced with IllegalArgumentException & println()                                                              | ❌ | ❌ | ❌ | ❌ |
| ❌ error-output | Replaced with IllegalArgumentException & println()                                                              | ❌ | ❌ | ❌ | ❌ |

### 🧩 Output Module (MVC: "View")
| Feature                | Description                                            | Test code | Green | Refactored | Done |
|:-----------------------|:-------------------------------------------------------|:---------:|:-----:|:----------:|:----:|
| output-round-result    | Prints race results for each round                     |     ✅     |   ✅   |     -      |  -   |
| output-final-winner    | Chcek who the winner(s) is based on the final position |     ✅     |   ✅   |     -      |  -   |
| ❌ output-error-message | Replaced with IllegalArgumentException & println()     |     ❌     |   ❌   |      ❌      |   ❌   |

<br>
Option for status columns (Test, Refactored, Done)<br>
✅ : Finished<br>
⏳ : In progress<br>
—  : Not started or not applicable <br>
❌ : Don't need to make

---

## 🏷️ Variables
| Variable | Role | Condition |
|:---|:---|:---|
| carName | - | 1. Each car must have a name<br> 2. Name can't exceed 5 characters |
| nRounds | - | - |

---

## 📘 Classes
| Class | Role |
|:---|:---|
| - | - |

---

## 🗒 Memo
### 1. Input
- Names of the cars, comma-separated, entered by the user <br>
        ex) `pobi,woni,jun` <br>

- The number of rounds<br>
        ex) `5`

### 2. Output
- Race results by round <br>
    ex) <br>
    `pobi : --`  
    `woni : ----`  
    `jun  : ---`

- Message for a single winner <br>
    ex) `Winners : pobi`
    
- Message for multiple winners <br>
    ex) `Winners : pobi, jun`
