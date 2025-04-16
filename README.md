# kotlin-racingcar-precourse

## Features

- **Input Car Name**

  - Prompt user to input car names in comma-seperated format
  - Throw IllegalArgumentException if
    - car name exceeds 5 character limit

  Example:

  ```
    Enter the names of the cars (comma-separated):
    pobi,woni,jun
  ```

- **Input Number of Rounds**

  - Prompt user to input number of round as "How many rounds will be played?"
  - Throw IllegalArgumentException if
    - The input is not an integer
    - The input is not a positive number
    - The input is zero

  Example:

  ```
  How many rounds will be played?
  5
  ```

- **Car Movement**

  - Generate a random number between 0 to 9 in each round for each car
  - Mark the movement as forward if the generated rumber is 4 or greater
  - Mark the movement as still if the generated number is less than 4

- **Display Progress of the Race**

  - If there is a movement then print "-" for each car.
  - display the car's name alongside its movement.
  - Display the output list as "Race results by round:"
  - Display the name of the car with its movement
    - format : Car name : Its movement(-)

  Example:

  ```
  Race Results
  pobi : -
  woni :
  jun : -

  pobi : --
  woni : -
  jun : --
  ```

- **Display the Winners of the Race**

  - If there is a single winner display the result as
    - Format: Winners : Car name
  - If there is a multiple Winner display the result as
    - Format: Winners: < car names separed by comma and a space >

  Single Winner Example:

  ```
  Winners : pobi
  ```

  Multiple Winner Example:

  ```
  Winners : pobi, jun
  ```
