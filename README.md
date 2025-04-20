# kotlin-racingcar-precourse

## Input

### 1. Enter the name of the car.

- Enter using `Console.readLine()`.
- Names are separated by comma.
- Car name can be entered up to 5 characters.
- Car names cannot be duplicated.
    - Car data class
    - Save in `Set` data structure

#### Exception process

- When the car name length exceeds 5 characters or empty or blank, the program
  throws `IllegalArgumentException` and terminate.

### 2. Enter the number of rounds.

- Enter using `Console.readLine()`.
- Only numbers can be entered.

#### Exception process

- When entering non-numerical characters, the program throws `IllegalArgumentException` and
  terminate.

## Car

### 1. Moving forward or Stop.

- Use `Randoms.pickNumberInRange()` to generate one random number between 0 and 9.

1. When a random number between 0 and 9 is 4 or more
    - Increase movementCount +1.
2. When a random number between 0 and 9 is less than 4
    - No change.

## Round

### 1. Get Winners.

- The winners are the cars with the most movementCount.

## Output

### 1. Outputs the results of car races for each round.

- 'car name : Movement count' output format.
- but convert movementCount into a '-' character.

### 2. At the end of all rounds, the winner is output.

- If there are multiple winners, separate the car names with comma.
