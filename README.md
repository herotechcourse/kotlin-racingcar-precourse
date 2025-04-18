# kotlin-racingcar-precourse
## Goals
### Learning Objectives

- Get comfortable with tools used in real-world development, such as Git, GitHub, and an IDE.
- Break down large functions that handle multiple responsibilities into smaller functions that each do one thing well.
- Learn how to use testing tools and verify that your program works correctly.

## Features to Implement

### Input Handling
- [x] Read and parse comma-separated car names from user input
- [x] Validate that car names are 5 or under 5 characters and not blank
- [x] Read and validate number of rounds whether it's positive integer

### Car and Racing Logic
- [x] Create a car class that has name and position
- [x] Implement moving logic (moves forward when randomly generated number between 0 and 9 is 4 or greater)

### Game Flow
- [x] Start the game via the `Application.main()` entry point
- [x] Start each round until the number of rounds reaches the limit
- [x] Show how far the car reached every round
- [x] Make car move each round and return result
- [x] Find the Winner of the race after the race is complete.

### Output
- [x] Print the progress of each car with "-" for one movement
- [x] Print the winner(or winners) of the race separated by commas

### Testing
- [x] Test Car class
- [x] Test Game logic
- [x] Test validations