# kotlin-racingcar-precourse

## Input

### 1. Enter the name of the car.
- Enter using `Console.readLine()`.
- Names are separated by comma.
- Car name can be entered up to 5 characters.
- Car names cannot be duplicated.
  - Save in `Map` data structure - key(Car name) : value(Movement count)

#### Exception process
- When entering non-comma characters, the program throws `IllegalArgumentException` and terminate.

### 2. Enter the number of rounds.
- Enter using `Console.readLine()`.
- Only numbers can be entered.

#### Exception process
- When entering non-numerical characters, the program throws `IllegalArgumentException` and terminate.

## Output

### 1. Outputs the results of car races for each round.
- Each car goes through a round.
  - Use `Randoms.pickNumberInRange()` to generate one random number between 0 and 9.
  - The car has a) `MOVING_FORWARD` or b) `STOP` enum.
    1. When a random number between 0 and 9 is greater than 4
       - `MOVING_FORWARD` enum.
       - Increase value +1 when key matches current car name.
    2. When a random number between 0 and 9 is less than 4
       - `STOP` enum.
- The round is completed.
  - key(car name) : value(Movement count) output format.
  - but convert value into a '-' character.

### 2. At the end of all rounds, the winner is output.
- The winner is the car with the highest 'value' in the last round.
- If there are multiple winners, separate the car names with comma.
