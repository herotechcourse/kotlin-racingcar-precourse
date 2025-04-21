# kotlin-racingcar-precourse
## Racingcar Game

A simple racing car game implemented in an object-oriented way.  
The game takes car names and the number of moves as input and simulates a race to determine the winner(s).

---

## Features (Implementation Checklist)

### Domain

#### Car
- [x] Create a car object with a name
- [x] Determine if the car is movable using a number generator
- [x] Move the car forward if conditions are met
- [x] Check the car's current location (distance)
- [x] Return the name of the car

#### Cars
- [x] Hold a list of car objects participating in the race
- [x] Command each car to attempt movement
- [x] Return the list of participating car objects
- [x] Determine the maximum distance reached by any car

#### IntGenerator
- [x] Strategy interface for generating integers

#### RandomIntGenerator
- [x] Generate a random number between 0 and 9

---

### Game Logic

#### Racing
- [x] Record and track the number of move attempts (stages)
- [x] Determine whether the race continues based on remaining moves

#### RacingResult
- [x] Determine the winner(s) based on maximum distance
- [x] Return the name(s) of the winning car(s)

---

### Controller

#### RacingController
- [x] Control the overall race flow
- [x] Take user input, trigger car movements, and organize the game’s progression

---

### Input

#### InputView
- [x] Accept car names (comma-separated)
- [x] Accept the number of movement attempts

---

### Output

#### OutputView
- [x] Display a race start message
- [x] Output the result of each move (step-by-step)
- [x] Display the final winner(s)

---

### Validator

#### InputCarNamesValidator
- [x] Verify each car name is 5 characters or fewer
- [x] Ensure car names are not duplicated
- [x] Validate that no blank or empty names are present

#### InputCountValidator
- [x] Ensure the number of moves is a positive integer
- [x] Validate that the input is numeric
- [x] Check the data type range of the number
- [x] Verify that the input is not blank
