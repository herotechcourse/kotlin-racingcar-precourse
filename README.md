# kotlin-racingcar-precourse

## Implementation Feature List
- [x] Car name validation
    - [x] (Exception) If longer than 5 characters
    - [x] (Exception) If no input is given
    - [x] Remove whitespace on both sides of the name

- [x] Number of movements
    - [x] (Exception) If not an integer

- [x] Random movement value
    - [x] Create a map of car and movement counts
    - [x] Move if 4 or more
    - [x] Output execution result

- [x] Final winner(s)
    - [x] Include comma separated winners if any

- [x] Depth 2 or less
- [x] Code is fully tested



## Tests
### `CarTestSimple`

* Verifies car moves forward if increment is 4 or more.
* Checks car stays in place if increment is less than 4.
* Ensures car display shows name and position correctly.

### `CarRaceTestSimple`

* Tests `getWinners` returns single winner correctly.
* Verifies `getWinners` returns multiple winners correctly.
* Confirms `getWinners` returns a single winner even with more rounds simulated.
* Checks initial `carMoves` map is correctly initialized.

### `CarNameValidationTest`

* Ensures car creation throws `IllegalArgumentException` for names exceeding 5 characters.
* Verifies car creation allows names with 5 characters or less.