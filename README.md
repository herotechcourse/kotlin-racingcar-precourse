# kotlin-racingcar-precourse
## Racingcar Game

A simple racing car game implemented in an object-oriented way.  
The game takes car names and the number of moves as input and simulates a race to determine the winner(s).

---

## Features (Implementation Checklist)

### Domain

#### Car
- [ ] Create a car object with a name
- [ ] Determine if the car is movable using a number generator
- [ ] Move the car forward if conditions are met
- [ ] Check the car's current location (distance)
- [ ] Return the name of the car

#### Cars
- [ ] Hold a list of car objects participating in the race
- [ ] Command each car to attempt movement
- [ ] Return the list of participating car objects
- [ ] Determine the maximum distance reached by any car

#### IntGenerator
- [ ] Strategy interface for generating integers

#### RandomIntGenerator
- [ ] Generate a random number between 0 and 9

---

### Game Logic

#### Racing
- [ ] Record and track the number of move attempts (stages)
- [ ] Determine whether the race continues based on remaining moves

#### RacingResult
- [ ] Determine the winner(s) based on maximum distance
- [ ] Return the name(s) of the winning car(s)

---

### Controller

#### RacingController
- [ ] Control the overall race flow
- [ ] Take user input, trigger car movements, and organize the game’s progression

---

### Input

#### InputView
- [ ] Accept car names (comma-separated)
- [ ] Accept the number of movement attempts

---

### Output

#### OutputView
- [ ] Display a race start message
- [ ] Output the result of each move (step-by-step)
- [ ] Display the final winner(s)

---

### Validator

#### InputCarNamesValidator
- [ ] Verify each car name is 5 characters or fewer
- [ ] Ensure car names are not duplicated
- [ ] Validate that no blank or empty names are present

#### InputCountValidator
- [ ] Ensure the number of moves is a positive integer
- [ ] Validate that the input is numeric
- [ ] Check the data type range of the number
- [ ] Verify that the input is not blank
