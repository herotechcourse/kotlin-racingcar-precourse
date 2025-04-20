# kotlin-racingcar-precourse

## Feature List
- Car
  - [x] Car has a name that does not exceed 5 characters
  - [x] Car can move forward
  - [x] Car can stay still
- Race
  - [x] Race Round: All cars move forward
  - [x] Race Round: All cars stay still
- Race (Full Race Execution)
  - [x] Race runs for the specified number of rounds (Test runRace orchestrates rounds correctly)
- WinnerJudge (Winning Logic)
  - [x] Race identifies a single winner (Test findWinners with one car at max position)
  - [x] Race identifies multiple winners (Test findWinners with multiple cars at max position)
- Race (Input Validation)
  - [ ] Race initialization throws IllegalArgumentException for invalid car names (empty, too long, invalid format like ",,")
  - [ ] Race initialization throws IllegalArgumentException for invalid rounds (non-numeric, zero, negative)

## Functional Requirements
- Each of the n cars can either move forward or stay still during a given number of rounds.
- A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
- When printing the progress of each car, display the car's name alongside its movement.
- After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
  - If there are multiple winners, their names should be displayed and separated by commas.
- If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.
