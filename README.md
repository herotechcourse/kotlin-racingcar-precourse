# java-racingcar-precourse

## ✅ Feature Implementation Checklist

### 🧑‍💻 User Input
- [ ] Display message: "Enter the names of the cars to race. (Names should be separated by commas)"
- [ ] Receive user input using `readLine`

### ✅ User Input Validation
- [ ] Split user input by ","
- [ ] Handle exception if input is empty
- [ ] Handle exception if only delimiters are entered
- [ ] Check if any name is empty after splitting, and handle exception if so
- [ ] Validate that each name is 5 characters or less; handle exception otherwise
- [ ] Check for duplicate names; handle exception if duplicates are found
- [ ] Validate that the number of names is 1000 or less; handle exception otherwise
- [ ] Validate that names do not contain special characters or symbols; handle exception otherwise
- [ ] Validate that input contains only printable characters; handle exception otherwise
- [ ] Implement functionality to create `Cars` object

### 🔢 Number of Game Rounds Input
- [ ] Receive number input

### ✅ Game Rounds Validation
- [ ] Validate that the input is a positive integer; handle exception otherwise
- [ ] Handle exception if input is empty
- [ ] Validate that the number is 1000 or less; handle exception otherwise  
  _(to avoid long runtime and too much output)_

### 🕹️ Game Logic
- [ ] Implement functionality to create a `Game` object
- [ ] Use a loop to run the game for the entered number of rounds
    - [x] Generate a random number for each player
    - [x] If the number is 4 or higher, increase the player's move count
    - [x] Print the result for the round

### 🏆 Winner Calculation
- [ ] Store the user(s) with the highest move count

### 🎉 Winner Output
- [ ] Print the stored winner's name
- [ ] If there are multiple winners, separate their names with ", "
