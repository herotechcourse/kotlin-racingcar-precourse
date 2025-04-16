# kotlin-racingcar-precourse

## Feature Specification

### Domain Features

* [x] Each car must have a name, and names must not exceed 5 characters.
* [x] Car names must not be empty.
* [x] Car names must be unique.
* [x] A car can move only when the power condition is satisfied.
    * [x] The power is a random number between 0 and 9.
    * [x] The car moves forward if the power is 4 or greater.
* [x] The game must proceed for a given number of rounds.
    * [x] In each round, every car attempts to move once.
    * [x] The result of each round (car positions) must be recorded.
* [x] After all rounds, determine the winner(s).
    * [x] The winner is the car(s) that has moved the farthest.
    * [x] If there are multiple cars with the same farthest position, all are winners.

### Input/Output Features

* [x] If the user inputs invalid data, the program must throw an `IllegalArgumentException`.
    * [x] Input data cannot be empty.
* [x] Car names must be entered as a comma-separated list.
* [ ] When printing the progress of each car, the car's name must be displayed alongside its movement.
* [ ] After the race is complete, the winners must be displayed.
* [ ] If there are multiple winners, their names must be separated by commas.
