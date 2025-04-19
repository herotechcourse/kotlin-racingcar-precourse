# kotlin-racingcar-precourse

- First, the user should enter car names and the number of rounds.
  Car names should be comma-separated and a maximum of five characters.
  Car names must be unique.
  Rounds must be a valid and positive number.
  - Example input: `jane,joe,doe` and `5`
- Initial position should be set as 0 for each car.
  - Create Car object
- For each round:
  - Iterate over all cars.
  - For each car, generate a random number between 0 and 9.
  - If the number is 4 or greater, increase the car’s score by 1.
  - If the number is less than 4, leave the score unchanged.
- Repeat the above process until the round count reaches zero.
- After all rounds are completed:
  - Display the state and winners.
