# kotlin-racingcar-precourse
A racing game implemented in Kotlin as part of the Hero Tech Course pre-course mission 1.

In this game, users input a list of car names and the number of rounds.  
Each car randomly moves forward depending on the generated number in each round.  
The car(s) that reach the farthest distance at the end of all rounds are declared as the winner(s).

## Feature List
### 1. User Input
- [x] Accept car names from user input, separated by commas
  - [x] Validate that each car must have name
  - [x] Validate that each car name does not exceed 5 characters
- [x] Accept the number of rounds to play
  - [x] Validate that the number is a positive integer
- [x] Throw `IllegalArgumentException` and terminate the program if invalid input is given

### 2. Game Logic
- [x] For each round, generate a random number (0 to 9) for each car
- [x] If the number is 4 or higher, the car moves forward
- [x] Print the progress of each car after every round in the format: `carName : ---`

### 3. Final Result
- [x] Determine the winner(s) based on the farthest distance
- [x] If multiple cars are tied for the farthest distance, declare all of them as winners
- [x] Print winners in the format: `Winners : carName1, carName2` (comma-separated for multiple winners)
