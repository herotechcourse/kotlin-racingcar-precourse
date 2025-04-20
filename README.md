# Kotlin Racing Car Precourse

## Overview

This project is a simple racing car game written in Kotlin. Users input car names and the number of rounds. Each car moves based on random numbers, and the winner(s) are determined by who goes the farthest.

### Game Setup

- Accepts car names from user input (comma-separated, e.g., `pobi,jun,east`)
- Validates:
    - Each name must be 1 to 5 characters long
    - No duplicate car names
- Accepts the number of race rounds
    - Must be a positive integer

### Car Movement

- For each round, a random number between 0 and 9 is generated for each car
- If the number is 4 or higher, the car moves forward by one position
- Car progress is displayed using dashes:
  pobi : --- jun : ----

### Race Progress

- Displays car progress after each round
- Shows all cars and their current positions

### Determining Winners

- The car(s) that move the farthest win the race
- If multiple cars tie, their names are displayed comma-separated
- Winners : pobi, jun


### Error Handling

Throws an `IllegalArgumentException` for:

- Car names longer than 5 characters
- Empty or missing car names
- Zero or negative round numbers

The program handles errors gracefully without using `System.exit()`

### Testing

- Uses `camp.nextstep.edu.missionutils.test` for deterministic testing
- Includes tests for:
- Car movement based on mocked random numbers
- Race progression and winner determination
