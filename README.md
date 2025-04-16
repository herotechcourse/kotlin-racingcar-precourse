# Car Racing Game (Kotlin)

A simple car racing game in the command-line. Users insert input (car names and number of rounds) and the game simulates a race displaying the progress of each car in every round.

## Features


### 1. Input car names and number of rounds

- Implement input prompt for car names in InputView

- Implement input prompt for number of rounds in InputView

- Parse and return user input as a list of names and an integer


### 2. Validate car names (comma-separated, max 5 chars) and number of rounds 
_Includes unit tests for validation logic_

- Implement Validator for car names (non-empty, max 5 chars, unique)

- Implement Validator for round number (positive integer)

- Add unit tests for car name validation

- Add unit tests for round number validation

### 3. Simulate car movement with random numbers
   _Includes unit tests for movement rules_

- Create RacingGame class with car list and rounds

- Create Car class with name and position

- Implement movement logic in Car (move if random >= 4)

- Add unit tests for car movement logic

### 4. Display race progress each round

- Implement OutputView to display car progress by round

- Format output to match requirements

### 5. Show winners (supports multiple winners)
   _Includes unit tests for winner determination_

- Implement logic to determine winner(s) after all rounds

- Add unit tests for winner determination logic

- Display winner(s) in required format
