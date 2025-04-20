# kotlin-racingcar-precourse
## Functional Requirements
- [x] The user should be able to specify car names and the number of rounds.
   - [x] Car names should be comma-separated when entered by the user.
   - [x] Each car must have a name, and names cannot exceed 5 characters.
- [x] Each of the n cars can either move forward or stay still during a given number of rounds.
- [x] A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
- [x] When printing the progress of each car, display the car's name alongside its movement.
- [x] After the race is complete, display the winners. There can be multiple winners if they reach the same final position. 
    - [x] If there are multiple winners, their names should be displayed and separated by commas.
- [x] If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.

## Function List
### `Car`
- [x] Car have a name.
- [x] Car name cannot exceed 5 characters.
- [x] Car have a position and default position is 0.
- [x] If the given number is 4 or more, the car moves.

### `RacingGame`
- [x] RacingGame can generate the random numbers from 0 to 9.
- [x] RacingGame can move cars according to the random number.
- [x] RacingGame can decide the winner.

## Programming Requirements
- [x] The program must be executable with Kotlin 1.9.24.
- [x] You must implement the solution only in Kotlin—Java code is not allowed.
- [x] The entry point of the application must be the main() function in the Application class.
- [x] You may not modify the build.gradle.kts file, and you may not use any external libraries other than those provided.
- [x] Do not use System.exit() or exitProcess() to terminate the program.
- [x] Unless otherwise specified in the requirements, you may not rename or move files, packages, or other project elements.
- [x] The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
- [x] Keep functions as small and focused as possible—each should do only one thing.
- [x] Use JUnit 5 and AssertJ to test the functionality according to your feature list.
- [x] You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package.
