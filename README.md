# kotlin-racingcar-precourse

A simple console-based car racing game built in Kotlin.  
The program takes car names and the number of rounds as inputs from the user, simulates the race, and displays the winner(s).

---

##  Features

- Accepts user input for:
    - Car names (comma-separated, each up to 5 characters long)
    - Number of racing rounds
- Validates user inputs:
    - Car names must be 1–5 characters long
    - Blank or empty names are not allowed
    - Leading and trailing whitespaces (if any) are removed from the names
    - The number of rounds must be a positive integer
    - On invalid input, the program throws an ‘IllegalArgumentException’ and terminates
- For each round of the race:
    - Each car generates a random number between 0 and 9
    - If the number is **4 or greater**, the car moves forward by one position
    - The car's **total progress** is displayed after each round using ‘-’ symbols
- After all rounds are complete:
    - One or more winners are declared based on the **highest final position**
    - If there are multiple winners, their names are separated by commas

---

##  Technologies

- Kotlin
- Console I/O using `camp.nextstep.edu.missionutils.Console`
- Random number generation using `camp.nextstep.edu.missionutils.Randoms`
