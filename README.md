# kotlin-racingcar-precourse

## 📜 Functional Requirements
>Implement a simple car racing game with the following rules:
- The user should be able to specify car names and the number of rounds.
- Car names should be `comma-separated` when entered by the user.
- Each car must have a name, and names cannot exceed `5 characters`.
- Each of the n cars can either move `forward` or `stay` still during a given number of rounds.
- A car moves `forward` if a randomly generated number between 0 and 9 is `4 or greater`.
- When printing the progress of each car, display the car's name alongside its movement.
- After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
- If there are multiple winners, their names should be displayed and separated by commas.
- If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.

***
## 📜 Project Flow
### 1. Game Start
   - When the program starts, prompt the user to enter car names.
        - Prompt: Enter the names of the cars to race (separated by commas):
        - Rules:
            - Names must be separated by commas.
            - Each name must be 5 characters or fewer.
            - If invalid input is provided, throw an IllegalArgumentException and terminate the program.
        - ex) pobi,woni,jun

### 2. Enter Number of Rounds
   - After entering car names, prompt the user to input the number of rounds.
        - Prompt: How many rounds will the race have?
        - Rules:
          - Must enter a valid integer.
          - If invalid input is provided, throw an IllegalArgumentException and terminate the program.

### 3. Run the Game
   - Repeat the following for the given number of rounds:
     - For each car: 
       - Generate a random number between 0 and 9.
       - If the number is 4 or greater, move the car forward (print -), otherwise stay still.
   - Display each car’s progress after each round.
   - output ex)
```
pobi : -
woni :
jun : --
```
    

### 4. Determine and Display the Winners
   - After all rounds are completed:
      - Find the car(s) that moved the farthest.
      - If multiple cars have the same maximum distance, they all win.
   - Display the winner(s) separated by commas.
     - ex) Winner(s): car1, car3

### 5. End the program

***
## 📜 Programming Requirements 1
- version Kotlin 1.9.24.
- user Kotlin language
- The entry point of the application must be the main() function in the Application class.
- `NOT` modify the build.gradle.kts file, and `NOT` use any external libraries other than those provided.
- `NOT` use System.exit() or exitProcess() to terminate the program.
- Unless otherwise specified in the requirements, you may not rename or move files, packages, or other project elements.

***
## 📜 Programming Requirements 2
- Follow the [Kotlin Coding Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153).
- The indentation depth must not exceed 2. A maximum of 2 levels is allowed.
  - For example, an if statement inside a while loop is acceptable, but nesting beyond that is not.
  - Tip: To reduce indentation depth, extract logic into functions.
- Keep functions as small and focused as possible—each should do only one thing.
- Use JUnit 5 and AssertJ to test the functionality according to your feature list.

***
## 📜 Library
- use the Randoms and Console APIs provided by the `camp.nextstep.edu.missionutils` package.
  - To generate random values, use Randoms.pickNumberInRange() from camp.nextstep.edu.missionutils.Randoms.
  - To receive user input, use Console.readLine() from camp.nextstep.edu.missionutils.Console.
- ex) `Randoms.pickNumberInRange(0, 9)`



***
## 📜 Test
### 📌 Input Test
#### Car Name Input
- if the input is over 5 letters, throw IllegalArgumentException
- if the input is empty, throw IllegalArgumentException
- if the names are seperated with comma, get list names
- if the names are duplicated, throw IllegalArgumentException

#### Round Input
- if the input is 0 or negative, throw IllegalArgumentException
- if the input is not Integer, throw IllegalArgumentException

### 📌 Car Move Test
- Random value is equal or greater than 4, position bar get new bar("-")
- Random value is less than 4, position does not change

### 📌 Race Progress Test
- Repeat the race as many times as the input number of rounds
- Print the movement result of all cars in each round

### 📌 Winner Decision Test
- Select the cars that moved the farthest as the winner(s)
- If there are multiple winners, print their names separated by commas
- Check if the winner's name(s) are printed correctly

### 📌 Exception Handling Test
- Terminate the program when invalid input is entered
- Check if IllegalArgumentException is thrown as expected