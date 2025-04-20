# kotlin-racingcar-precourse

## 🚗 Features
### 1. Input car names
- Accept comma-separated car names from the user
- Each name must be 5 characters or fewer and not empty

### 2. Input number of rounds
- Accept a valid number of attempts (must be a positive integer)

### 3. Initialize and store car information
- Create a list of cars, each with a name and current position (initially 0)

### 4. Run the race
- For each round:
  - Generate a random number between 0 and 9
  - If the number is 4 or greater, the car moves forward by 1 

### 5. Display race progress
- Show each car's name and current position as a series of dashes (`-`)
- Print results after each round 

### 6. Determine and display winners
- Identify the car(s) with the furthest distance
- Display winners as: `Winners : pobi, jun`

### 7. Handle invalid input
- Throw `llegalArgumentException` and terminate the program for any invalid input

