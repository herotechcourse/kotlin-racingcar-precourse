# kotlin-racingcar-precourse

## Feature List 

1. **Input Car Names**
    * Accept comma-separated car names from user
    * Validate that each name is 1-5 characters long
    * Throw IllegalArgumentException for invalid names

1. **Input Number of Rounds**
    * Accept the number of rounds to race
    * Validate that it's a positive integer
    * Throw IllegalArgumentException for invalid input

1. **Race Simulation**
    * For each round, determine if each car moves forward (random number ≥ 4)
    * Track each car's position
    * Display progress after each round

1. **Determine Winners**
    * After all rounds, find car(s) with the highest position
    * Display winner(s), comma-separated if multiple

1. **Output Format**
    * Show round-by-round progress with car names and positions
    * Clearly announce the winner(s)
1. **Add Test validation and race logic**
