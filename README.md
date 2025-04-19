# kotlin-racingcar-precourse
## Functional Requirements
Implement a simple car racing game with the following rules:

* The user should be able to specify car names and the number of rounds.
    * Car names should be comma-separated when entered by the user.
    * Each car must have a name, and names cannot exceed 5 characters.
* Each of the n cars can either move forward or stay still during a given number of rounds.
* A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
* When printing the progress of each car, display the car's name alongside its movement.
* After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
  * If there are multiple winners, their names should be displayed and separated by commas.
* If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.