# kotlin-racingcar-precourse
## Feature List

- Accept user input for car names (comma-separated)
- Validate car names: non-empty, max 5 characters
- Accept user input for number of rounds
- Validate round count: must be a positive integer
- Represent each car with a name and position
- For each round, generate a random number (0–9) per car
- Move car forward if number is 4 or greater
- Display each car’s progress after every round
- Determine winner(s) based on final position
- Print winner(s), comma-separated if tied
- Throw `IllegalArgumentException` on invalid input
- Abstract random number generation for testability