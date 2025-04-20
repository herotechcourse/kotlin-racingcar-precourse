## Project Definition
Implement a simple car racing game.

---
## Feature Requirements
### Input data
- [x] The user can input car names.  
  - [x] Car names are separated by commas.  
  - [x] Each car must have a name, and the name must not exceed 5 characters.  
- [x] The user can input the number of rounds.

### Output data
- [x] After each round, print the car’s name and its progress.  
```
pobi : --
woni : ----
jun : ---
```
- [x] After all rounds, display the final winner(s).
    - [x] If there is a single winner:
    ```
    Winners : pobi
    ```
    - [x] If there are multiple winners:
    ```
    Winners : pobi, jun
    ```
### Race Logic
- [x] Each car can either move forward or stay in place during each round.  
- [x] The car moves forward only if a randomly generated number between 0 and 9 is **greater than or equal to 4**.

### Exception Handling
- [x] If the user provides invalid input, the program should throw an `IllegalArgumentException` and terminate.
---

## Programming Requirements
- [x] You must implement the solution only in Kotlin—Java code is not allowed.
- [x] The entry point of the application must be the main() function in the Application class.
- [x] Do not use System.exit() or exitProcess() to terminate the program.
- [x] The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
    - For example, an if statement inside a while loop is acceptable, but nesting beyond that is not.
    - Tip: To reduce indentation depth, extract logic into functions.
- [x] Keep functions as small and focused as possible—each should do only one thing.
- [x] Use JUnit 5 and AssertJ to test the functionality according to your feature list
### Library
- [x] You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package.
    - To generate random values, use Randoms.pickNumberInRange() from camp.nextstep.edu.missionutils.Randoms.
    - To receive user input, use Console.readLine() from camp.nextstep.edu.missionutils.Console.


---

##  Architecture: MVC Pattern

This project follows the **MVC (Model-View-Controller)** architectural pattern to achieve clear separation of concerns and improve maintainability and scalability.

###  Model (Domain Logic)
- **`domain/Car.kt`**
  - Represents the core logic of the game.
  - Manages each car's state (`name`, `position`) and behavior (`move`, `printPosition`).
  - Determines car movement based on randomly generated numbers.

###  View (Input/Output)
- **`view/InputView.kt`**
  - Handles all user inputs, such as receiving car names and number of rounds.
- **`view/OutputView.kt`**
  - Displays race results, winners, and formatted outputs to the console.
- Decouples the UI logic from business logic to enhance testability.

###  Controller (Game Flow)
- **`controller/GameController.kt`**
  - Controls the overall game flow by interacting with both the Model and the View.
  - Collects inputs, executes the game logic, and displays the results.

###  Entry Point
- **`Application.kt`**
  - Initializes the controller and starts the game.
  



---
Example Execution
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
---
## Test Coverage

####  test(car)

- File: `CarTest.kt`
- Purpose:
  - Verify car moves forward only when the random number is ≥ 4.
  - Verify the car does not move when the number is < 4.
  - Check that car names exceeding 5 characters throw an exception.

---

####  test(view)

- Files: `InputViewTest.kt`, `OutputViewTest.kt`
- Purpose:
  - InputViewTest:
    - Validate that empty car names or names exceeding 5 characters throw `IllegalArgumentException`.
    - Validate that non-numeric round inputs throw `IllegalArgumentException`.
  - OutputViewTest:
    - Verify that car positions are printed in the correct format using console output capture.

---

####  test(app)

- File: `ApplicationTest.kt`
- Purpose:
  - Simulate full game execution from user input to final output using `run()` and `output()`.
  - Verify that winner output is correct when:
    - Only one car wins.
    - Multiple cars tie for the win.
  - Validate that a car name exceeding the character limit results in an exception.
