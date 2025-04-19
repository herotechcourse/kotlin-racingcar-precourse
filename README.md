# kotlin-racingcar-precourse

---
## Feature
  
### Input
  1. Car Names : comma-separated and each name cannot exceed 5 characters
  2. The number of rounds : number
### Process
#### Check Input
1. Check IllegalArgumentException 
    - Car names should be comma-separated
    - If the input is valid continue..
2. Make carName List
    - ex) carName : ["pobi","woni","jun"]
3. Check IllegalArgumentException
   - Car names should not exceed 5 characters
   - If it is valid, continue ..

#### Until the number of Rounds
1. Generate a randomly number between 0 and 9 
     - If this number is 4 or greater, return `MOVING_FORWARD`
     - else return `STOP`
2. Create a Map by assigning each element of the `carName List` to  a key(carName)-value(`MOVING_FORWARD` OR `STOP`)
     - return `carDir`
3. Print `Round Result`
   - If a value is "MOVING_FORWARD"  in `carDir`
     - Append `-` to roundResult[`carName`]

#### Print Winners
1. Check max-Length of value from last `Round result`
2. Check Multiple winners
   - If duplicate items share the same value
        - Print winners separated by commas.
   - else 
        - Print a winner

### Output
  1. The Progress of each car
     - car's name alongside its movement
  2. Winners
     - multiple winners : separated by commas
     - a single winner 