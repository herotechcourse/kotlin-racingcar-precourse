# kotlin-racingcar-precourse

This project implements a simple car racing game written in Kotlin.

## Planned Features

1. **Input car names**
    - User enters car names separated by commas

2. **Validate car names**
    - Each name must be non-empty and no longer than 5 characters

3. **Input number of rounds**
    - User enters how many rounds will be played

4. **Validate number of rounds**
    - Must be a positive integer

5. **Car movement logic**
    - In each round, each car generates a random number between 0 and 9
    - If the number is 4 or greater, the car moves forward by one step

6. **Display race progress**
    - After each round, print each car’s name and its progress using `-`

7. **Determine winner(s)**
    - At the end of the game, find the car(s) with the furthest distance

8. **Display winner(s)**
    - Print the names of the winners (comma-separated if multiple)

9. **Handle invalid input**
    - If input is invalid, throw an `IllegalArgumentException` and terminate

## Tech Requirements

- Kotlin 1.9.24
- No external libraries or changes to `build.gradle.kts`
- Entry point must be `main()` in the `Application` class
- No use of `System.exit()` or `exitProcess()`

