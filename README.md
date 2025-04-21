# kotlin-racingcar-precourse

## Features

### User Input Processing
- take user input

### Car Name Processing
- split the first input based on comma
- list the splited inputs
- check if car names are valid

### Number of Rounds Processing
- check if the second input is a valid number for round numbers

### Random Number Generator
- use `Random` API in `camp.nextstep.edu.missionutils` package to generate number between 0~9

### Round Processing
- count the round offered by the user
- generate random number for each car, each round
- determine the car's action based on the random number generated  
  → move forward if generated number between 0 and 9 is 4 or greater, otherwise stop
- measure the total distance of the car's position each round
- print each car name and show current position with numbers of `-`

### Deciding Winner
- sort the car names based on number of rounds it went forward
- print the name of the cars with the highest number