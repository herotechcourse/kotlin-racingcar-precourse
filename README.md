# kotlin-racingcar-precourse

- [x] game start, input
    - [x] The user should be able to specify car names and the number of rounds.
    - [x] Car names should be comma-separated when entered by the user.
    - [x] Each car must have a name, and names cannot exceed 5 characters.
    - [x] If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.

- [x] game play
    - [x] Each of the n cars can either move forward or stay still during a given number of rounds.
        - [x] make a game class to control the program
            - [x] save the car instance list
    - [x] A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
        - [x] make a move methods in car class

- [ ] output
    - [x] When printing the progress of each car, display the car's name alongside its movement.
    - [ ] After the race is complete, display the winners. There can be multiple winners if they reach the same final
      position.
        - [ ] if no one complete the length of rounds. how to determine the winner?
    - [ ] If there are multiple winners, their names should be displayed and separated by commas.
