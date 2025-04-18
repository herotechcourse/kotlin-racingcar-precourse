# kotlin-racingcar-precourse

## 🛠️feature

### 🚗 1. input car names (Frontend)
> User enters the car names. 
- [x] Print "Names of the cars (comma-separated):"
- [x] Receive the car names from the user


### 🚙 2. parse car names (Backend)

> Parse and validate the car names, then pass them as CarDto.

- [x] Car names should be comma-separated when entered by the user.
- [x] Split the car names by `,`.
- [x] If a car name is empty, throw an `IllegalArgumentException`.
- [x] If a car name exceeds 5 characters, throw an `IllegalArgumentException`.
- [x] If there are duplicate car names, throw an `IllegalArgumentException`.
- [x] If the number of cars is 1 or fewer, throw an `IllegalArgumentException`.
- [x] Output the car names as CarDto.


### 🚗 3. input the number of rounds (Frontend)
> User enters the number of rounds.
- [x] Print "How many rounds will be played?"
- [x] Receive the number of rounds from the user

### 🚙 4. validate round input (Backend)
> Validate the number of rounds
- [x] If the number of rounds isn't an Integer, throw an `IllegalArgumentException`.
- [x] If the number of rounds is less than 1, throw an `IllegalArgumentException`.


### 🚙 5. start the race and calculate winners (Backend)
> Start the race and save as `Car`and `Race` object, then calculate winners
- [x] Convert carDto to `Car`object.
- [x] Repeat the race for the number of rounds entered by user.
- [x] For each race, generate a random number between 0 and 9 for each car. If the number is 4 or greater, the car moves forward, else, the car stays.
- [x] Save the race results in the `Race` object.
- [x] After the race ends, convert the results stored in the Race object to a DTO.
- [x] Identify the winner, who is the car that moved the most. There can be multiple winners.
- [x] Output the RaceResponse, which contains roundNum, raceResultList, and winnerList

### 🚗 6. output race results and winners (Frontend)
> User sees the race results and winners.
- [x] Print "Race Results"
- [x] Print the position of each car per round
- [x] Print the winners of the game. There can be multiple winners, and their names should be separated by commas.
