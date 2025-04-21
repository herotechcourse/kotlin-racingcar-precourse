# kotlin-racingcar-precourse

## Feature Specification

### Domain Features

| Feature                                                                                                | Status |
|--------------------------------------------------------------------------------------------------------|--------|
| Each car must have a name, and names must not exceed 5 characters.                                     | ✅      |
| Car names must not be empty.                                                                           | ✅      |
| Car names must be unique.                                                                              | ✅      |
| A car can move only when the power condition is satisfied.                                             | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– The power is a random number between 0 and 9.                                | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– The car moves forward if the power is 4 or greater.                          | ✅      |
| The game must proceed for a given number of rounds.                                                    | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– In each round, every car attempts to move once.                              | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– The result of each round (car positions) must be recorded.                   | ✅      |
| After all rounds, determine the winner(s).                                                             | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– The winner is the car(s) that has moved the farthest.                        | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– If there are multiple cars with the same farthest position, all are winners. | ✅      |

---

### Input/Output Features

| Feature                                                                                          | Status |
|--------------------------------------------------------------------------------------------------|--------|
| If the user inputs invalid data, the program must throw an `IllegalArgumentException`.           | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– Input data cannot be empty.                                            | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– Only one number of rounds can be entered.                              | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– The round number input should be larger than zero.                     | ✅      |
| &nbsp;&nbsp;&nbsp;&nbsp;– The round number input must be numeric.                                | ✅      |
| Car names must be entered as a comma-separated list.                                             | ✅      |
| When printing the progress of each car, the car's name must be displayed alongside its movement. | ✅      |
| After the race is complete, the winners must be displayed.                                       | ✅      |
| If there are multiple winners, their names must be separated by commas.                          | ✅      |

### Commit Scopes Convention

To make it easier to trace commits and match them with the feature specification, the following scope conventions are
used in commit messages:

| Scope    | Description                                                                                                |
|----------|------------------------------------------------------------------------------------------------------------|
| `domain` | Changes related to core business logic and domain rules (e.g. race rules, car behavior, round processing). |
| `input`  | Parsing and validation of user inputs (e.g. car names, round count).                                       |
| `output` | Printing the game progress and results (e.g. car positions, winners).                                      |
| `readme` | Updates to documentation files such as `README.md` or spec clarifications.                                 |

#### Example:

```bash
feat(domain): add race progression logic

feat(input): add reading car names features

docs(readme): add input constraints
```
