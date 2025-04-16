# kotlin-racingcar-precourse

## Car Racing

> The Car Racing Game takes car names and the number of rounds as input from the user, proceeds with the race based on
> defined rules, and displays the winner at the end.
>

### 📌 Features Flow

- Accepts a comma-separated string of car names from the user.
- Accepts the number of rounds to run the race.
- The racing game runs for the given number of rounds.
- In each round, a car moves forward when the random number (0–9) is 4 or above.
- After all rounds, the car that moved the farthest is declared the winner.
- If there are multiple winners, their names are printed separated by commas.

### ✅ Feature List

- [x]  Receive car names input
- [ ]  Validate car name format (length, characters, duplicates)
- [ ]  Receive round count input
- [ ]  Validate round count
- [ ]  Run the race for the given number of rounds
- [ ]  Implement car movement logic (random number check)
- [ ]  Display the movement of each car after every round
- [ ]  Determine winner
- [ ]  Display winner

**validator**

- [x] check empty input
- [ ] check too many car names entered(100 or more)
- [ ] cheek car name length is not within 1–5 characters
- [ ] check car name contains characters other than English letters or digits
- [ ] check duplicate car names
- [ ] check number of rounds is not a valid positive integer

### ❌ Exceptions

If any of the following invalid inputs are entered, the program must throw an `IllegalArgumentException` and terminate:

- Car names
    - Empty input.
    - Car name is not within 1–5 characters.
    - Car name contains characters other than English letters or digits.
    - Duplicate car names are not allowed.
    - Too many car names entered(100 or more).
- Number of rounds
    - Empty input.
    - Number of rounds is not a valid positive integer.

