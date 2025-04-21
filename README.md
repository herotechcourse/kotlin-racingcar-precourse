# kotlin-racingcar-precourse

### Functional Requirements

#### 1. Explicit Requirements

Input

- [x] Receive car names and the number of rounds from the user
- [x] Car names are comma-separated and must be 5 characters or fewer

Game Rules

- [x] In each round, each car either moves forward or stays still
- [x] A car moves forward if a random number between 0 and 9 is greater than or equal to 4

Output

- [ ] For each round, display the car's name and its progress (as a series of -)
- [ ] After the race, display the final winner(s)
- [ ] If there are multiple winners, display all names separated by commas

Exception Handling

- [ ] If the user input is invalid, throw an IllegalArgumentException and terminate the program

#### 2. Implicit / Derived Constraints

Car Name Constraints

- [x] A car name cannot be blank or empty (Enforced in the Name value object)
- [x] Car names must be unique (Validated in RaceFactory)
- [x] The number of cars must be between 1 and 10 (Checked in RaceFactory)

Round Count Constraints

- [x] The number of rounds must be between 1 and 100 (Validated in both the Rounds value object and the factory)

Exception Messages

- [x] If any validation fails, an IllegalArgumentException must be thrown with a clear and descriptive error message
