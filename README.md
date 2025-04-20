# 🚘 kotlin-racingcar-precourse 🚘

# 📝 Feature List

## ▪︎ Input

- [x] Read names of the cars, separated by commas
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
- [x] Read number of rounds
    - [x] Throw an `IllegalArgumentException` if the value is null or blank
    - [x] Throw an `IllegalArgumentException` if the value is not a number

## ▪︎ Output

- [x] Show race results for each round
- [x] Show winner(s)
    - [x] comma-separated if there are multiple winners

## ▪︎ Domain

### Car

- [x] Validate the total number of cars must be between 2 and 20
    - Throw an `IllegalArgumentException` if the value is out of range
- [x] Validate car names are not duplicated
    - Throw an `IllegalArgumentException` if any name is duplicated
- [x] Validate car name must be between 1 and 5 characters
    - Throw an `IllegalArgumentException` if the name length is out of range
- [x] Validate car name must only contain alphabets
    - Throw an `IllegalArgumentException` if the name contains non-alphabet characters

### Race

- [x] Validate the number of rounds must be between 1 and 10
    - Throw an `IllegalArgumentException` if the value is out of range
- [x] Play the race by repeating the rounds
    - [x] Generate a number between 0 and 9
        - [x] Generate a random number between 0 and 9 (use `Randoms.pickNumberInRange()`)
        - [x] Generate a fixed number between 0 and 9
            - Throw an `IllegalArgumentException` if the number is out of range
    - [x] Move a car forward only if the randomly generated number is 4 or greater
- [x] Determine the winner
    - [x] Calculate the max position of racing cars
    - [x] Find the cars at the specified position

# Flow

1. Input car names (ensure the input contains only alphabets and commas, and each name does not exceed 5 characters).
2. Input the number of rounds (ensure the input is a number between 1 and 10).
3. Play the race for the specified number of rounds (each car moves forward only if a randomly generated number is 4 or
   greater).
4. Print the race results for each round.
5. Determine the winner(s) based on the furthest distance.
6. Print the winner(s).

# Example Execution

```
Enter the names of the cars (comma-separated):
jii,pobi,jun
How many rounds will be played?
3

Race Results
jii : 
pobi : -
jun : 

jii : 
pobi : --
jun : -

jii : -
pobi : ---
jun : --

Winners : pobi


```
