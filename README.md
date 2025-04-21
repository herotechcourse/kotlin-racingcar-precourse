# kotlin-racingcar-precourse
## Functional Requirements
### Inputs
1. Prompt for car names (comma-separated)
2. Prompt for the number of rounds (use `Console.readLine()`)

### Outputs
1. Print race results for each round
2. Print the winner(s) of the race

### Car Movement
In each round, each car can either move forward or stay still.
- If a randomly generated number is 4 or greater, move forward
- Else stay

### Random Number Generation
- Use `Randoms.pickNumberInRange(0, 9)` to generate a number between 0 and 9.

### Winner Determination
- After all rounds are completed, determine the car(s) with the highest position.
- If there are multiple winners, display their names separated by commas.

### Validation
- Car names must be comma-separated.
- Each car must have a non-empty name.
- Car names must not exceed 5 characters.
- If invalid input is provided, throw an `IllegalArgumentException` and terminate the program.
