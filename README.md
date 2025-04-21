# kotlin-racingcar-precourse
## Feature List

- **Input Validation**
    - `validateCarNames`: Empty Input and max 5 characters control
    - `validateRounds`: Positive Integer Control

- **Domain Logic**
    - `Car` class: `move(randomValue: Int)`
    - `RacingGame` class:
        - `playRound()` Random move in every round
        - `getWinners()` Determine winners 

- **User Interaction**
    - `Application.kt`:
        - Read car names and number of rounds from console
        - Print every round results in “pobi : -” format
        - Print winners in “Winners : …” format

- **Testing**
    - JUnit5 + with AssertJ:
        - `CarTest`
        - `RacingGameTest`
        - `ApplicationTest`
