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
- [x] Read user input for car names
- [x] Trim whitespace from each car name and validate:
    - Non-empty
    - Maximum 5 characters
- [x] Prompt the user to enter the number of race rounds and validate input as a valid integer
- [x] Simulate race logic:
    - For each round, each car generates a random number (0–9)
    - If the number is ≥ 4, the car moves forward by 1
- [x] Display race progress after each round:
    - Print each car’s name and progress using dashes (`-`)
    - Separate rounds visually with blank lines
- [x] Determine final winner(s):
    - Car(s) with the highest number of moves
    - Print winners separated by commas if multiple
- [x] Handle invalid input gracefully:
    - Throw `IllegalArgumentException` for empty names or names exceeding 5 characters
- [x] Write tests to cover:
    - Basic race functionality (random movement and scoring)
    - Edge cases (multiple winners, no movement)
    - Invalid input cases (too long names, empty input, etc.)


