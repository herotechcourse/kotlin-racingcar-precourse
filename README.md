# kotlin-racingcar-precourse

### Features to be Implemented

1. Input Handling

Handle user input for car names and number of rounds, ensuring validation for invalid data (e.g., empty names, names exceeding 5 characters, or invalid rounds).

If the user inputs invalid data (e.g., empty car names, names exceeding 5 characters, or invalid rounds), the program should throw an `IllegalArgumentException` and terminate.

#### Checklist for Input Handling
- [x] Validate car names:
  - [x] Ensure names are non-empty.
  - [x] Ensure names do not exceed 5 characters.
  - [x] Handle multiple names separated by commas.
- [x] Validate number of rounds:
  - [x] Ensure input is a valid integer.
  - [x] Ensure the number of rounds is greater than 0.
- [x] Throw `IllegalArgumentException` for invalid input.

2. Car Movement Logic

Implement car movement logic where each car moves forward if a randomly generated number between 0 and 9 is 4 or greater.

#### Checklist for Car Movement Logic
- [x] Define a `Car` class with `name` and `position` attributes.
- [x] Implement the `move` method in the `Car` class to update the position if the random number is 4 or greater.
- [x] Create a `RandomNumberGenerator` interface to abstract random number generation.
- [x] Implement the `DefaultRandomNumberGenerator` class using `Randoms.pickNumberInRange`.
- [x] Implement the `simulateRace` function to handle multiple rounds of car movement.
- [x] Implement the `moveCars` function to move all cars in a single round.
- [x] Write unit tests for the `simulateRace` function using a mock random number generator.

3. Progress Display

Display the progress of each car, showing the car's name alongside its movement.
#### Checklist for Progress Display
- [x] Implement the `displayProgress` function to print each car's name and progress.
- [x] Integrate `displayProgress` into the `simulateRace` function to display progress after each round.
- [x] Write unit tests to verify the output of the `displayProgress` function.
- [x] Write unit tests to verify the per-round progress display in the `simulateRace` function.

4. Determine and Display Winners

Determine the winners after the race and display their names. If there are multiple winners, their names should be separated by commas.

---

### Key Points

- **Validation**:
  - Car names must be non-empty, comma separated and cannot exceed 5 characters.
  - The number of rounds must be a valid integer.

- **Random Movement**:
  - Each car's movement is determined by a random number between 0 and 9.
  - Cars move forward if the random number is 4 or greater.

- **Dynamic Winners**:
  - The car(s) with the maximum position after all rounds are declared winners.
  - If multiple cars have the same maximum position, they are all declared winners.

- **Error Handling**:
  - Invalid input (e.g., empty car names, names exceeding 5 characters, or non-integer rounds) results in an `IllegalArgumentException` and program termination.

---