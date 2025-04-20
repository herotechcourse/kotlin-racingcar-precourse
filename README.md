# kotlin-racingcar-precourse

## 1. Get input details from the user
### a. Responsibilities:
- Write a function to get user input: comma seperated values denoting names of cars participating in the race and the number of rounds the cars will run in the race
### b. Validation:
- This code also validates the user input for the following conditions 
  - car names 
    - should not be empty or whitespaces
    - car name string cannot have length > 5
    - Atleast 2 cars participate in the game 
  - number of rounds 
    - should be > 0 
    - should not be a number
    - should be within integers max range value 2,147,483,647
### c. IO Args
- The function shall return the following outputs 
  - A map of car name and its corresponding progress, with progress initialised to 0.
  - The total number of rounds
### d. Test cases 
- Test case for a valid scenario
- Test cases for all the invalidation scenarios
- Test case to check the parsing of the user input. 
