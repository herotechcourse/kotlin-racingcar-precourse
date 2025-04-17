# Feature Checklist

## Core Feature

- [x] Implement a simple car racing game

## Car Movement Requirements

- [x] Each of the n cars can either move forward or stay still during a given number of rounds.
  - [x] A car can move forward.
  - [x] Cars can move forward based on a given condition.
  - [x] Cars move forward repeatedly for the given number of rounds.

- [x] A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
  - [x] Can generate a number between 0 and 9.
  - [x] RacePolicy determines if a car can move based on the number.

## Input Requirements

- [x] The user should be able to specify car names and the number of rounds.
  - [x] Car names should be comma-separated when entered by the user.
  - [x] Each car must have a name.
  - [x] Names cannot exceed 5 characters.
  - [x] Round count must be a numeric input and be parsed correctly.

- [x] Names of the cars (comma-separated):
```text
pobi,woni,jun
```

- [x] Number of rounds:
```text
5
```

## Output Requirements

- [x] When printing the progress of each car, display the car's name alongside its movement.
- [x] After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
  - [x] If there are multiple winners, their names should be displayed and separated by commas.
  - [x] Can determine winners based on highest position.

- [x] Print prompt to enter car names (comma-separated):
```text
Enter the names of the cars (comma-separated):
```

- [x] Print prompt to enter number of rounds:
```text
How many rounds will be played?
```

- [x] Print prompt Race Results:
```text
Race Results
```

- [x] Race results by round:
```text
pobi : --
woni : ----
jun : ---
```

- [x] Message for a single winner:
```text
Winners : pobi
```

- [x] Message for multiple winners:
```text
Winners : pobi, jun
```

## Exception Handling

- [x] If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.
  - [x] [ERROR] Names of the cars must be comma-separated
  - [x] [ERROR] Car name cannot be blank
  - [x] [ERROR] Car Name cannot exceed 5 characters.
  - [x] [ERROR] Round must be a number.
  - [x] [ERROR] No cars available to determine winner.

## Example Execution

```text
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

