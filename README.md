# Racing Car
## Hero Tech Course 2025 Precourse Week 1 Mission

### Features
- Race configurations
    - Properties
        - Car names
            - At least one car name
            - 0 < length of name <= 5
        - Number of rounds
            - 0 < number of rounds
    - Design decisions
        - Use factory function to instantiate (private primary constructor)
        - Ignore leading and trailing spaces in each name
        - Throw IllegalArgumentException for errors during converting numnber of rounds (e.g., NumberFormatException)
