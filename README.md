# kotlin-racingcar-precourse

## Planned Features

1. Input Handling

- Receive car names from the user (comma-separated)
- Validate car names (1 to 5 characters, no empty or blank strings)
- Receive number of rounds from the user (must be a positive integer)
- Throw `IllegalArgumentException` and terminate the program on invalid input

2. Round logic (Race)

- Create `Car` class
- Repeat the game for the number of rounds specified
- In each round, generate a random number (0–9) for each car
- If the number is 4 or higher, move the car forward by one position
- Store the result of each round for output

3. Output Processing

- Display each car’s name and current position using dashes (e.g., car1 : ---)
- After the race ends, determine the winner(s) based on the furthest distance
- If there are multiple winners, display all names separated by commas
- If there is no winner, display "No winner".

## File Structure

```
src/
└── main/
    └── kotlin/
        └── racingcar/
            ├── Application.kt
            ├── InputHandler.kt
            ├── Race.kt
            ├── model/
            │   ├── Car.kt
            │   └── RaceInputs.kt
            └── validator/
                ├── NameValidator.kt
                └── NumberValidator.kt
```

## Domain Model

- `Application.kt`: The entry point of the application, responsible for initializing and running the main program logic.
- `InputHandler.kt`: Handles user input, validates it, and converts it into a format suitable for processing by the application.
- `Race.kt`: Manages the racing logic, including creating car objects, running the race, and determining the winners.


- `model/Car.kt`: Defines the Car data class, representing a car with a name and position.
- `model/RaceInputs.kt`: Defines the RaceInputs data class, encapsulating the list of car names and the number of rounds.


- `validator/NameValidator.kt`: Provides validation logic for car names, ensuring they meet specified criteria(length, ).
- `validator/NumberValidator.kt`: Provides validation logic for the number of rounds, ensuring it is a positive integer.

## Test Coverage

- `InputHandlerTest.kt`:
  - Coverage: Tests the InputHandler class.
  - Details:
    - Validates correct parsing and validation of car names and rounds. 
    - Ensures exceptions are thrown for invalid inputs.
- `RaceTest.kt`:
  - Coverage: Tests the Race class.
  - Details:
    - Verifies creation of Car objects from RaceInputs. 
    - Tests race execution and winner determination under various scenarios (no winner, single winner, multiple winners).

- `ApplicationTest.kt`:
  - Coverage: Tests the Application class. 
  - Details:
    - Ensures the application runs correctly with valid inputs. 
    - Verifies exception handling for invalid inputs.

## Development Considerations

### 1. Input Validation:
- Thorough validation of user input is ensured by using `NameValidator` and `NumberValidator` to verify that the entered car names and number of rounds are in the correct format.
- Throws `IllegalArgumentException` for invalid inputs to maintain program stability.

### 2. Modular Design:
- Each class, such as `InputHandler`, `Race`, and `Application`, has a clear responsibility, enhancing code readability and maintainability.
- The use of `model` and `validator` packages separates domain models from validation logic.

### 3. Test Coverage:
- Comprehensive tests are written for various scenarios to enhance code reliability.
- Tests cover key functionalities such as input handling, race logic, and exception handling to prevent potential bugs.

### 4. Scalability:
- The structure of the `Race` class is designed to easily scale with an increasing number of cars or rounds.
- The creation of `Car` objects and race logic is designed to be handled flexibly.


---

## Game Rules

- The user should be able to specify car names and the number of rounds. 
  - Car names should be comma-separated when entered by the user. 
  - Each car must have a name, and names cannot exceed 5 characters. 
- Each of the n cars can either move forward or stay still during a given number of rounds. 
- A car moves forward if a randomly generated number between 0 and 9 is 4 or greater. 
- When printing the progress of each car, display the car's name alongside its movement. 
- After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
  - If there are multiple winners, their names should be displayed and separated by commas.
- If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.

## Example Execution

```angular2html
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

Race Results
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Winners : pobi, jun
```
