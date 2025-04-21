# kotlin-racingcar-precourse
# # Car Racing Game Features

1.  **Input Car Names:**
    * Prompt the user to enter car names.
    * Allow multiple car names to be entered, separated by commas.
    * Validate that each car name has a length of 1 to 5 characters.
    * Throw an `IllegalArgumentException` if any car name is invalid (empty or longer than 5 characters).

2.  **Input Number of Rounds:**
    * Prompt the user to enter the number of rounds for the race.
    * Validate that the number of rounds is a positive integer.
    * Throw an `IllegalArgumentException` if the input is not a valid positive integer.

3.  **Initialize Cars:**
    * Create `Car` objects, each with a name and an initial position of 0.

4.  **Simulate Rounds:**
    * For each round:
        * Iterate through each car.
        * Generate a random number between 0 and 9 (inclusive) using `Randoms.pickNumberInRange()`.
        * If the random number is 4 or greater, move the car forward by 1 unit.

5.  **Display Round Results:**
    * After each round, print the progress of each car.
    * Display the car's name followed by a colon and a string representing its movement (e.g., "-" for each unit moved).

6.  **Determine Winners:**
    * After all rounds are complete, determine the car(s) with the maximum final position.
    * There can be multiple winners.

7.  **Display Winners:**
    * Print the names of the winning car(s).
    * If there is a single winner, display "Winners : [winner name]".
    * If there are multiple winners, display "Winners : [winner name 1], [winner name 2], ...".

8.  **Handle Invalid Input:**
    * Throw an `IllegalArgumentException` for invalid car names (empty or longer than 5 characters).
    * Throw an `IllegalArgumentException` for invalid number of rounds (not a positive integer).
    * The program should terminate upon throwing the exception (without using `System.exit()` or `exitProcess()`).
