# kotlin-racingcar-precourse

# Requirements
## Process Requirements
- Fork, Clone Car Racing Repository
- List the features that I plan to implement in the game
- Follow Git commit Convention 

## Functional Requirements
- Input: car names, number of rounds 
- Car name should be comma-seperated 
- Names cannot exceed 5 characters
- Car can move forward or stay during a given number of rounds
- Car move forward one step if randomly generated number is greater than or equals to 4 (0~10)
- Printing progress of each car, display car's name alongside its movement
- Display winner, manage multiple winner also
- Throw IllegalArgumentException and terminate if user inputs are invalid data


## Programming Requirements
### Programming Requirements 1
- Executable with Kotlin 1.9.24.
- Kotlin Only 
- Entry Point of Application must be the main() function
- Don't modify build.gradle.kts file
- Don't use any external libraries
- Don't use System.exit() or exit Process() 
- Don't move or rename files, packages or other project elements unless specified in requirements

### Programming Requirements 2
- Indentation depth is allowed up to a maximum of 2 levels
- Keep function as small and focused as possible
- User JUnit5 or AssertJ to test the functionality
- Use Randoms and Console APIs provided by the camp.nextstep.edu.missionutils package
- Generate random values by Randoms.pickNumberInRange()
- Receive user input by Console.readLine()


# Plan 

I'm gonna make it in MVC Strategy + Validation 

## Model
- Car(val carName: String, var progress: Int = 0)

## View 
- InputView: read user inputs 
- ResultVIew: print game results 

## Controller
- RacingController: do something logical thing 

## Validator 
- InputValidator: validate user's input 

# Specific Plans

- [ ] make Car Model
- [ ] make InputView
  - [ ] make two input functions (car name, num of rounds)
- [ ] make ResultView 
  - [ ] make three result function (Header, Rounds, Winner)
- [ ] make Validator 
  - make two validate function (car name, num of round) 
- [ ] make Controller 
  - [ ] combine input and validator
  - [ ] make run function 


_I was planning to make it in object, but I've learned that objects are difficult to test_

_So I decided to make it in class + interface way-to make test easily_
