# kotlin-racingcar-precourse

# 🏎️ Car Racing Game
 
## 🎮 Game Rules
 
1. **Car Entry**  
   - Users input car names (comma-separated).  
   - Each name **must be non-empty** and **5 characters max**.  
   - Example: `pobi,woni,jun`
 
2. **Rounds**  
   - Users enter the number of race rounds.  
   - Each round, every car either moves forward or stays still.
 
3. **Movement Mechanics**  
   - Each car has a 60% chance to move forward per round.  
   - Random number [0-9] is generated → moves if number ≥ 4.
 
4. **Visual Progress**  
   - After each round, each car’s position is printed with hyphens:  
     ```
     pobi : --
     woni : ----
     jun  : ---
     ```
 
5. **Winning Criteria**  
   - After the final round, the car(s) with the **maximum distance** win.  
   - Ties are allowed — multiple winners are displayed comma-separated.
 
6. **Input Validation**  
   - Invalid inputs (e.g. empty names, too long, negative rounds) will result in an `IllegalArgumentException` and program termination.
 
## 🧪 Example Run
 
```
Enter the names of the cars (comma-separated):
pobi,woni,jun
 
How many rounds will be played?
5
 
Race Results
pobi : -
woni : 
jun  : -
 
pobi : --
woni : -
jun  : --
 
pobi : ---
woni : --
jun  : ---
 
pobi : ----
woni : ---
jun  : ----
 
pobi : -----
woni : ----
jun  : -----
 
Winners : pobi, jun
```
 
## ✅ Features Implemented
 
- [x] Car names and number of rounds inputs
- [x] Movement logic with random number generation
- [x] Round-by-round progress display
- [x] Multiple winner support
- [x] Exception handling for invalid input
 
