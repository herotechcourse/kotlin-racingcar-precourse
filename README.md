# kotlin-racingcar-precourse: A Car Racing Game

## Overview
This project is a simple car racing game where the user can input car names and the number of rounds for the race.
The cars will randomly move forward or stay still during each round, and the progress will be displayed after each game round.
At the end of the race, the winners are determined based on the car's final positions, and multiple winners can be displayed if there is a tie.

## Features

 - User can input a list of car names, separated by commas(max 5 characters per car name).
 - User can specify the number of rounds for the race.
 - Each round, cars will eitther move forward or stay still, based on a random number generator.
 - The progress of each car is displayed after every round.
 - The program determines the winner(s) at the end of the race and prints their names.
 - Input validation ensures that car names and rounds are valid.
 - Invalid inputs throw `IllegalArgumentsException` to terminate game