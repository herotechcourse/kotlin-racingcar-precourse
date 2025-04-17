## Project Definition
Implement a simple car racing game.

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
- [ ] After all rounds, display the final winner(s).
    - [ ] If there is a single winner:
    ```
    Winners : pobi
    ```
    - [ ] If there are multiple winners:
    ```
    Winners : pobi, jun
    ```
### Race Logic
- [x] Each car can either move forward or stay in place during each round.  
- [x] The car moves forward only if a randomly generated number between 0 and 9 is **greater than or equal to 4**.

### Exception Handling
- [ ] If the user provides invalid input, the program should throw an `IllegalArgumentException` and terminate.

## Programming Requirements
- [ ] You must implement the solution only in Kotlin—Java code is not allowed.
- [ ] The entry point of the application must be the main() function in the Application class.
- [ ] Do not use System.exit() or exitProcess() to terminate the program.
- [ ] The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
    - For example, an if statement inside a while loop is acceptable, but nesting beyond that is not.
    - Tip: To reduce indentation depth, extract logic into functions.
- [ ] Keep functions as small and focused as possible—each should do only one thing.
- [ ] Use JUnit 5 and AssertJ to test the functionality according to your feature list
### Library
- [ ] You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package.
    - To generate random values, use Randoms.pickNumberInRange() from camp.nextstep.edu.missionutils.Randoms.
    - To receive user input, use Console.readLine() from camp.nextstep.edu.missionutils.Console.


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
