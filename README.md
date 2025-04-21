# kotlin-racingcar-precourse


 ## Learning Objectives
- [x] Gain familiarity with industry-standard development tools such as Git, GitHub, and IntelliJ IDEA
- [x] Learn to refactor large functions into smaller, single-responsibility functions that are easier to read, test, and maintain
- [x] Understand how to write and run automated tests using JUnit 5 and AssertJ to verify that the program works as expected

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

 ## Features to Implement
- [x] take user input of car names
- [x] validate names are non-empty and ≤ 5 characters
- [x] take number of rounds as input
- [x] each car moves forward if random number ≥ 4
- [x] print results after each round and print final winner
- [x] write tests

