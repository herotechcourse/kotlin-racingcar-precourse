# kotlin-racingcar-precourse

## Feature List

- **Car Name Input**  
  - Accept car names separated by commas (`,`)  
  - Exception handling:  
    - Each name allowed up to 5 characters  
    - No input provided (at least one name required)  
    - Nothing after a comma (trailing comma or consecutive commas)  
    - Duplicate car names  
    - Special characters other than comma used  
  - On any invalid data input, throw `IllegalArgumentException` and terminate

- **Race Round Count Input**  
  - Prompt user for the number of rounds  
  - Exception handling:  
    - Input is zero or negative  
    - Non-numeric input  
    - No input provided  
  - On any invalid data input, throw `IllegalArgumentException` and terminate
  
- **Random Move Logic**  
  - For each round, generate a random number between 0 and 9; if it’s 4 or greater, move the car forward one position  
  - Use the `Randoms.pickNumberInRange(0, 9)` API  

- **Per-Round Progress Display**  
  - After each round, visualize each car’s moved distance using the `—` symbol  

- **Winner Announcement**  
  - Determine the car(s) that traveled the farthest (multiple winners possible)  
  - If there are multiple winners, print their names separated by commas  