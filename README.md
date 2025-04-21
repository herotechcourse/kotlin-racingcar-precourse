# kotlin-racingcar-precourse

## Detailed Implementation Requirements

1. Input Functions

    - Racing car names (names are separated by commas)
        - Car names cannot be empty strings.
        - Car names cannot be longer than 6 characters.
        - Car names can include spaces, but spaces are counted as characters.
    - Number of attempts
        - Only positive integers can be entered.

2. Functions that should operate for each car in every turn

    - Random function operation
    - If the random function value is 4 or greater, advance; if less, stop
    - Increase the car's travel distance when advancing
    - Display the distance each car has advanced with '-' in the order of the input car names.

3. When the number of attempts is exhausted, output the final winner.

## Functions to Implement by Class

0. Constants
    - Maximum allowed length for car names
        - Only allow names below a specific number
    - Forward movement condition value
        - Only advance when above a certain number
    - Minimum number of cars for racing
        - Setting for the minimum number of cars required for racing.
    - Minimum and maximum values for the random function
1. Input Class
    - Function to input car names
    - Function to input number of attempts
2. Output Class
    - Function to output car racing results based on random function results
    - Function to output the final winner
3. Validation Class
    - Check for empty strings
    - Check if exceeding specific length
    - Check if meeting the minimum number of cars required for racing
    - Check for duplicate names
    - Check if input is a positive integer
4. Racing Class
    - Random function
    - Car movement function
    - Winner determination function