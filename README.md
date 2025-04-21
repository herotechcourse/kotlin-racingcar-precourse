# kotlin-racingcar-precourse 
`Kotlin Racing Car`
by Rizki Pramadhan (rizki.pramadhan@itsprmd.id)

A simple simulation of car racing made in Kotlin. Cars move forward based on random number generation.

## Overview
The project implements the racing game with the following features
- Customizable car names by the user
- Race progress display
- Winner determination and display with possible tie

## Features
- **Application**: Application entry point. 
  - Contains input for car names and number of rounds
    - Validation logic for car names: Only accepts car name with comma delimiter and with less than 5 characters
    - Validation logic for number of rounds: No numbers below 1 are permitted 
- **Car**: Main logic for name and race distance calculation
- **Race**: Runtime logic for the race
  - Validates the car's movement for each round
  - Calls Race Display feature for every update to the race (rounds and race result)
- **Race Controller**: Initializes the race with the given names and rounds
- **Race Display**: Prints out the race progress and result to the console

## Testing
- **ApplicationTest**: end-to-end test
- **CarTest**: Validates car movement logic and name setting
- **InputTest**: Validates input for names and rounds
- **RaceTest**: Validates the execution of a race and winner determination