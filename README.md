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
    + contain only letters and numbers (case sensitive)
    + limit: 2 - 20 car names
    + separated by a single comma, no whitespaces
    + no trailing comma
    + no duplicates
  + number of rounds:
    + positive integer
    + limit: 1 - 100 rounds
  + if invalid input is provided, the program throws IllegalArgumentException and terminates