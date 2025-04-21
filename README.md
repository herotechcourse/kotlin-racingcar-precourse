# kotlin-racingcar-precourse

### Game Setup Features

**Car name input**

- Users can input multiple car names separated by commas.
- Each car name must be non-empty and no longer than 5 characters.
- Whitespace around names is trimmed during parsing.
- Duplicate names are not allowed.
- Invalid input immediately throws an `IllegalArgumentException` and terminates the program.

**Number of rounds input**

- Users input the number of race rounds as a positive integer.
- The value must be a numeric string and ≥ 1.
- Invalid input immediately throws an `IllegalArgumentException` and terminates the program.

**Input validation module**

- Centralized validator to check car name format and round input constraints.
- Isolated from input/output logic to ensure reusability and single responsibility.

---

### Core Game Features

**Single round execution**

- Each round, every car attempts to move forward.
- A car moves forward if a randomly generated number between 0 and 9 is greater than or equal to 4.
- Each round’s logic is isolated in a single method or class to support unit testing.

**Multiple rounds execution**

- The race runs for a number of rounds specified by the user.
- Cars progress independently across rounds.
- The loop that manages round progression is separated from car movement logic.

**Car movement logic**

- Random number generation logic is abstracted to a utility or strategy class.
- The movement rule (threshold ≥ 4) is encapsulated in a `canMove` method.

**Car domain model**

- Each car has a name and a current position.
- The car object is responsible for updating its position when allowed to move.
- The position is internally tracked and can be retrieved for display or ranking.

---

### Output Features

**Per-round car status display**

- After each round, each car’s name and movement history are printed.
- Movement is visualized using a sequence of hyphens (`-`) equal to the car's current position.
- Example format: `chevy : ---`

**Winner determination**

- After the final round, the car(s) with the maximum distance are declared winners.
- If multiple cars share the same distance, all are listed as winners.

**Winner display**

- The final winners are printed in a single line, separated by commas.
- Example format: `Winner(s): ford, bmw`

---

### Utility Features

**Random number generator abstraction**

- Random number generation is decoupled from car movement logic.
- Allows mocking or injecting fixed values for deterministic unit tests.

**Game controller class**

- Orchestrates the overall race: input reading, round progression, status printing, and final result display.
- Does not directly handle business logic like movement or output formatting.

**Output formatting module**

- Responsible for constructing printable strings for car positions and winner names.
- Keeps UI logic separate from game logic.

**Exception handling**

- All invalid inputs result in `IllegalArgumentException` with meaningful error messages.
- Exceptions are not silently caught; program exits on failure as per spec.
.