# kotlin-racingcar-precourse
## Overview
This is a simple racing car game implemented in Kotlin.

The game begins by taking input for the car names and the number of rounds.
Each car moves forward if it generates a random number (0–9) that is 4 or greater.
At the end of each round, the current position of each car is printed.
After all rounds are completed, the winner(s) are displayed based on distance traveled.

## Features
### Input
- Receive car names (comma-separated string)
- Validate each name (must be between 1 to 5 characters)
- Create list of Car objects
- Receive number of rounds (positive integer)

### Game Execution
- Determine if each car moves (generate random number and move if ≥ 4)
- Increase distance if the car moves
- After each round, print progress of each car in the format: `{name} : ____`

### Final Result
- Find the car(s) that traveled the farthest
- Print winners in the format: `Winners : name1, name2`

### Unit Tests
- Test move logic (random number check)
- Test name validation
- Test winner selection logic