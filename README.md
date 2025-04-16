# kotlin-racingcar-precourse

## Features

### 1. Input parsing and check valid
- Input car names (use Console API)
  - [ ] split car names by **comma**  
  - [ ] check length **over 5 characters** or **blank**
    - if over 5 characters ->  **throw IllegalArguemtException**
    - if blank ->  **throw IllegalArguemtException**
- Input number of rounds (use Console API)
  - [ ] check input type is integer and too large number
    - if is not integer -> **throw IllegalArguemtException**
    - if over 10000 -> **throw IllegalArguemtException**

### 2. Game start
- Use Randoms API to generated number **N** between 0 and 9 of each car
  - [ ] N >= 4 : move forward
  - [ ] otherwise : stay
- Display the progerss of each car
  - [ ] display progerss printing format
    - display the car's name algonside its movement
    
### 3. Game finish
- display winner
  - [ ] printing winner 
  - when multiple winners if thery reach the same final position
    - [ ] names be displayed and seperated by commas
