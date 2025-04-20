# kotlin-racingcar-precourse

## Feature List:
- Create a Car class and add it's functions
  - it should hold the name
  - it should track the position
  - it should be able to move forward
  - it should be able to print position
- Create a Lap class and add it's functions
  - it should be able to start lap
  - it should be able to print car positions
- Create a Race class and add it's functions
  - it should be able to start race
  - it should be able to print winners
- Create util functions to validate user inputs
  - parseNames: read names input and convert names to trimmed string array
  - validateNames: validate names array to check if it contains names where character length is less than 5
  - validateRounds: validate if rounds input is a positive integer
- Connect Objects together and finalize the implementation
  - convert names to Car map
  - create Race instance by providing cars and laps count
  - start the race
  - print the winners