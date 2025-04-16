# kotlin-racingcar-precourse


### Functional Requirements

Input

- [] Receive car names and the number of rounds from the user
- [] Car names are comma-separated and must be 5 characters or fewer

Game Rules

- [] In each round, each car either moves forward or stays still
- [] A car moves forward if a random number between 0 and 9 is greater than or equal to 4

Output

- [] For each round, display the car's name and its progress (as a series of -)
- [] After the race, display the final winner(s)
- [] If there are multiple winners, display all names separated by commas

Exception Handling
- [] If the user input is invalid, throw an IllegalArgumentException and terminate the program
