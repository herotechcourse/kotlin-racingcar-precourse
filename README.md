# Features

- Takes and validates car names

- Takes and validates number of rounds

- Moves cars based on random numbers

- Prints progress and winner(s)

- Includes error handling and basic tests

# Tech

- Kotlin

- Gradle

Planning / Pseudocode

Before starting implementation, I wrote a basic plan to understand the logic:

- Get car names and number of rounds from the user
- Validate names (comma-separated, max 5 characters)
- For each round:
  - Generate random number between 0 and 9
  - If number >= 4, move car
  - Else, car stays in place
- Print progress (dashes for movement)
- After rounds, determine winner(s)
- If input is invalid, throw IllegalArgumentException (tried to do it earlier)

