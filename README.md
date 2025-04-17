# 🏁 kotlin-racingcar-precourse

***

# Functional Specification Checklist

### Prompt the user to enter the car names to race

- [X]  Display input message: “Enter the names of the cars (comma-separated):”
- [X]  Car names should be comma-separated when entered by the user.

- [X]  Throw an `IllegalArgumentException`and terminate the program when the user inputs invalid data.
    - [X]  Each car must have a name.
    - [X]  Each car must not exceed 5 characters.
    - [X]  [Add] The number of car names must be two or more.
    - [ ]  [Add] Car names must not contain duplicates.
    - [ ]  [Add] The delimiter must be a comma.

### Prompt the user to enter the number of rounds to race

- [X]  Display input message: “How many rounds will be played?”
- [X]  Throw an `IllegalArgumentException`and terminate the program when the user inputs invalid data.
    - [X]  The number of rounds must be a positive integer.

### Run the car racing game

- [ ]  Display start message: “Race Results”
- Repeat the game for the number of rounds entered by the users.
    - [ ]  Randomly generate a number between 0 and 9.
    - [ ]  If the number is 4 or greater, the car moves forward.
    - [ ]  If the number is less than 4, the car stays still.
- [ ]  Display the car's name alongside its movement.
    - e.g)
      pobi : -
      woni :
      jun : -

### Find the winners

- [ ]  Find the cars with maximum position.
- [ ]  Return the names of the cars with the maximum position.

### Display the winners.

- [ ]  If there is only one winner, display the message: “Winners : pobi”.
- [ ]  If there are multiple winners, display their names separated by commas.
- e.g) Winners : pobi, jun

### Error Handling

- [ ]  Throw an `IllegalArgumentException` and terminate the program when the user inputs invalid data.

---