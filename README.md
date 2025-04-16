# kotlin-racingcar-precourse

# Car Racing

## requirements analysis
- user specify 'car names' and number of 'rounds'.
  - Car names should be comma-separated when entered by the user.
  - Each car must has a name, name cannot exceed 5 characters.
- Each of the n cars can either move forward or stay.
- random number between 0~9. if the number is 4 or greater-> move forward.
- When printing the progress of each car, display the car's name alongside its movement.
  (각 차량의 진행 상황을 출력할 때, 차량의 이름과 움직임을 함께 표시하세요.
  )
- After race, display winners. can be multiple winners if they reach the same final position.
  - their names should be dsiplayed and separted by commas.
- user inputs invalid -> should throw 'IllegalArgumentException' and terminate.

# list of features
- Car
  - Each car has name, current position
  - features
    - save each car's current position and name
- Game
  - Each game has each cars' dice number
  - features
    - print each game(round) result
- Games
  - Games have participants name, how many rounds.
  - features
    - input how many rounds be played
    - enter player names
- Result
  - result has winners
  - features
    - print winners
- Exception
  - IllegalArgumentException and terminate. when inputs are invalid data.

# Programming Requirements 1
- Do not use System.exit() or exitProcess() to terminate the program.
- observe kotlin coding conventions
  - https://kotlinlang.org/docs/coding-conventions.html#function-names
- The indentation depth must not exceed 2. maximum 2 level is allowed.
  - extract logic into functions
- keep function small each should do only one thing.
- use junit5 and assertj
- library
  - camp.nextstep.edu.missionutils package.
    - Randoms
      - Randoms.pickNumberInRange(0, 9)
    - Console
  - To receive user input => Console.readLine() from the package.