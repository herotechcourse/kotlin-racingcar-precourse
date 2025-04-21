# kotlin-racingcar-precourse


## Features
- [x] implement Moving Strategy
- [x] implement Car entity and move functionality
- [x] implement Race game functionality
    - [x] race functions 
    - [x] winners functions 
    - [x] printProgress functions 
- [x] add InputValidator to validating Car names and Round validations
- [x] create separate class for handling the user input
- [x] Assemble all the logic together in main function

## Example
```
Enter the names of the cars (comma‑separated): 
pobi,woni,jun
How many rounds will be played?
3

Race Results
pobi : -
woni : -
jun : 

pobi : -
woni : --
jun : 

pobi : --
woni : ---
jun : -

Winners : woni
```
---

## Tech Stack

- Kotlin 1.9.24
- Gradle 8.7
- JUnit 5, AssertJ
- IntelliJ IDEA CE(recommended)

---

## How to Run Tests
```
bash
./gradlew clean test
```
All tests must pass.