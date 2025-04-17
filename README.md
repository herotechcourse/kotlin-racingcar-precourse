# kotlin-racingcar-precourse


## Overview

This program simulates a car race where one or more cars win the race based on their random progress. The goal is to create a simple car race simulator that allows users to:
- Select the input the names of the cars (up to 5 characters each).
- Set the number of rounds for the race.
- Simulate each round with a 60% chance of a car advancing.
- Track which car advances the most and declare one or more winners at the end of the race.

## Planned Functions and Features

### 1. **Car Creation and Setup**
   - **Goal**: Enable user input for car names and number of rounds.
   - **Function to Implement**:
     - `createCars(String carNames)`: This function will take a single string containing car names, split the names, and create `Car` objects for each name. Each `Car` object will store an integer that tracks how many times the car has advanced during the race.
   - **Reasoning**: The user will enter car names in a single string (with commas separating each name). This function will handle extracting the car names, creating `Car` objects, and storing them in an array or list. The function will also initialize each car’s progress counter to zero, allowing the program to track how many rounds each car advances.

### 2. **Race Implementation**
   - **Goal**: Implement functions to advance the cars each round with a random chance
   - **Function to Implement**:
     - `Car() { move() }`: This function with move the car with a random chance and update the progress.
     - `Car() { getProgress() }`: This function with move the car with a random chance
   - **Reasoning**: The created cars will participate in a race with a random chance. Implementing the progress functions within the class helps the code to be more concise and reduce boiler plate codes in the main function.

### 3. **Simulate Race and Result**
   - **Goal**: Implement the race and show the race progress as well as result
   - **Function to Implement**:
     - `simulateRace(Cars: List<Car>, rounds: Int)`: This function proceeds with the rounds and prints the process of the race.
     - `determineWinners(cars: List<Car>): List<Car>`: This function determines the winner of the race and returns it as a List 
   - **Reasoning**: The user needs to see the progress of each rounds and they are represented with a '-' character. At the end of the race, the winner is printed out.

### 4. **Error Handling**
   - **Goal**: Throw error when user enters invalid input
   - **Function to Implement**:
     - IllegalArgumentException when at invalid input
   - **Reasoning**: Input validation ensures the program behaves predictably and prevents unexpected crashes. Throwing IllegalArgumentException helps notify the user early when inputs like empty names, overly long names, or non-numeric rounds are entered.

### 5. **Refactoring**
   - **Goal**: Refactor used Classes and function within the program
   - **Reasoning**: Good code often means good readability. In order to increase readability of the code, separating some functions and classes can be a good idea. Trying to reduce too much raw code in main function can also be helpful.

### 6. **Add Test Cases**
   - **Goal**: Add different test cases to ensure functionality of the app and implement more Error handling if needed
   - **Test Cases to Implement**: 
      - Multiple winners
      - No winner
      - One player
      - Invalid Car names: regex("^[A-Za-z_]{1,5}$")
         - white space
         - too long names
         - empty input
         - duplicate names
      - Invalid Round number
         - zero or negative
   - **Reasoning**: Comprehensive test cases help ensure the program behaves correctly under various scenarios and edge cases. They also allow early detection of bugs and improve the reliability of the application.
---

## Implementation Progress

### Phase 1: **Car Creation and Setup**
   - **Goal**: Implement the function to create cars based on user input.
   - **Current Status**:
     - Car object will be created
     - The `createCars` function will be implemented.
   - **Next Step**: Implement movement and progress recorder functions for the cars

### Phase 2: **Car Movement and Progress**
   - **Goal**: Implement the function to move cars and record its progress.
   - **Current Status**:
     - Car movement features will be implemented
     - The progress of the cars will be recorded.
   - **Next Step**: Implement race simulator function and function to determine the result of the race

### Phase 3: **Race Simulation and Result**
   - **Goal**: Implement the functions to simulate the race and print the results.
   - **Current Status**:
     - The function to proceed each rounds will be implemented
     - The funuction to determine the winner will be implemented
     - All the progress will be printed
   - **Next Step**: Implement error handling through IllegalArgumentException

### Phase 4: **Error Handling**
   - **Goal**: Implement Error Handling through IllegalArgumentException
   - **Current Status**:
     - An IllegalArgumentException error will be thrown at invalid input from the user
   - **Next Step**: Refactor Car class and some functions if possible

### Phase 5: **Refactoring**
   - **Goal**: Refactor Code for better readability
   - **Current Status**:
     - Add files (Car.kt, InputHandler.kt, OutputHandler.kt, RaceManager.kt) and refactor code
   - **Next Step**: Add different Test Cases to secure app's performance

### Phase 6: **Test Cases**
   - **Goal**: Add vital test cases for the app
   - **Current Status**:
     - Add Test cases
     - Add corresponding situation handling
   - **Next Step**: double check the app and submit
---

## 💡 Project Reflection

Through the development of this program, I gained valuable experience in various aspects of software development beyond simply writing code that works. This project challenged me to focus on writing **clean, maintainable code** and to consider how test cases can reflect **real user scenarios** and behaviors.

One of the most eye-opening parts of this experience was **working primarily through test files** rather than relying on the `main()` function. This approach required me to **think ahead**, design the program structure first, and then implement the logic to match those test cases. It significantly shifted my perspective on program design and highlighted the importance of **test-driven development**.

In addition, spending effort on writing **clear Git commit messages** and maintaining an updated **README file** helped me understand the value of good documentation and project history. Setting up **automated changelogs** was also a new but fascinating experience.

Learning the **Kotlin language** was equally rewarding. I enjoyed discovering its rich set of iteration functions and how object-oriented programming in Kotlin can be both **readable and concise**.

Lastly, I invested a great deal of time in laying a **solid foundation** before writing any code. While this process took time, I’m confident that these habits will become more efficient with practice. I'm excited to continue improving and see how these efforts pay off in future projects.
