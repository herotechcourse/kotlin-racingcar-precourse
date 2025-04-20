# kotlin-racingcar-precourse

# Racing Car Game - Feature List

## ✅ Input

- [x] Enter car names
  - Input in a single line, separated by commas
  - Names must not contain spaces or be empty
  - Each name must be 5 characters or fewer
  - Invalid input throws `IllegalArgumentException`

- [x] Enter number of rounds
  - Input must be a numeric string
  - Parsed with `toInt()`, invalid input throws `NumberFormatException` (default behavior)

---

## ✅ Game Logic

- [x] Round management
  - Repeats for the number of rounds entered by the user
  - Each round generates one random number (0–9) per car

- [x] Car movement
  - If number is 0–3: car does not move
  - If number is 4–9: car moves forward by one step
  - Movement is managed through `Cars.moveCars(numbers: List<Int>)`

---

## ✅ Output & Results

- [x] Print round results
  - After each round, displays each car’s name and progress using `-` characters
  - Example: `pobi : --`

- [x] Determine final winners
  - After the final round, calculates which car(s) moved the farthest
  - Allows for multiple winners if there is a tie

- [x] Print winners
  - Always prints `Winners : name1, name2, ...`
  - Even if only one winner, consistent format used for testing compatibility
