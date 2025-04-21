# kotlin-racingcar-precourse
 
## Input
- names of car should be seperated with comma
- each car must have a name, and it does not exceed 5 characters.
- If user inputs invalid data, throws `IllegalArgumentException` and terminate
- name of car input 
  - when name length exceeds 5
  - when name is blank
  - when user types nothing
  
- number of rounds
  - when input is not number
  - when input is blank
  - when input is too large

## Output
- until all round is done, for each progress, print name and progress of car
- print winners
  - if there is multiple winners, print all

## Implement
- a car moves forward if randomly generated number 0 and 9 is greater than 4
  - if number is 0 ~ 4, stop.
- to distinguish if car has duplicate names, use equals method to compare

