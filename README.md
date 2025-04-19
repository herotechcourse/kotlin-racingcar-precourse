# kotlin-racingcar-precourse
This is a simple command line based car racing simulation game.
## Features:
### Input logic
- Prompt the user to enter car names (`carNames` - comma seperated) and number of rounds (`numberOfRounds`)
- Validate `carNames`:
  - must not be an empty `String`
  - must not exceed the `MAX_CHAR_LENGTH` (5 characters)
  - must have at least 2 cars to compete
  - must have unique names
- Validate `numberOfRounds`: 
  - must not be an empty input
  - must be a positive `Int`
  - must have at least `MIN_ROUNDS` (1 round) to compete in a race
- Throw `IllegalArgumentException` with specific error details if any of the above input validations fail
### Movement logic
- Given the `carName` and `randomNumber` either move the car forwards by one position (adding "-") or keep it stationary
- A car is allowed to move forward only if the `randomNumber` >= 4
### Output logic
- Display each car's progress with `carName` and position after every round
- Show final results with winner(s), using commas only when there is a tie
