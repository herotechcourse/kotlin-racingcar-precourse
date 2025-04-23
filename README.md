# kotlin-racingcar-precourse
# Feature List

## Car Creation
- [x] Receive car names from the user, separated by commas (`,`)
- [x] Each car name must be between 1 and 5 characters
- [x] Throw an exception if the input is invalid

## Number of Attempts Input
- [x] Receive the number of race attempts from the user as an integer
- [x] Throw an exception if the input is not a number

## Car Movement
- [x] Each car receives a random number between 0 and 9 in each round
- [x] A car moves forward if the number is 4 or higher
- [x] In one round, all cars move based on their random number

## Progress Output
- [x] After each round, print the progress of each car
  (Example: `pobi: --`, `woni: ---`, `jun: -`)

## Winner Output
- [x] Print the car(s) that have moved the farthest as the winner(s)
- [x] If there are multiple winners, print all names separated by commas
  (Example: `Winner(s): pobi, woni`)

## Exception Handling
- [x] Throw an exception if a car name is longer than 5 characters or is empty
- [x] Throw an exception if the input for number of attempts is not a valid number

## Program Flow
- [x] The program must start from the `main()` function in `Application.kt`
- [x] The flow should follow: `InputView → Controller → Domain → ResultView`
