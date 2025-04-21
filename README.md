# kotlin-racingcar-precourse
## Feature List

1. User Input
   - Read car names (comma-separated)
   - Read the number of rounds

2. Input Validation
   - Throw `IllegalArgumentException` if car name is empty or longer than 5 characters
   - Throw `IllegalArgumentException` if the round count is not a positive integer

3. Racing Logic
   - Each round, generate a random number between 0 and 9 using `Randoms.pickNumberInRange(0, 9)`
   - If the number is ≥ 4, move the car forward by one '-'

4. Round-by-Round Output
   - After each round, print each car’s name and current progress(pobi : --).

5. Determine and Print Winner(s)
   - Find the car(s) with the maximum progress after all rounds
   - Print as `Winners : pobi, jun` (comma-separated if multiple)

6. Exception Handling
   - On invalid input, immediately throw `IllegalArgumentException` and terminate the program

---
