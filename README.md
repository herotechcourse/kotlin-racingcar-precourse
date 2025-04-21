# kotlin-racingcar-precourse

## Implementation Goals

- Satisfying the requirements thoroughly

- Designing a clean domain structure

- Focusing on responsibility segregation of modules

&nbsp;

## Domain

### 🏎️ Car

- [x] Name Property: name of a car (string, not blank, max length 5)

- [x] Position Property: current position of a car (int, 0 ~ positive, only modifiable by the move function & no other external modification available)

- [x] Move Function: add 1 to the current car's position when randomly generated number between 0 and 9 is equal to or greater than 4.

### 🏁 Racing Game

- [x] Play Round Function: move each car inside the current game

- [x] Find Winners Function: find cars that went the furthest during the game (there can be more than one)

&nbsp;

## View

### InputView

- [x] Read Car Names Function: read the names from user input

- [x] Validate Car Names Function: validate the car names (not blank, max length 5)

- [x] Read Round Number Function: read the round number from user input

- [x] Validate Round Number Function: validate the round number (positive integer only)

### ResultView

- [x] Print Round Function: print the progress of each participating cars with a certain move symbol("-")

- [x] Print Winners Function: print the winners separated with comma

&nbsp;

## Test

The existing test only has two test methods:

- Feature test for single winner

- Exception test for invalid car name input

other test scenarios should be added:

- [x] Feature test for multiple winners

- [x] Exception test for invalid round number input
