# kotlin-racingcar-precourse

## Before Racing

- 1. Get names of the cars from the user
  - [x] getValidNames()
    > #### To Check
    >
    > - To get user input, use Console.readLine()   
    - [x] validateNames()
    > #### To Check
    > 
    > - Valid:
    >     - names with comma separation
    > - Invalid:
    >     - name = null
    >     - name = ,
    >     - length > 5
    >     - duplicate names
    >     - number of cars < 2   
    
- 2. Get the number of rounds from the user
    - [x] getValidRounds()
      - [x] validateRounds()
  > #### To Check
  > 
  > - Valid:
  >   - 1 <= number <= max (not specified)

- (!) If either step [i] or [ii] is invalid, the program should throw an IllegalArgumentException and terminate.

## Racing

- 3. Move each car based on a generated number
   - [ ] executeRaceRound()
     - [ ] initPosition()
     - [ ] getMoveValue()
      >  #### To Check
      >  - Return a random number between 0 and 9 by using Randoms.pickNumberInRange(0, 9)

     - [ ] moveCar()
     > #### To Check
     >  - Each car moves forward if that random number is greater than 4; otherwise, position does not change

- 4. Display the result of each round following the given format
     - [ ] displayRaceResults()
     - [ ] saveRoundWinners()


## After Racing

- 5. Display the winner(s)
  - [ ] displayWinner
    - [ ] getFinalWinner
> #### To Check
>
> - Valid:
>   - Both single or multiple winners