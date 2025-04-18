# kotlin-racingcar-precourse
## Feature List:
### 1. User Input Handling and Validation
- Prompt the user to enter car names (comma-separated) and number of rounds
- Validate car names (no empty names, car names must be <= 5 characters)
- Validate that the number of rounds entered is a positive integer
- Throw an IllegalArgumentException and terminate if inputs are invalid
### 2. Car Movement Logic
- Implement a logic that moves each car forward or keeps it stationary based on a random number
- Cars move forward only if the randomly generated number is >= 4
### 3. Display Progress of Each Round
- Visually display the progress of each car, at the end of each round, showing the car's name and position clearly
### 4. Determination and Display of Winners
- After the last round, calculate the car(s) with the greatest distance traveled
- Clearly display the winner(s) of the race
- Ensure multiple winners are displayed comma-separated when applicable