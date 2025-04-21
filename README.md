# kotlin-racingcar-precourse

# Car Racing - Feature List

## Input and input validation
- [x] Receive first user input
- [x] Validate car names:
  - [x] Names cannot be empty
  - [x] Names cannot exceed 5 characters
- [x] Receive second user input (number of rounds)
- [x] Validate racing rounds:
  - [x] Must be a positive integer

## Data structure
- [x] Create `Car` class with:
  - [x] `name` attribute
  - [x] `steps` attribute - starting at 0
  - [x] `move()` (based in a random number)
  - [x] `printRound()` method (prints the car's name followed by - symbols based on its position)
  - [x] `getSteps()` method (returns the current position of the car)
  - [x] Validation: The name attribute must not exceed 5 characters. If it does, an `IllegalArgumentException` is thrown.

- [x] Create `Race` class in order to:
  - [x] Store list of `Car` instances
  - [x] Store number of rounds
  - [x] Run the race and show progress every round
  - [x] Determine and display winner(s)

## Game Logic
- [x] For each round:
  - [x] Generate random number between 0 and 9, inclusive
  - [x] If the number is 4 or greater, car moves forward by one position
- [x] After each round:
  - [x] Print the car's name followed by `-` symbols equal to its position
- [x] After the final round:
  - [x] Print winners (whoever holds the highest score):
  - [x] If there's a tie, print all winners comma separated

## Error management
- [x] If the first user input (car names) is invalid → throw `IllegalArgumentException`
- [x] If the second user input (number of rounds) is invalid → throw  `IllegalArgumentException`

## Tests
- [x] Test if car moves forward when random number is 4 or bigger
- [x] Test a draw and multiple winners (tie)
- [x] Test behaviour with invalid inputs in both car names and rumber of rounds