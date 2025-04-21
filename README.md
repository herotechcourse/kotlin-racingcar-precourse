# kotlin-racingcar-precourse

## List of features

### User Input: Car Names
- [x] Car names should be comma‑separated when entered by the user.
    - [x] Trim any leading or trailing whitespace around each name.
    - ex. `pobi,woni,jun`

- [x] If a name is missing or consists only of whitespace, throw
    - [x] If a name is missing or consists only of whitespace, throw `IllegalArgumentException` with message "Car name is missing."

- [x] Each car name cannot exceed 5 characters
    - [x]  If violated, throw `IllegalArgumentException` with message "Car name exceeds 5 characters."

- [x] Each car’s name must be immutable after creation.

- [ ] At least 2 car names must be provided.
    - [ ]  If fewer than 2 names are entered, throw IllegalArgumentException with message "Number of car names must be at least 2."

- [ ] Duplicate car names are not allowed.
    - [ ] Check for duplicates in a case‑insensitive manner.
    - [ ] If duplicates are found, throw IllegalArgumentException with message "Duplicate car names found."


### User Input: Number of Rounds
- [ ] The number of rounds must be numeric.
    - [ ] If the input is not a valid integer, throw IllegalArgumentException with message "Number of rounds is not a number."

- [ ] The number of rounds must be at least 1.
    - [ ]  If the value is less than 1, throw IllegalArgumentException with message "Number of rounds must be greater than 0."

### Racing Logic
- [ ] For each car and each round, generate a random integer between 0 and 9 (inclusive).
    - [ ] If the number is 4 or greater, the car moves forward one unit; otherwise, it stays still.

### Distance Tracking
- [ ] Compute and store each car’s cumulative distance traveled after each round.

### Determining the Winner(s)
- [ ] The car(s) with the greatest total distance after all rounds are the winner(s).

- [ ] If multiple cars share the top distance, they all win.

### Console Output: Prompts
- [ ]  Print the prompt for car names exactly as:
    - `Enter the names of the cars (comma-separated):`

- [ ]  Print the prompt for rounds exactly as:
    - `How many rounds will be played?`

### Console Output: Race Results
- [ ] After reading the inputs, print a blank line, then:
    - `Race Results`

- [ ] For each round, print each car’s name and its **cumulative distance** so far, using dashes `-` to represent distance:
    - `<car name> : <dashes equal to cumulative distance>`
    - [ ] Include a single space before and after the colon.
    - [ ] Insert a blank line between each round’s output block.

### Console Output: Winners
- [ ] After all rounds, print:
    - `Winners : <name1>[, <name2>, …]`
    - [ ] If multiple winners, separate their names with a comma and a space.
- [ ] List winners in the order their names were originally entered.


# Example Execution
```
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
