# Kotlin Racingcar Precourse

## Introduction
A small Kotlin application simulating a car racing game.
Players can choose the number of rounds and name their cars
and the application determines the winner based on a simulation
using random numbers. 🚗🏁

## Features
* reads and validates user input
  + car names:
    + 1 - 5 characters
    + contain only letters and numbers
    + 2 - 20 car names
    + separated by a single comma
    + no trailing comma
  + number of rounds:
    + positive integer
    + 1 - 100 rounds
  + if invalid input is provided, the program throws IllegalArgumentException and terminates