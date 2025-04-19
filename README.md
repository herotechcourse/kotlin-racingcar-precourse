# kotlin-racingcar-precourse

## Functional Requirements

### 1. Car Name Input
- Accept car names as a comma-separated string.
- Each name must be a 1–5 character string; spaces or empty strings are not allowed.
- Create car objects using the provided names.

### 2. Number of Rounds Input
- Accept only positive integers.
- Handle invalid inputs (non-numeric values, zero, or negative numbers) with exceptions.

### 3. Round Progression
- For each round, generate a random number between 0 and 9 for each car.
- If the random number is 4 or higher, the car moves forward; otherwise, it stays still.
- Display the result of each round:
  - Show the car name and its movement as dashes (e.g., `car1: ---`).

### 4. Final Winner Output
- Declare the car(s) that traveled the farthest as the winner(s).
- If there are multiple winners, list them separated by commas.

### 5. Exception Handling
- **Car Name Exceptions**:
  - Names shorter than 1 character or longer than 5 characters.
  - Duplicate names, spaces, or empty strings.
- **Round Number Exceptions**:
  - Non-numeric inputs.
  - Values less than or equal to zero.
- Throw an `IllegalArgumentException` for invalid inputs and terminate the program.

## Test Cases

1. **Name Input Exception Tests**:
   - Verify exceptions for names shorter than 1 character, longer than 5 characters, duplicates, spaces, or empty strings.
2. **Movement Condition Tests**:
   - Confirm that a car moves forward for random numbers 4 or higher and stays still for 3 or lower.
3. **Winner Calculation Tests**:
   - Ensure the car that traveled the farthest is selected as the winner.
4. **Joint Winner Tests**:
   - Verify that multiple cars with the same maximum movement are output as winners, separated by commas.