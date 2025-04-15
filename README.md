# kotlin-racingcar-precourse

## Features to Implement

The following features are planned for implementation in this racing car game:

### 1. Input Handling

* **Car Name Input:** Implement functionality to receive comma-separated car names from the user.
* **Round Count Input:** Implement functionality to receive the total number of rounds for the race.
* **Input Validation:** Implement robust validation for all user inputs. Throw an `IllegalArgumentException` for invalid cases, such as:
    * Empty car names.
    * Car names exceeding a defined length limit(5).
    * Duplicate car names.
    * Non-positive or non-numeric round count input.

### 2. Game Logic

* **Random Movement:** Implement the core logic for car movement. For each car in each round, generate a random number (0-9). If the number meets a specific threshold (4 or greater), the car moves forward one step.
* **Round Progression Output:** Implement functionality to display the current position of all cars at the end of each round.
* **Winner Determination:** Implement logic to identify the car(s) that have moved the farthest at the end of all rounds. There can be multiple winners if they share the maximum distance.

### 3. Output

* **Final Winner(s) Display:** Implement functionality to clearly display the name(s) of the final winner(s) after the race concludes.