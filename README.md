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
    - Duplicate car names should not be allowed with case sensitivity
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

## 2. Implement the race game 
### a. Responsibilities:
- Write a race class which implements the race car game which does the following,
  - Make the cars run for the mentioned total rounds time
  - Record the progress of the cars in each round based on the generated random number
    - The cars make a progress when the random number is between 4 and 9. 
    - The cars dont make a progress otherwise
  - Announce winner/winners based on the highest value of the progress
### b. Validation:
- The code validates the below conditions
  - Minimum 2 cars needs to participate in the race
  - Max number of cars that can participate in the race should be integers max range 2,147,483,647
  - Number of rounds should be greater than zero
### c. IO Args:
- The code takes the following inputs
  - Array of Cars object
  - Total Rounds as Integer
- The code returns the following output
  - The progress made by the participating cars in each round
  - The winner(s) of the race based on the progress made
### d. Test cases
- Test cases to check that the number of cars participating in the game should be greater than 1
- Test case to check that the total number of rounds should be greater than 0
