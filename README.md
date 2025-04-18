# kotlin-racingcar-precourse

## Feature List

### Input Handling
- Accept user input for car names (comma-separated)
- Accept user input for number of race rounds
- Validate car names (non-empty, max 5 characters)
- Validate number of rounds (positive integer)

### Game Logic
- Initialize cars with starting positions
- Generate random numbers to determine car movement
- Move cars forward based on random number rules (≥ 4 moves forward)
- Track car positions throughout all rounds

### Output Display
- Display race progress after each round
- Format car position visualization with names and dashes
- Determine winner(s) based on final positions
- Display the winner(s) at the end of the race

### Exception Handling
- Handle invalid input formats with appropriate error messages
- Throw IllegalArgumentException for invalid inputs