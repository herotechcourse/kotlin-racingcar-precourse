# 🚘 kotlin-racingcar-precourse 🚘

## Input

- [x] Read names of the cars, separated by commas
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
- [x] Read number of rounds
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
    - [x] Throw an `IllegalArgumentException` if the value is not a number

## Output

- [x] Show race results for each round
- [] Show winner(s)
    - [] comma-separated if there are multiple winners

## Domain

- [x] Validate the total number of cars must be between 2 and 20
    - Throw an `IllegalArgumentException` if the value is out of range
- [x] Validate car names are not duplicated
    - Throw an `IllegalArgumentException` if any name is duplicated

- [x] Validate car name must be between 1 and 5 characters
    - Throw an `IllegalArgumentException` if the name legnth is out of range
- [x] Validate car name must only contain alphabets
    - Throw an `IllegalArgumentException` if the name contains non-alphabet characters

- [x] Validate the number of rounds must be between 1 and 10
    - Throw an `IllegalArgumentException` if the value is out of range

- [x] Separate car names using comma
- [x] Generate a random number between 0 and 9 (use `Randoms.pickNumberInRange()`)
- [x] Move a car forward only if the randomly generated number is 4 or greater
- [] draw the winner
