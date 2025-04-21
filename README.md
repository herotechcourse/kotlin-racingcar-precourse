# kotlin-racingcar-precourse
## Feature implementation

### ✅ Input Handler

- [x] Read car names from user input
    - [x] Separate names at comma
    - [x] Validate length of car names (1 to 5 characters)
    - [x] Throw IllegalArgumentException and terminate program in case of invalid input
- [x] Read number or rounds from user input
    - [x] Validate data type to be a positive integer
    - [ ] Throw IllegalArgumentException and terminate program in case of invalid input

### 🚗 Cars
- [x] Simulate round
    - [x] Move forward if generated number is 4 or greater
    - [x] Stay still if generated number is smaller than 4
- [x] Output progress of car
    - [x] Display car name
    - [x] Display "-" per distance unit


### 🏁 Race Simulation
- [ ] Start race and simulate given number of rounds
- [ ] Simulate round for each car
- [ ] Output progress for each car
- [ ] Display winner(s) (comma-separated) after given number of rounds
