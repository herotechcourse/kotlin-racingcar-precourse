# kotlin-racingcar-precourse

## Overview
This project is a simple simulation of a car racing game. Car names are given by the user with a number for simulation rounds. Car's movement is determined randomly and results are displayed after each round.

## Features

1. **Input Validator**
    - Includes user input reading functionality for car name and rounds.
    - Validates user inputs against the requirements i.e. cars should have a name, name should be 5 characters max.

2. **Car Class**
    - Includes car's name and position variables.
    - Includes a function to determine car's movement in each round

3. **Race Class**
    - Includes necessary components of a race: list of verified car names and number of rounds.
    - Includes the race logic for starting and updating positions in each round.
    - Display the result of each round by showing position of the cars in front of their names.

4. **Winner Announcement**
    - Determine and announce the winner or winners based on the final position of the cars.