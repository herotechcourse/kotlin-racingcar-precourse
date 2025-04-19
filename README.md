# kotlin-racingcar-precourse



### Planned Features

- [x] Validate car names and num of rounds
- [x] Create Data class for Car Object and necessary functions
- [x] Simulate the race over N rounds
- [x] Create helper Classes for utility functions like (Parsing Input , Printing Results , Randoms)
- [x] Display car progress after each round
- [x] Determine the winners and handle it inside game class
- [x] Display the winners at the end
- [x] Handle invalid inputs with clear errors

---
###  `Application.kt` - Main Entry Point

**Role:** Entry point of the game. Handles input/output and coordinates game setup and execution.

**Key Responsibilities:**
- Reads car names and number of rounds from the user
- Parses and validates input
- Starts the race via the `Game` class
- Displays the final winners

---


###  `Car.kt` - Car Model

**Role:** A data class representing each car with two attributes (name , currLevel).

**Key Responsibilities:**
- Stores the car’s name and current position (`currLevel`)
- Determines movement based on a random number (≥ 4)
- Returns progress as a string of `-` characters for display (I could have overwritten the `toString` method but then it will lose its meaning so i decided to create separate function for it )

---

###  `Game.kt` - Game Logic

**Role:** Core domain logic that manages the race process.

**Key Responsibilities:**
- Runs the game for the user-specified number of rounds
- Moves all cars in each round using `tryMove()`
- Collects and prints round results
- Determines the winners based on max position


---

###  `Parser.kt` - Input Parser

**Role:** Validates and converts raw user input into `Car` objects.

**Key Responsibilities:**
- Splits input string by commas
- Trims and validates each car name:
  - Must not be empty
  - Max length of 5 characters
- Returns a list of `Car` objects
- Keeps validation logic out of the main logic

---

###  `Printer.kt` - Output Formatter

**Role:** Handles all console output related to game status and results.

**Key Responsibilities:**
- `printRound()` prints all cars’ progress for each round
- `printWinners()` displays the final winners in the required format

---

### `Utils.kt` - Random Number Generator

**Role:** Provides a helper method to generate random numbers (0–9) using the mission's library.

**Key Responsibilities:**
- Wraps `Randoms.pickNumberInRange(0, 9)` in a utility function
- Used by the `Car` class for movement logic


---

### `ErrorMessages.kt` - Error Constants

**Role:** Defines reusable and consistent error messages for validation.

**Key Responsibilities:**
- Stores error constants for:
  - Empty car name
  - Car name too long
  - Invalid number of rounds
- Makes validation messages easy to maintain and modify later.

---


##  What I Focused On

Throughout this project, I paid close attention to the following areas:

###  Clean Code Principles
- Applied the **Single Responsibility Principle (SRP)** by separating concerns across distinct classes and packages.
- Used **clear, meaningful names** for variables, functions, and files to make the code self explained itself.
- Maintained a **maximum of 2 indentation levels** as required, and ensured each function had one focused purpose.

###  Modular Architecture
- Followed a **layered architecture** to isolate core logic, UI handling, parsing, validation, and output formatting.
- Organized code into logical packages (`core`, `model`, `parser`, `utils`) to enhance readability and maintainability.


###  Commit Best Practices
- Followed the **AngularJS commit message conventions** for clarity.
- Made small, feature-focused commits to reflect the development process transparently.
