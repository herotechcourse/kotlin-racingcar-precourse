# Racing Car

> ## Code review is welcome!!
>
> If you need code review, please mention me on the PR.
> I want to discuss implementation. I welcome sharp points rather than empathy.

# Feature Planning

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

- ? Needs Cars First level Collection?

  → Don't think too deeply about it; Let's implement it first.