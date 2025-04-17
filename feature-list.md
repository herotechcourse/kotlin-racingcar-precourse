# Feature List

## Car Creation
- [ ] Receive car names from the user, separated by commas (`,`)
- [ ] Each car name must be between 1 and 5 characters
- [ ] Throw an exception if the input is invalid

## Number of Attempts Input
- [ ] Receive the number of race attempts from the user as an integer
- [ ] Throw an exception if the input is not a number

## Car Movement
- [ ] Each car receives a random number between 0 and 9 in each round
- [ ] A car moves forward if the number is 4 or higher
- [ ] In one round, all cars move based on their random number

## Progress Output
- [ ] After each round, print the progress of each car
  (Example: `pobi: --`, `woni: ---`, `jun: -`)

## Winner Output
- [ ] Print the car(s) that have moved the farthest as the winner(s)
- [ ] If there are multiple winners, print all names separated by commas
  (Example: `Winner(s): pobi, woni`)

## Exception Handling
- [ ] Throw an exception if a car name is longer than 5 characters or is empty
- [ ] Throw an exception if the input for number of attempts is not a valid number

## Program Flow
- [ ] The program must start from the `main()` function in `Application.kt`
- [ ] The flow should follow: `InputView → Controller → Domain → ResultView`
