# kotlin-racingcar-precourse

## Feature Specification

### Domain Features

* [x] Each car must have a name, and names must not exceed 5 characters.
* [x] Car names must not be empty.
* [ ] Car names must be unique.
* [ ] A car must move forward if a random number (0~9) is 4 or greater.
* [ ] Each car must attempt to move in every round.
* [ ] The result of each round must be recorded.

### Input/Output Features

* [ ] If the user inputs invalid data, the program must throw an `IllegalArgumentException`.
* [ ] Car names must be entered as a comma-separated list.
* [ ] When printing the progress of each car, the car's name must be displayed alongside its movement.
* [ ] After the race is complete, the winners must be displayed.
* [ ] If there are multiple winners, their names must be separated by commas.
