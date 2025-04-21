# kotlin-racingcar-precourse

This is a simple command-line car racing game built in Kotlin as part of a pre-course mission.  
The project aims to simulate a race between user-named cars over a number of rounds, using basic logic and random behavior.

---

## Features

- [X] Ask the user for car names
- [X] Validate the input (comma-separated and max 5 characters per name)
- [X] Ask the user for the number of rounds
- [X] Simulate each round using a loop
- [X] Use random numbers to determine car movement
- [X] Track and update car positions
- [X] Display car positions at the end of each round
- [X] Show the winner(s) at the end of the game
---

##  Commit Strategy

All commits follow the [Conventional Commit](https://www.conventionalcommits.org/en/v1.0.0/) format:

Examples:
- `feat: add Car class with name validation`
- `fix: handle empty input edge case`
- `docs: update README with feature list`

---

##  How to Run 

To run the program from the command line, use:

```
./gradlew run
```
You will be prompted to enter car names and the number of rounds.

Example:

Enter the names of the cars (comma-separated):
```
pobi,woni,jun
```
How many rounds will be played?
```
5
```
Make sure Kotlin and Gradle are properly set up in your environment.


---

##  How to Test 



To run the tests, open a terminal in the project root and run the following command:
```
./gradlew clean test
```
If all tests pass, you should see the message:
```
BUILD SUCCESSFUL
```

---

##  Notes

- The project is written in Kotlin 1.9.24 and follows Kotlin coding conventions.
- All commits follow the Conventional Commit format.
- The program uses only the provided camp.nextstep.edu.missionutils library for input and random number generation.
- All features are tested using JUnit 5 and AssertJ.
- No external libraries or dependencies were added.
- This was my first experience working with Gradle and setting up JAVA_HOME on macOS, which was a bit challenging at first.
- Writing tests using AssertJ was also a new and valuable learning experience.
- This README file will be updated as the project evolves.