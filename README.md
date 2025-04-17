## kotlin-racingcar-precourse

### Overview

This is a simple Kotlin-based racing car game where players can input car names and the number of rounds. The game simulates a race and displays the winner(s) based on the position of the cars at the end of the race

### Features

#### Car name input & validation

- Accepts comma-separated car names from the player
- Validates if names are not empty, not too long (max 5 chars), and are unique.

---

#### Rounds number input & validation

- Accepts number of race rounds
- Validates if the input is a number and ≥ 1

---

#### Car Class

- Represents each car with a name and position
- Each car moves forward if a randomly generated number between 0 and 9 (inclusive) is greater than or equal to 4
- Getting the car's position

---

#### Game Class

- Starts the game and loops over the number of rounds
- Moves each car and displays progress per round
- Determines the car(s) with the maximum position after all rounds

---

#### Output Formatter

- Displays each round's result visually using dashes (`----`)
- Shows the final winner(s) after all rounds

---

#### Clean Code Practices

- Used Kotlin conventions
- Separation of concerns. Logic is divided into clear classes: `Car`, `Game`, and objects: `InputValidator`, `OutputFormatter`