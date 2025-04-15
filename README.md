# kotlin-racingcar-precourse

# Car Racing - Feature List

## Input and input validation
- [ ] Receive first user input
- [ ] Validate car names:
  - [ ] Names cannot be empty
  - [ ] Names cannot exceed 5 characters
- [ ] Receive second user input (number of rounds)
- [ ] Validate racing rounds:
  - [ ] Must be a positive integer

## Data structure
- [ ] Create `Carr` class with:
  - [ ] `name` attribute
  - [ ] `position` attribute - starting at 0
  - [ ] `move()` (based in a random number)
- [ ] Create `Race` class in order to:
  - [ ] Store list of `Car` instances
  - [ ] Store number of rounds
  - [ ] Run the race and show progress every round
  - [ ] Determine and display winner(s)

## Game Logic
- [ ] For each round:
  - [ ] Generate random number between 0 and 9, inclusive
  - [ ] If the number is 4 or greater, car moves forward by one position
- [ ] After each round:
  - [ ] Print the car's name followed by `-` symbols equal to its position
- [ ] After the final round:
  - [ ] Print winners (whoever holds the highest score):
  - [ ] If there's a tie, print all winners comma separated

## Error management
- [ ] If the first user input (car names) is invalid → throw `IllegalArgumentException`
- [ ] If the second user input (number of rounds) is invalid → throw  `IllegalArgumentException`

## Tests
- [ ] Test if car moves forward when random number is 4 or bigger
- [ ] Test a draw and multiple winners (tie)
- [ ] Test behaviour with invalid inputs in both car names and rumber of rounds