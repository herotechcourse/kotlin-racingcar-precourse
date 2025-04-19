# Racing Car

# Prototype Feature Planning

1. Input data
    - User Should be able to specify car names and a number of rounds.
    - `Car Names`: Should be comma-separated when enters by the user.
      Each car must have a name, and names cannot exceed 5 characters.
    - If the user inputs invalid data, the program should throw an `IllegalArgumentException` and terminate.
2. Proceed Round
    - Each of the n cars can either `move forward` or `stay still` during a `given number` of rounds
    - A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
    - When printing the progress of each car, display the car's name alongside its movement.
3. Output Result
    - After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
        - If there are multiple winners, their names should be displayed and separated by commas.

This project should have 3 classes with responsibilities.

## RacingManager

- Manage Racing.
- Communicate with the user input data or output result.
- Validate the user’s input data.

## RoundManager

- Manage the Racing Rounds.
- Inform the Racing results.

## Car

- The car moves forward randomly.
- The car has a name.
- The car name cannot exceed 5 characters.

Although there were still unresolved questions, I started to implement the feature to make gradual improvements.

Here are the questions that remained unanswered at the time:

- How can I test random values?
- Do I need Cars First-level Collection?

# Prototype Implementation Self Review.

The prototype version of the code had several major issues:

1. `Domain classes` were too weak.

   Since the domain classes didn’t hold any real responsibilities, the `Manager` classes ended up knowing too much and performing too many operations. This leads to a situation where any change in business logic requires extensive modifications to the `Manager` classes, making the code hard to maintain and test.

   **What I did**: I moved the Manager Class’s Game Logic to new Domain classes.

2. `RacingManager` and `RoundManager` had no state–they only had a `start` method

   Although I could have moved the variables—used only a single method—to a class field under the pretext of considering future scalability, I didn’t want to do that.

   **What I did**: I removed `Manager` Classes and moved game logic directly into the `main` function.

## Prototype Code Structure

```
Racing Car Root
├── Application.kt
└── domain/
     ├── Car.kt
     ├── Cars.kt
     ├── Round.kt
     └── Rounds.kt
```

## Explain Classes

### Application.kt

- Role: Entry point of the Racing Car Program (main function).
- Description: Controls the execution of the game by coordinating domain objects.

### domain/Car.kt

- Role: Represents a single car.
- Responsibilities:
   - Manages the car’s name and current position.
   - Determines whether the car should move forward based on the random number.

### domain/Cars.kt

- Role: A collection class for `Car` objects (first-class collection)
- Responsibilities:
   - Encapsulates operations over a group of cars, such as moving all cars or determining winners.
   - Ensures immutability and encapsulation for safe collection handling.

### domain/Round.kt

- **Role**: Represents a single round in the race.
- **Responsibilities**:
   - Records the state of each car after the round.
   - Provides data for visualization or output purposes.

### domain/Rounds.kt

- **Role**: A collection of `Round` objects (first-class collection).
- **Responsibilities**:
   - Tracks the entire race history, round by round.
   - Provides formatted results for output or display.