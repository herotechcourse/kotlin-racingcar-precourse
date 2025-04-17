# kotlin-racingcar-precourse

so far ...
##  Features Implemented

- Input car names from user
    - Comma-separated string
    - Each name must be 5 characters or fewer
    - At least 2 cars are required to start the game
    - It can't be empty

- Input number of rounds
    - Must be a positive integer
    - Must not be 0 or negative number

- Car racing logic
    - For each round, generate a random number between 0 and 9
    - Car moves forward if the number is 4 or greater
    - Use "-" to visualize car movement
    - _**TODO: refactoring, Maximum indentation depth of 2**_

- Calculate and display winners
    - Cars with the maximum position are declared winners
    - Output format: `Winners : pobi, jun`

## Programming Requirements Followed

- Kotlin version 1.9.24
- No use `System.exit()` or `exitProcess()`
- _**TODO: Maximum indentation depth of 2**_
- Separated logic into small, single-responsibility functions
- Used only `Randoms` and `Console` from `camp.nextstep.edu.missionutils`
- _**TODO: Testing with JUnit 5 and AssertJ to be added**_

## Notes

- TODO: Refactoring - Maximum indentation depth of 2
- TODO: Testing with JUnit 5 and AssertJ to be added
Planning to refactor the logic using an OOP approach (e.g., Car class)
