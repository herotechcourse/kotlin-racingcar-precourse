## Features
### Car
- A car name cannot exceed 5 characters
- A car can either move forward or stay still during a given number of rounds
- A car can move forward if a randomly generated number between 0 and 9 is 4 or greater
- Find the cars that moved the farthest

### Input/Output
- Receive car names as a comma-separated string from the user
- Receive the number of rounds from the user
    - The number of rounds must be a positive integer
- Display the progress of each car
- After the race is complete, print the winners

### Exception
- Throw an exception if a car name exceeds 5 characters
- Throw an exception if a car name is blank
- Throw an exception if the number of rounds is not a positive integer