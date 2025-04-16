# Feature List

- [ ] Implement a simple car racing game

- [ ] The user should be able to specify car names and the number of rounds.
  - [x] Car names should be comma-separated when entered by the user.
  - [x] Each car must have a name
  - [x] names cannot exceed 5 characters.
- [ ] Each of the n cars can either move forward or stay still during a given number of rounds.
  - [x] A car can move forward.
- [ ] A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
- [ ] When printing the progress of each car, display the car's name alongside its movement.
- [ ] After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
  - [ ] If there are multiple winners, their names should be displayed and separated by commas.
- [ ] If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.

## Input

- [x] Names of the cars (comma-separated):
```kotlin
pobi,woni,jun
```

- [x] Number of rounds:
```kotlin
5
```
## Output

- [x] Print prompt to enter car names (comma-separated)
```kotlin
Enter the names of the cars (comma-separated):
```

- [x] Print prompt to enter number of rounds
```kotlin
How many rounds will be played?
```

- [ ] Race results by round:
```kotlin
pobi : --
woni : ----
jun : ---
```

- [ ] Message for a single winner:
```kotlin
Winners : pobi
```

- [ ] Message for multiple winners:
```kotlin
Winners : pobi, jun
```

## Example Execution

```kotlin
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




