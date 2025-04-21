# kotlin-racingcar-precourse
## Feature implementation

### ✅ Input Handler

- [ ] Read car names from user input
    - [ ] Separate names at comma
    - [ ] Validate length of car names (1 to 5 characters)
- [ ] Read number or rounds from user input
    - [ ] Validate data type to be a positive integer
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
