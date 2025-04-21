# kotlin-racingcar-precourse

## Feature List

- **Input Validation**
    - `checkForInvalidInput`: Only letters and max 5 characters control
    - `checkForValidRounds`: Only integers bigger than 0 and no strings

- **Race execution**:
  -  `carMovement`: implement car movement
  -  `raceResults`: print the race results
  -  `raceWinners`: print the race winners

## Observation

1. Because one of the requirements is to not modify build.gradle.kts, I cannot implement individual unit tests, by using mocks.
2. I haven't created model classes, because they are not necessary for this project and it will introduce unnecessary complexity, car could be a model but it will have a single member: name
