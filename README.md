# kotlin-racingcar-precourse

## Features

### 1. Input 
- Read car names and number of rounds from user input.
- Validate inputs (car name length ≤ 5, no empty values, valid round count).
- Throw `IllegalArgumentException` for invalid inputs.
- Includes unit tests for invalid and valid scenarios.

### 2. Car 
- Implements `Car` class with `name` and `position` fields.
- Includes movement logic based on a random number threshold.
- Includes unit tests for movement logic.

### 3. Random Number Generator  
- Create `NumberGenerator` interface.
- Provide a default implementation using `Randoms.pickNumberInRange()`.

### 4. Race 
- Implements race coordination over N rounds.
- Uses list of cars and `NumberGenerator` to move them.
- Calculates winners.
- Includes unit tests for race simulation and winner detection.

### 5. Game
- Main entry point of the game.
- Coordinates input, race progression, and output display.
- Includes unit tests with mocked input/output.

### 6. Output  
- Displays race progress and winner(s) to console.
- Clean formatting of results for clarity.







