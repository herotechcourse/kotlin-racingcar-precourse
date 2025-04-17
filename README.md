# Racing Car Game🏁

A simple racing game built in Kotlin for the Woowa Hero Tech Academy pre-course mission #1.

## Game Description

Each car competes in a race over multiple rounds. A car moves forward by one position if a randomly generated number between 0 and 9 is **4 or greater**. After all rounds are completed, the car(s) that moved the furthest are declared winners.

The game is text-based and runs in the console. You'll be asked to:

1. Enter the car names (comma-separated, max 5 characters each).
2. Enter the number of rounds to play.

Example input:
```
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5
```

Example output:
```
Race Results
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

...

Winners : pobi, jun
```

## Feature Plan

- Read car names from user input
- Validate that each name is 1–5 characters
- Read number of rounds from user input
- Validate that the round count is a positive integer
- Represent each car with a name and position
- Move a car forward if random number (0–9) is 4 or higher
- Repeat the game for the given number of rounds
- Print each car's progress after each round
- Determine the winner(s) after the race
- Print winner(s) separated by commas
- Throw `IllegalArgumentException` for invalid input

## How to Run

1. Make sure Kotlin 1.9.24 and Gradle are set up.
2. Run the program using:
```
./gradlew run
```

3. To test it:
```
./gradlew test
```