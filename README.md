# 🏎️ Car Racing Game

This project implements a simple car racing game where cars move forward based on random values.

## 🎯 Feature List

1. Car Name Input
    - Accept comma-separated car names from the user
    - Car names must be 5 characters or less
    - No empty car names allowed

2. Round Count Input
    - Accept a positive integer for the number of rounds
    - Handle exceptions for invalid inputs

3. Car Movement Mechanism
    - Generate a random value between 0-9 in each round for each car
    - Car moves forward if the random value is 4 or greater
    - Car stays still otherwise

4. Race Result Display
    - Display the position of all cars after each round
    - Show car names along with their progress (indicated by '-' symbols)

5. Winner Announcement
    - Determine winners as the car(s) that moved the furthest
    - Display multiple winners separated by commas if applicable

6. Exception Handling
    - Throw exception if a car name exceeds 5 characters
    - Throw exception if round count is not a number or not positive
    - Throw exception if there are empty car names

## 🚀 How to Run

1. Run the application
2. Enter car names separated by commas (e.g., "pobi,woni,jun")
3. Enter the number of rounds to play
4. The application will display race results and announce winners

## 💻 Example

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