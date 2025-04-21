# kotlin-racingcar-precourse


### Functional Requirements
- In each round, cars either move forward or stay based on a random number between 0 and 9.
- Each car’s name and current position should be printed after every round.
- After the game ends, the car that has moved the furthest should be printed as the winner.
- If there are multiple cars with the same maximum distance, all of them should be printed as winners.

### Programming Requirements
- Car names should be provided as a comma-separated string.
- The Car object must have a name and a driveCount state.
- The Game class should include essential functions such as gameStart(), checkWinner(), and generateRandomNumber().
- The program must follow the input/output format: print the results of each round and the final winner(s) at the end.

### Test
- Each Car object should be tested to ensure that its `driveCount` increases correctly when `drive()` is called.
- The Game class should be tested to ensure that:
    - `gameStart()` updates all Car objects correctly across multiple rounds.
    - `checkWinner()` returns all Car objects with the highest `driveCount`.
    - In case of a tie, multiple winners are correctly identified and returned.