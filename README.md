# kotlin-racingcar-precourse

## Before Racing

- 1. Get names of the cars from the user
  - Validate names
    > #### To Check
    > 
    > - Valid:
    >   - Eng/Kor/Nbr/Blank with comma separation
    > - Invalid:
    >   - name = null
    >   - name = ,
    >   - length greater than 5
    >   - duplicate names
    > - Edge cases:
    >   - number of cars = 1   
    
- 2. Get the number of rounds from the user
    - Validate the number
  > #### To Check
  > 
  > - Valid:
  >   - 1 <= number <= max (not specified)

- (!) If either step [i] or [ii] is invalid, the program should throw an IllegalArgumentException and terminate.

## Racing

- 3. Move each car based on a generated number
> #### How it works?
>  - Generate a random number between 0 and 9
>  - Each car moves forward if the number is greater than 4; otherwise, no change in the position
- 4. Display the result of each round following the given format

## After Racing

- 5. Display the winner(s)
> #### To Check
>
> - Valid:
>   - Both single or multiple winners