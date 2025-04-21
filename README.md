# kotlin-racingcar-precourse


# GameControll:
- manage input request
- initiate game
- stop game
- determine , winner output

# roundHandler:
- manage round logic
- output proges

# car class:
- id
- name : string
- position : int
- Methods for movement and position tracking
        - can move forward or stay still



1. inputs:
- Implement input for car names (comma-separated format)
- Implement input for number of racing rounds
- Validate car names (non-empty, maximum 5 characters)
- Validate number of rounds (positive integer)
- Throw IllegalArgumentException and terminate for invalid inputs

2. Game Logic:
- Implement random movement mechanism (move if random number ≥ 4)
- Track car positions for each round
- Implement race execution for specified number of rounds
- Determine winner(multiple) -> (cars with the maximum position)

3. Structure of aplication
- Create main entry point in Application class
- Implement clean separation of concerns:
  - GameController
  - RoundHandler
  - Model: Car class and related logic

4. Testing
- Write unit tests for car movement logic
- Write unit tests for winner determination
- Write unit tests for input validation
- Implement parameterized tests for edge cases



5. Output + Example:
- Display race progress after each round with visual representation (dashes)
- Format output to show car name followed by position indicators
- Display final winners (singular or multiple with comma separation)

------------------------------------------------------------------------------------------
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

Race Results
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Winners : pobi, jun
------------------------------------------------------------------------------------------