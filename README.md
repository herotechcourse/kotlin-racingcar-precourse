# kotlin-racingcar-precourse

## TODO:: List of the features:

- [ ] parse and validate input data:
    - first input: car names. Requirements: names separated by ','; name should be no longer then 5 characters.
        - test: empty car's name prompt test, result: Exception.
        - test: car's names prompt separated by ' ' test, result: Exception.
        - test: car's names length > 5 test, result: Exception.
        - code: validation functions for car's prompt
        - code: function to read cars from first input

    - second input: rounds. Requirements: only non-negative digits.
        - test: invalid rounds - NaN test, result: Exception.
        - test: invalid rounds - negative number test, result: Exception.
        - test: invalid rounds - 0 test, result: Exception.
        - test: invalid rounds - several '0' test, result: Exception.
        - code: validation functions for rounds prompt
        - code: function to read rounds from second input

- [ ] choose immutable Map as data structure (RaceState) to store information about car movements during one round

- [ ] fun printRound - print data about every car from RaceState to terminal in next format:

    ```declarative
        <carName> : -<repeat amount of the car collected movements times>
        Example:
        car1 : 
        car2 : -
    ```
    - test: print round data
    - code: fun printRound(carData: Map<String, Int)): Unit

- [ ] fun getCarMove - get car movement:
    - test: get cars move
    - code: fun getCarMove(randomNumber: Int): Int

- [ ] fun startRound - get new raceState and print information about round. Requirements:  update amount of movements
  for every car in race. Requirements: A car moves forward if a randomly generated number
  between 0 and 9 is 4 or greater. When printing the progress of each car, display the car's name alongside its
  movement.
    - test: run round on mocked Random data
    - code: fun startRound(carsData: Map<String, Int>): Map<String, Int>

- [ ] fun getWinners - get car movement:
    - test: get winners of race
    - code: fun getWinners(cars: Map<String, Int>): Unit

- [ ] race :
    - test: race 2 round mocked random
    - code: fun race(cars: Map<String, Int>, rounds: Int)
    - print full information about race:
        - Example
          ```declarative
              Enter the names of the cars (comma-separated):
              pobi,woni,jun
              How many rounds will be played?
              5
              
              Race Results
              pobi : -
              woni :
              jun : -
              
              pobi : --
              woni : -
              jun : --
              
              pobi : ---
              woni : --
              jun : ---
              
              pobi : ----
              woni : ---
              jun : ----
              
              pobi : -----
              woni : ----
              jun : -----
              
              Winners : pobi, jun
          ```