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

- [x] output
    - [x] When printing the progress of each car, display the car's name alongside its movement.
    - [x] After the race is complete, display the winners. There can be multiple winners if they reach the same final
      position.
        - [x] if no one complete the length of rounds. how to determine the winner?
    - [x] If there are multiple winners, their names should be displayed and separated by commas.

- programming requirements
    - [ ] The entry point of the application must be the main() function in the Application class.
    - [ ] The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
        - early return
        - top level function
    - [x] Keep functions as small and focused as possible—each should do only one thing.
    - [x] Use JUnit 5 and AssertJ to test the functionality according to your feature list.
        - [x] Add a test fot the logic that determine winners
    - [x] You must use the Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package.
