# kotlin-racingcar-precourse

### Features to be Implemented

1. Input Handling

Handle user input for car names and number of rounds, ensuring validation for invalid data (e.g., empty names, names exceeding 5 characters, or invalid rounds).

If the user inputs invalid data (e.g., empty car names, names exceeding 5 characters, or invalid rounds), the program should throw an `IllegalArgumentException` and terminate.

2. Car Movement Logic

Implement car movement logic where each car moves forward if a randomly generated number between 0 and 9 is 4 or greater.

3. Progress Display

Display the progress of each car, showing the car's name alongside its movement.

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