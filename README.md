# kotlin-racingcar-precourse

## Features Implemented

### 1. Car Names Input:
- Implemented a feature where the user can input comma-separated car names.
- Each car name must not exceed 5 characters.

### 2. Number of Rounds Input:
- Added a prompt for the user to enter the number of rounds for the race.

### 3. Random Car Movement:
- Cars randomly move forward or stay still based on a number picked between 0 and 9.
- If the number is 4 or higher, the car moves forward by one unit.

### 4. Displaying Race Results:
- At the end of each round, the progress of each car is printed (e.g., carName : ----).
- The cars that move forward are represented by a hyphen, while others stay empty.

### 5. Determining Winners:
- After all rounds, the car with the maximum number of hyphens are declared the winner(s).
- If there are multiple winners, their names are displayed separated by commas.

### 6. Input Validation:
- Added validation to check that the car names don't exceed 5 characters.
- Handled invalid input by throwing an `IllegalArgumentException`.

