# kotlin-racingcar-precourse

## Planned Features

- [x] Get car names (separated by commas) and the number of rounds from the user
- [x] Validate car name input
    - Car name must NOT be empty
    - Each name must NOT exceed **5** characters
    - If the input is invalid, throw an IllegalArgumentException and terminate
- [x] Run the race for the number of rounds
- [x] Move each car per round based on a random value
    - A car moves forward if a randomly generated number between 0 and 9 is **4 or greater**
- [x] Print the race progress each round (car name & moves shown as '-')
- [x] Display the winner(s) after the race ends
    - For the multiple winners, separate their names with commas
