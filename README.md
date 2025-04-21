# kotlin-racingcar-precourse
---

# Car Racing Game

A simple car racing game where users can specify car names and the number of rounds. Each car moves forward based on a random number, and the winners are determined based on the highest position at the end of all rounds.

## Features

### 1. **Car Name Input (`InputView.kt`)**
- Users can input a list of car names as comma-separated values.
- Each car name must be between 1 and 5 characters long.
- This is handled by the `InputView.readCarNames()` method in `InputView.kt`.

### 2. **Round Count Input (`InputView.kt`)**
- Users can specify how many rounds the race will take.
- This is handled by the `InputView.readRoundCount()` method in `InputView.kt`.

### 3. **Random Movement (`Car.kt` and `Race.kt`)**
- Each car will either move forward or stay still based on a randomly generated number between 0 and 9.
- A car moves forward if the random number is 4 or greater.
- This functionality is implemented in the `Car.move()` method in `Car.kt`, using the random number generation from the `MissionUtilsRandomNumberGenerator` class.

### 4. **Race Progress Display (`ResultView.kt`)**
- After each round, the current positions of all cars will be displayed.
- Each car's movement will be shown with `-` characters, representing how many units the car has moved forward.
- This is handled by the `ResultView.printRoundResult()` method in `ResultView.kt`.

### 5. **Winner Calculation (`Race.kt` and `Car.kt`)**
- After all rounds are completed, the car(s) with the furthest position are declared winners.
- There can be multiple winners if two or more cars share the same highest position.
- This is handled by the `Race.findWinners()` method in `Race.kt`.

### 6. **Input Validation (`InputView.kt`)**
- Car names must be non-empty, and no car name should exceed 5 characters.
- The number of rounds must be a valid integer and greater than 0.
- If invalid input is provided, an `IllegalArgumentException` will be thrown.
- These checks are implemented in the `InputView.readCarNames()` and `InputView.readRoundCount()` methods.

### 7. **Progress Feedback (`ResultView.kt`)**
- The game will show the progress of the race in each round, indicating the movement of each car.
- This is displayed via the `ResultView.printRoundResult()` method in `ResultView.kt`.

## File Structure

```
src
└── main
    └── kotlin
        └── racingcar
            ├── Application.kt        ← Main entry point
            ├── model
            │   ├── Car.kt            ← Car model, responsible for movement
            │   └── Race.kt           ← Race model, responsible for race logic and winner calculation
            ├── view
            │   ├── InputView.kt      ← Handles user input for car names and rounds
            │   └── ResultView.kt     ← Displays race progress and final results
            └── controller
                └── GameController.kt ← Coordinates the flow of the game
```

## Example

### Input:
```
Enter the names of the cars (comma-separated):
pobi, woni, jun
How many rounds will be played?
5
```

### Output:
```
Race Results
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : --

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Winners : pobi, jun
```


