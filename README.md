## Car Racing Game

### 1. Design car racing with the following features:

- The user could specify car names and the number of rounds (input)
    - Car names are comma-separated
    - Each car name must have a name, and each name cannot exceed 5 characters
- Each round a cars can either move forward or stay based on a randomly generated number between 0 and 9
    - If the number is greater or equal to 4, then the car moves forwards (each movement is represented by a dash)
    - Otherwise, it stays still

### 2. Input/output requirements

- Input 
    - Name of the cars (comma-separated) and not exceed 5 characters
    - Number of rounds is a positive integer
- Output
    - Race results by round: Display the car's name alongside with its movements 
    - Messages for the winners: If there are multiple winners, their name should be displayed and separated by commas

### 3. Other requirements
- If the input data is invalid, the program should throw an IllegalArgumentException and terminate.
- ***Kotlin 1.9.24*** must be used
- Using APIs provided by the `camp.nextstep.edu.missionutils` package for `Randoms` and `Console` commands