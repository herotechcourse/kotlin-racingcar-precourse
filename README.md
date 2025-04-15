# Kotlin Car Racing Game
This project is a simple command-line car racing simulator built in Kotlin as part of the Hero Tech Course pre-course weekly mission. It allows users to input car names and the number of rounds they will race for.

During each round, each car will generate a random number between 0 and 9:
- If the number is between 4 to 9, the car moves forward by one lap (graphically represented by a dash `-`).
- If the number is between 0 to 3, the car does not move during that round.

The progress of each car is displayed after each round, showing how many laps they have completed.
The car that has the longest string of dashes at the end of all rounds is declared the winner.
A race can have multiple winners if more than one car has the same number of dashes.

<br>
<br>

# Table of Contents

- [Required features](#required-features)
- [Technical Requirements](#technical-requirements)
- [Testing](#testing)

> **Note:**
> This README will be continuously updated as the project evolves and expands until submission.
> Documentation and test descriptions may be revised to reflect improvements and implementation details added during development.

<br>
<br>

# Required features

### 1. Input: handle car name input and validation.
Prompts the user to enter car names, which must be:
- Comma-separated.
- Non-empty.
- No longer than 5 characters.
- If the input is invalid (not comma separated, name longer than 5 characters, empty name, wrong format or or less than 2 car names), throws an `IllegalArgumentException` and terminates the program.

Prompted input example:
```
Enter the names of the cars:
pobi,woni,jun
```

### 2. Input: handle and validate number of rounds.
Prompts the user to enter the number of rounds, which must be:
- A valid integer.
- Greater than 0.
- If the input is invalid (empty, negative, non-numeric), throw an `IllegalArgumentException` and terminates the program.

Prompted input example:
```
How many rounds will be played?
2
```

### 3. Simulation: track car movements per round.
- For every round, each car will generate a random number between **0 and 9**:
	- If the number is **4 or greater**, the car moves forward by one lap (represented by a dash `-`).
	- If the number is less than 4, the car stays in place for that round.
- Movement is cumulative per car.

### 4. Output: print car progress.
- Tracks and prints the cars progress after each round:
```
Race Results:

pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

```


### 5. Output: print the winner.
- Once all rounds are terminated, the winner is printed based on which car moved the farthest.
```
Winners : pobi
```
- If multiple cars are tied with the same number of dashes, all of them are declared winners, separated by commas.
```
Winners : pobi, jun
```
[Move Back to Table of Contents](#table-of-contents)

<br>
<br>

# Technical Requirements

- Kotlin version: **1.9.24**
- Testing: **JUnit 5** and **AssertJ**

[Move Back to Table of Contents](#table-of-contents)

<br>
<br>

# Testing

Run the following command to verify that all tests pass:

For macOS/Linux:
```
./gradlew clean test
```

For Windows:
```
gradlew.bat clean test or .\gradlew.bat clean test
```
[Move Back to Table of Contents](#table-of-contents)