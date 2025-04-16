# kotlin-racingcar-precourse

## Planned Features

1. User Input Processing
    - Input validation for car names (comma-separated format)
    - Validation for car name length (maximum 5 characters)
    - Input validation for number of rounds

2. Car Implementation
    - Car representation with name and position
    - Car movement mechanism based on random number generation
    - Position tracking and visualization

3. Race Management
    - Round-by-round race execution
    - Random movement determination for each car
    - Race progress display after each round
    - Winner determination based on final positions

4. Output Formatting
    - Display car positions using dash symbols
    - Format and display winner(s)
    - Proper output formatting for race results

5. Error Handling
    - Exception handling for invalid car names
    - Exception handling for invalid round number input
    - Termination mechanism on invalid input

6. Test Coverage
    - Car functionality testing
    - Race logic testing
    - Input validation testing
    - Winner determination testing
    - Output formatting testing

## Game Rules

- Each car has a name that cannot exceed 5 characters
- In each round, a car has a chance to move forward or stay still
- A car moves forward if a randomly generated number between 0 and 9 is 4 or greater
- The race continues for a specified number of rounds
- After the race is complete, the car(s) that advanced the furthest are declared the winners

## Project Structure

- `Application.kt` - Entry point that handles user input and initializes the game
- `Car.kt` - Represents a car in the race, tracking its position and movement
- `Race.kt` - Contains the racing logic, including determining winners
- `InputValidator.kt` - Validates user inputs for car names and rounds

## How to Play

1. When prompted, enter car names separated by commas (e.g., `pobi,woni,jun`)
2. Enter the number of rounds you want to play
3. Watch as the race unfolds round by round
4. See which car(s) win at the end

## Example Execution

```console
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

## Building and Running

```bash
./gradlew run
```

To run the tests:

```bash
./gradlew test
```

## Implementation Notes

- The application follows the Single Responsibility Principle with separate classes for different concerns
- Error handling is implemented for all invalid user inputs
- Functions are kept small and focused for better readability and testability
- The code follows Kotlin coding conventions and maintains an indentation depth of 2 or less