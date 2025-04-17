# List of Features

## 🏎 Game flow
1. Start the program.
2. Request user inputs (2ea)
3. Validate the inputs.
4. Execute the race.
5. Print out the result of each round and final winner(s).
<br><br>

## 🏌️ Approach
    Break down the Game flow into small,
    testable feature modules like below.
<br>

## 👾 Feature Modules
### 🧩 Game flow manager Module (MVC: "Controller")
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---------:|:----------------:|:---:|:---:|
| game-start | Start game execution from main() |     ⏳     |        -         | - | - |
| game-init | Make cars based on user input |     ⏳     |        -         | - | - |
| game-loop | Repeat game as many as rounds |     ⏳      |        -         | - | - |
| game-track-progress | Moniter each round's result and check the winner(s) |     -     |        -         | - | - |
| game-end | Terminate the game |     -     |        -         | - | - |

### 🧩 Input Module
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---------:|:---:|:----:|:---:|
| input-request | Display a message prompting the user for inputs |     ✅     | ✅ | - | - |
| input-read-car-names | Read input(1): car names from user |     ✅     | ✅ | - | - |
| input-read-rounds | Read input(2): the number of rounds from user |     ✅     | ✅ | - | - |

### 🧩 Validation Module
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---------:|:-----:|:----:|:---:|
| validate-car-names | Validate car names for length, emptiness, and format |     ✅     |   ✅   | - | - |
| validate-rounds | Validate number of rounds for positivity and format |     ✅      |   ✅   | - | - |

### 🧩 Race execution Module (MVC: "Model")
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---------:|:---:|:----:|:---:|
| race-start | Execute race based on number of rounds | - | - | - | - |
| race-generate-random-number | Random number between 0 - 9 | - | - | - | - |
| race-is-move-condition-met | Return true if the random number meets or exceeds the moveable condition | - | - | - | - |
| race-move-cars | Move cars forward only if they pass the random check condition | - | - | - | - |
| race-update-track | Update track state after each round | - | - | - | - |

### 🧩 Error handling Module
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---------:|:---:|:----:|:---:|
| error-input | - | - | - | - | - |
| error-output | - | - | - | - | - |

    ⚠️ Internal logic only, no output to user.

### 🧩 Output Module (MVC: "View")
| Feature | Description | Test code | Green | Refactored | Done |
|:---|:---|:---:|:---:|:---:|:---:|
| output-round-result | - | - | - | - | - |
| output-final-winner | - | - | - | - | - |
| output-error-message | - | - | - | - | - |

<br>
Option for status columns (Test, Refactored, Done)<br>
✅ : Finished<br>
⏳ : In progress<br>
—  : Not started or not applicable

<br>

## 🏷️ Variables
| Variable | Role | Condition |
|:---|:---|:---|
| carName | - | 1. Each car must have a name<br> 2. Name can't exceed 5 characters |
| nRounds | - | - |

<br>

## 📘 Classes
| Class | Role |
|:---|:---|
| - | - |

<br>

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

### 3. To be organized
- Each of the n cars can either move forward or stay still during a given number of rounds.

- A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.

- When printing the progress of each car, display the car's name alongside its movement.

- After the race is complete, display the winners. There can be multiple winners if they reach the same final position. <br>
    - If there are multiple winners, their names should be displayed and separated by commas.

- If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.
