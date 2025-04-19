# kotlin-racingcar-precourse

# Mission - Car Racing Game

## Feature List

- [ ] Receive user input.
    - [Exception] Input must not be empty.
    - [ ] Receive the names of the cars participating in the race.
    - [Exception] Car names must contain only letters and numbers. (No special characters or spaces)
    - [Exception] Car names must be unique.
    - [Exception] Car names must be between 1 and 5 characters long.
    - [Exception] Input must not start or end with a comma.
    - [ ] Receive the number of moves to perform.
    - [Exception] Only positive integers greater than 0 are allowed.

- [x] Process user requests.
    - [x] For each car, generate a random number between 0 and 9.
    - [x] If the number is 4 or greater, move the car forward by one space.

- [ ] Output the processed results.
    - [ ] Display prompts for user input.
    - [ ] Display the movement results for each car based on their status.
    - [ ] Repeat the above process n times and then display the winners.
    - [Exception] If there are multiple winners, separate their names with commas.
    - [Exception] When separating names with commas, also add a space after each comma.
    - [Exception] Output order, including race results and winners, must match the input order.
    - [Exception] Cars with 0 movements can still be winners.