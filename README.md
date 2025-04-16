# kotlin-racingcar-precourse

Features to implement:
* User interface
  * Take user input (names and rounds)
    * Parse user input
    * Implement IllegalArgumentException
  * Create messages to the user
* Race and Car classes implementation
  * Car state calculation per round
  * Create output for the user
* Unit Tests

Example Execution:
```bash
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
Message for a single winner:
```bash
Winners : pobi
```

### Functional Requirements
* The user should be able to specify car names and the number of rounds.
  * Car names should be comma-separated when entered by the user. 
  * Each car must have a name, and names cannot exceed 5 characters. 
* Each of the n cars can either move forward or stay still during a given number of rounds.
* A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
* When printing the progress of each car, display the car's name alongside its movement.
* After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
  * If there are multiple winners, their names should be displayed and separated by commas.
* If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.

### Programming Requirements
* The program must be executable with Kotlin 1.9.24. 
* You must implement the solution only in Kotlin—Java code is not allowed. 
* The entry point of the application must be the main() function in the Application class. 
* You may not modify the build.gradle.kts file, and you may not use any external libraries other than those provided. 
* Do not use System.exit() or exitProcess() to terminate the program. 
* Unless otherwise specified in the requirements, you may not rename or move files, packages, or other project elements.

* Follow the Kotlin Coding Conventions. 
* The indentation depth must not exceed 2. A maximum of 2 levels is allowed. 
  * For example, an if statement inside a while loop is acceptable, but nesting beyond that is not. 
  * Tip: To reduce indentation depth, extract logic into functions. 
* Keep functions as small and focused as possible—each should do only one thing. 
* Use JUnit 5 and AssertJ to test the functionality according to your feature list.

### Library
You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package. 
* To generate random values, use Randoms.pickNumberInRange() from camp.nextstep.edu.missionutils.Randoms. 
* To receive user input, use Console.readLine() from camp.nextstep.edu.missionutils.Console.