# kotlin-racingcar-precourse


### Planned Features

#### Functional

- [x] Implement a console application for capturing user input 
- [x] Add validation logic for user input
- [x] Implement car movement computation for a single race round
- [x] Build a racing logic using single race implementation
- [x] Add logic for printing racing results


#### Non Functional

- [x] Add code linting
- [x] Dockerize application
- [x] Update documentation


### Assumptions

- Input car names should be unique, hence no validation/de-duplication logic is added
- Winner names are printed in the order in which they are entered in the game

### How to run

#### Running tests

- Make sure your program runs with Kotlin 1.9.24
- Run the following command to verify that all tests pass:
  - For macOS/Linux: `./gradlew clean test`
  - For Windows: `gradlew.bat clean test` or `.\gradlew.bat clean test`

#### Building docker image

- `docker build -t racing-car .`
