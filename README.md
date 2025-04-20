# kotlin-racingcar-precourse

---

## 📍 Features

### 1. Input
1. Car name input feature
   1. Comma-separated
   2. Each name cannot exceed 5 characters
2. Number of rounds input feature
   1. Integer
3. Exception for invalid input data
   1. For car name
   2. For number of rounds

### 2. Moving cars
1. Generate random number(0-9) for each car
2. If the number >= 4, move

### 3. Print the progress
1. Print the progress of each round

### 4. Display the winners
1. For multiple winners, separate them by commas
2. Display the result

## 📍 Sequence of the features
1. Input
2. Move cars while `for loop` with number of rounds
   1. `for loop` with the list of cars
      1. Generate the random number
      2. Move
   2. Print the progress of the round
3. Check the winners
4. Display the result

## 📍 Objects

- Car
  - Generating random number
  - Move
- Board
  - Get the inputs
  - Save the list of cars
  - Print the result of each round
  - Print the winners