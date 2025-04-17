# kotlin-racingcar-precourse

## Planned Features
1. Input Handling
- Receive car names from the user (comma-separated)
- Validate car names (1 to 5 characters, no empty or blank strings)
- Receive number of rounds from the user (must be a positive integer)
- Throw `IllegalArgumentException` and terminate the program on invalid input

2. Round logic (Race)
- Create `Car` class
- Repeat the game for the number of rounds specified
- In each round, generate a random number (0–9) for each car
- If the number is 4 or higher, move the car forward by one position
- Store the result of each round for output

3. Output Processing
- Display each car’s name and current position using dashes (e.g., car1 : ---)
- After the race ends, determine the winner(s) based on the furthest distance
- If there are multiple winners, display all names separated by commas
- If there is no winner, display "No winner". 

## Domain Model
- `Application.kt`
- `Car.ks`
- `RaceRule.kt`
- `Race,kt`
- `InputValidation.kt`

## Test Coverage

## Development Considerations

---

## Game Rules

## Example Execution

```angular2html
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

Race Results
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Winners : pobi, jun
```

