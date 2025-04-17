# kotlin-racingcar-precourse

A simple car racing game will be implemented to complete Delivery Hero Precourse Task 1.

### Overview

This project is a car racing game that allows users to input car names and the number of race rounds. 
During each round, cars either move forward or stay still depending on randomly generated numbers for each car.
numbers. The game displays the progress of each car after every round and determines the winner(s) based on their final positions.
In case of a tie, multiple winners will be displayed.

### Features

- Accept the car names input entered by the user
  - Must be comma-separated 
  - Each car must include a name
  - Each car name must not exceed 5 characters
- Accept the number of rounds entered by the user
  - Must be a positive integer
- Generate a random number between 0 and 9 for each car in each round
  - For values equal to or greater than 4, cars will move forward in that round
  - For values less than 4, cars will stay still in that round
- Display the progress of each car after every round
- Display the winner(s) when the race is complete
  - For races containing multiple winners, car names must be comma-separated
- Throw an `IllegalArgumentException` and terminate the program if any input is invalid
