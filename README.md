# kotlin-racingcar-precourse

## Feature List

### Input Handling
- [x] Prompt the user to enter car names (comma-separated, each name up to 5 characters).
- [x] Prompt the user to enter the number of race rounds.
- [x] Throw an IllegalArgumentException if any car name is empty or exceeds 5 characters.
- [x] Throw an IllegalArgumentException if the number of rounds is not a valid number.

### Game Logic
- [x] Create car objects using the entered names.
- [ ] For each round, generate a random number (0–9) for each car.
- [ ] Move the car forward if the number is 4 or higher.
- [ ] Save and display the progress of each car for each round.

### Result Output
- [ ] After each round, display each car's name and position.
- [ ] At the end of the game, display the winner(s) who traveled the farthest.
- [ ] If there are multiple winners, display all names separated by commas.

### Testing
- [ ] Write unit tests based on the feature list.
- [ ] Mock Randoms.pickNumberInRange() for predictable test results.
- [ ] Write tests for edge cases and invalid input scenarios.