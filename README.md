# kotlin-racingcar-precourse: A Car Racing Game

## Overview
This project is a simple car racing game where the user can input car names and the number of rounds for the race.
The cars will randomly move forward or stay still during each round, and the progress will be displayed after each game round.
At the end of the race, the winners are determined based on the car's final positions, and multiple winners can be displayed if there is a tie.

## Features

 - User can input a list of car names, separated by commas(max 5 characters per car name).
 - User can specify the number of rounds for the race.
 - Each round, cars will eitther move forward or stay still, based on a random number generator.
 - The progress of each car is displayed after every round.
 - The program determines the winner(s) at the end of the race and prints their names.
 - Input validation ensures that car names and rounds are valid.
 - Invalid inputs throw `IllegalArgumentsException` to terminate game

## How to Run Project
 1. Clone this repository to your local machine.
 2. Run the program in your preferred Kotlin IDE or run via the command line.

To run:
<pre>
# Run in Kotlin environment 

  ./gradlew run 
</pre>

## Example Execution

### Input:
````
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5
````

### Output:
````
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
````

### Requirements

 - Kotlin 1.9.24
 - JUnit 5 and AssertJ for testing
 - Use `camp.nextstep.edu.missionutils.Console` for input and  
   `camp.nextstep.edu.missionutils.Randoms` for random number generation



### What I Learned

- Basics of Kotlin syntax and functions
- Working with lists, loops, and conditionals in Kotlin
- Using custom classes and encapsulation (`Car` class)
- Validating user input from the console
- Writing unit tests using **JUnit 5** and **AssertJ**
- Using `gradlew` to build and test Kotlin apps
- How to mock random behavior in tests using `assertRandomNumberInRangeTest`

### Resources Used

- [Kotlin Official Documentation](https://kotlinlang.org/docs/home.html)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ Documentation](https://assertj.github.io/doc/)
- IntelliJ IDEA Kotlin support
- Stack Overflow and Kotlin Slack community for help with testing and Gradle

---


### Future Improvements

- Allow car names with more customization (e.g. emoji or Unicode)
- Add animations or a simple UI to visualize race progress



### Author 

Built with ❤️ by Goitseone Montsho as part of the Delivery Hero Tech Academy pre-course challenge.