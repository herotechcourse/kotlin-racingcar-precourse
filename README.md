# kotlin-racingcar-precourse 🚗

A simple racing car game built with Kotlin, as part of the Hero Tech Course pre-course assignment.
Cars move forward based on randomly generated numbers, and the final winner(s) are determined after a fixed number of rounds.

## Features
 Receive car names from user input (comma-separated)

 Validate car name rules (non-empty, max 5 characters, at least 2 cars)

 Receive number of rounds (must be a positive integer)

 Move each car independently based on random values between 0 and 9

 A car moves forward only if its random number is 4 or greater

 Display race progress in each round using '-' symbols

 Determine and display the winner(s) based on final positions

 Handle invalid input using IllegalArgumentException

 Follow Kotlin coding conventions and keep functions small and single-responsibility


## Project Structure
main() – Entry point: reads input, executes race, prints winner

readCarNames() – Gets and validates car names

readNumberOfRounds() – Gets and validates number of rounds

playRace() – Core game loop that simulates the race

printRaceStatus() – Displays current round progress

printWinners() – Determines and displays the final winner(s)


