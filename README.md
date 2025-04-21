# kotlin-racingcar-precourse

## Features

### Car class
- [x] Implement Car class (name must be non-blank, must not exceed 5 characters)

### Input
- [x] Get car names from the user, separated by commas.
- [x] Get the number of race rounds. (race rounds must exceed 0)
- [x] Duplicate Car Name Handling. (If the same car name is entered multiple times, the program will automatically append numbers to distinguish them.)

### Racing
- [x] Generate a random number between 0~9 for each car.
- [x] If the number is bigger than 4, move forward; if not, stay.
- [x] Represent car positions by '-'.

## Result
- [x] Print results for each round alongside car names.
- [x] After all rounds are done, pick the winner. (If there are multiple winners, print all their names)

## Exception
- [x] Throw IllegalArgumentException for any input that does not meet the requirements.

## Test

- [x] Prints correct winner when the race is complete
- [x] Does not move if random number is less than 4
- [x] Moves forward when random number is 4 or more
- [x] Prints all winners when multiple cars win
- [x] Throws IllegalArgumentException when:
    - Car name is blank
    - Car name exceeds 5 characters
    - Round number is 0