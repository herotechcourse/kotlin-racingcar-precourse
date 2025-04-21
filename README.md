# kotlin-racingcar-precourse

## Features

    1. User input
        - Read participant names and number of round from standard input.
        - Error Handling
            - Throw IllegalArgumentException for:
                - name exceeds 5 characters
                - name is absent
                - duplicate car names
                - no input provided
                - negative rounds
                - round not a number    
    2. Racing logic
        - Each of the n cars can either move forward or stay still during a given number of rounds.
        - A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
        - When printing the progress of each car, display the car's name alongside its movement.
    3. Determine the winners
        - After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
        - If there are multiple winners, their names should be displayed and separated by commas.


## Example:
```
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
```
