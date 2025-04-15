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
### 🧩 Game flow manager Module
| Feature | Description | Test code | Refactored | Done |
|:---|:---|:---:|:---:|:---:|
| Start game | - | - | - | - |
| Initialize game | ex) make cars by the input | - | - | - |
| Run game loop | as many as the Num of rounds | - | - | - |
| Track game progress | Moniter each rounds, check the winner | - | - | - |
| End game | - | - | - | - |

### 🧩 Input Module
| Feature | Description | Test code | Refactored | Done |
|:---|:---|:---:|:---:|:---:|
| Request inputs | Display a message prompting the user for inputs | - | - | - |
| Read input(1) | Read car names | - | - | - |
| Read input(2) | Read the number of rounds | - | - | - |

### 🧩 Validation Module
| Feature | Description | Test code | Refactored | Done |
|:---|:---|:---:|:---:|:---:|
| Validate input(1) | Validate car names | - | - | - |
| Validate input(2) | Validate the number of rounds | - | - | - |

### 🧩 Race execution Module
| Feature | Description | Test code | Refactored | Done |
|:---|:---|:---:|:---:|:---:|
| Start racing | Execute the race logic | - | - | - |
| Generate random number | Generate random number | - | - | - |

### 🧩 Error handling Module
| Feature | Description | Test code | Refactored | Done |
|:---|:---|:---:|:---:|:---:|
| Error for input | - | - | - | - |
| Error for output | - | - | - | - |

### 🧩 Output Module
| Feature | Description | Test code | Refactored | Done |
|:---|:---|:---:|:---:|:---:|
| Print round result | - | - | - | - |
| Print final winner | - | - | - | - |

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
