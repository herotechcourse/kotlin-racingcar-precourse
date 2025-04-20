# kotlin-racingcar-precourse| First Challenge
## Overview
This is a simple console-based Car Racing Game built with Kotlin, inspired by TDD (Test-Driven Development) principles.

## Feature Plan: 
### User Input
- [ ] Ask the player to enter car names (comma-separated, each name max 5 characters long).
- [ ] Ask the player to enter how many rounds the race should last.
- [ ] If the user types invalid input (empty name, too long, or not a number) the game should crash with an `IllegalArgumentException`.

### Car Logic
- [ ] Create a `Car` class to store:
  - the car's name
  - the car's current position.
- [ ] Add a rule:  
    Each car moves forward **if a random number between 0 and 9 is 4 or more**.
### Game Rules
- [ ] After each round, show the position of every car like this:  
   `pobi : --`  
   Each `-` means the car has moved one step.
- [ ] After all rounds are over, print the winner(s).  
   If multiple cars win, separate their names with commas.

### Development Rules
- [ ] Use Kotlin version `1.9.24`.
- [ ] Use `Randoms.pickNumberInRange()` and `Console.readLine()` for random numbers and input.
- [ ] No external libraries or modifying `build.gradle.kts`.
- [ ] Follow Kotlin Coding Conventions (small, clear functions, 2-level indent limit).
- [ ] Write small, clear commits using AngularJS commit style.

## Acknowledgments

#### This project is part of the Hero Tech Course | Pre-course 1st Challenge
---

