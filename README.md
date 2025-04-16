# 🚘 kotlin-racingcar-precourse 🚘

## Input

- [] Read names of the cars, separated by commas
    - [] Throw an `IllegalArgumentException` if the value is null or blank
- [] Read number of rounds
    - [] Throw an `IllegalArgumentException` if the value is null or blank

## Output

- [] Show race results for each round
- [] Show winner(s)
    - [] comma-separated if there are multiple winners

## Domain

- [] Separate car names using comma
- [] Validate the total number of cars must be between 2 and 20
    - [] Throw an `IllegalArgumentException` if the value is out of range

- [] Validate car name must be between 1 and 5 characters
    - [] Throw an `IllegalArgumentException` if the name contains non-alphabet characters
    - [] Throw an `IllegalArgumentException` if a name is duplicated

- [] Validate the number of rounds must be betweem 1 and 10
    - [] Throw an `IllegalArgumentException` if the value is out of range
    - [] Throw an `IllegalArgumentException` if the value is not a number

- [] Generate a random number between 0 and 9 (use `Randoms.pickNumberInRange()`)
- [] Move a car forward only if the randomly generated number is 4 or greater
- [] draw the winner
