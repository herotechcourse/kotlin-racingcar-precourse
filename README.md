# kotlin-racingcar-precourse

Get familiar with Angular Commits

- Make Car Objects

- Write a prompt and give user ability to write car names 
(comma separated, 5 letters max)

The user should be able to specify car names and the number of rounds.
Car names should be comma-separated when entered by the user.
Each car must have a name, and names cannot exceed 5 characters.

- Write a prompt and give user ability specify the number of rounds
(check if input in a number)

- Use  Randoms.pickNumberInRange() from camp.nextstep.edu.missionutils.Randoms
(determines if car moves forward)

Each of the n cars can either move forward or stay still during a given number of rounds.
A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.

- Make printing functions for each round with name : how_many_rounds_moved (Name : --)
When printing the progress of each car, display the car's name alongside its movement.

-  Make a printing function for winners
After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
If there are multiple winners, their names should be displayed and separated by commas.

- Make data validation
If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.