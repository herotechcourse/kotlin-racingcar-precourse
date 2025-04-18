# kotlin-racingcar-precourse

## Description
The Car Racing Program is an interactive console-based application where users can simulate a car race. Users provide the names of the cars and the number of rounds for the race. The program validates the input, simulates the race, and displays the results, including the winner(s).

## Features
1. Display user input instructions and formatted race results
    - Accept user input for car names
    - Accept user input for the number of race rounds
    - Print the results of the race in a formatted way, showing the car name and its current position for each round using "-"
    - Print the winner(s) separated by commas
    - In case of invalid input throw exception and terminate the program

2. Validate car names
    - Validate that the car names are comma separated
    - Validate that car name is not bigger than 5 characters
    - Validate that there is more than 1 car name entered

3. Validate number of rounds
    - Validate that the value entered is a positive integer and doesn't equal 0

4. Simulate each round
    - For each car, generate a random number between 0 and 9
    - Move the car forward if the number is 4 or greater
    
5. Determine winners
    - If one car has the highest position, display it as the sole winner
    - If more than one car has the highest position, display multiple winners

## Install Dependencies
1. Download and install the latest JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install Kotlin:
   - **For Mac**: Run the following command in the terminal:
     ```bash
     brew install kotlin
     ```
   - **For Windows**: Download and install Kotlin from [Kotlin](https://kotlinlang.org/docs/command-line.html).


## How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Build the application:
    ```bash
    ./gradlew clean build
     ```
4. Run the application:
    ```bash
    java -cp build/libs/kotlin-racingcar-1.0-SNAPSHOT.jar racingcar.ApplicationKt
     ```
