# Racing Car

Hero Tech Course 2025 Precourse Week 1 Mission

## Features
1. [ ] Race configurations
  * Properties
    - Car names
      * At least one name must be given.
      * 0 < length of name <= 5
    - Number of rounds
      * 0 < number of rounds <= 2,147,483,647
  * Design decisions
    - Use factory function to instantiate (private primary constructor)
    - Car name: Ignore leading and trailing spaces
    - Number of rounds: Throw `IllegalArgumentException` for errors during converting (e.g., `NumberFormatException`)
    - Number of rounds: Max acceptable value: max signed 32-bit integer (= 2,147,483,647)
