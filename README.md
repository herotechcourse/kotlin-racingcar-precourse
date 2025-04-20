# Kotlin Racingcar Precourse

## Introduction
A small Kotlin application simulating a car racing game.
Players can choose the number of rounds and name their cars
and the application determines the winner based on a simulation
using random numbers. 🚗🏁

## Features
#### User Input
* reads and validates user input inside the `InputHandler` class 
  + reads utilizing the `camp.nextstep.edu.missionutils.Console` API
  + car names:
    + 1 - 5 characters
    + contain only letters and numbers (case sensitive)
    + limit: 2 - 20 car names
    + separated by a single comma, no whitespaces
    + no trailing comma
    + no duplicates
  + number of rounds:
    + positive integer
    + limit: 1 - 100 rounds
  + if invalid or empty input is provided, the program throws IllegalArgumentException and terminates
#### Cars
* initializes instances of the `Car` class with the car names
* cars can move or stay still
  * based on random number generation from the `camp.nextstep.edu.missionutils.Randoms` API
  * moves if the random number between 0 and 9 is >= 4 
* prints the progress of the car in the following manner: `pobi : --`
#### Race
+ creates a `RaceGame` class with the list of cars and the number of rounds
+ runs the race 
+ displays the race results (progress of each car)
+ displays the winners:
  + one winner or multiple winners if they have the same result