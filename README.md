# kotlin-racingcar-precourse

## Features to Implement

### Input Handling
- [x] Read and parse comma-separated car names from user input
- [x] Validate that car names are 5 or under 5 characters and not blank
- [x] Read and validate number of rounds whether it's positive integer

### Car and Racing Logic
- [x] Create a car class that has name and position
- [x] Implement moving logic (moves forward when randomly generated number between 0 and 9 is 4 or greater)

### Game Flow
- [ ] Start the game via the `Application.main()` entry point
- [x] Start each round until the number of rounds reaches the limit
- [x] Show how far the car reached every round
- [x] Make car move each round and return result
- [ ] Find the Winner of the race after the race is complete.

### Output
- [ ] Print the progress of each car with "-" for one movement
- [ ] Print the winner(or winners) of the race separated by commas

### Testing
- [ ] Test Car class
- [ ] Test Game logic
- [ ] Test validations