# kotlin-racingcar-precourse
## ✅ Planned Features

### Game Input
- [x] Prompt user to enter car names, separated by commas
- [x] Prompt user to enter number of rounds
- [x] Validate car names (each name must be ≤ 5 characters, non-empty)
- [x] Validate round input (must be a positive integer)

### Game Logic
- [x] Initialize cars with names and starting position
- [x] For each round:
    - [x] Generate random number (0–9) per car using Randoms API
    - [x] Move car forward if number ≥ 4
    - [x] Track position of each car
    - [x] Print progress for each car (e.g., `car1 : ---`)

### Results
- [x] Determine car(s) with max position as winner(s)
- [x] If multiple winners, display all names comma-separated
- [x] Output final winner(s)

### Error Handling
- [x] Throw `IllegalArgumentException` and terminate on:
    - [x] Empty input
    - [x] Car name longer than 5 characters
    - [x] Invalid round input

### Testing
- [x] Unit tests for input validation
- [x] Unit tests for race logic and movement
- [x] Unit tests for winner calculation
- [x] Tests for error handling using AssertJ exception assertions

// I liked this project it was Interesting to do and challenging 