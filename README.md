# Kotlin Racing Car Precourse
## Feature List
- Input Handling
  - Read comma‑separated car names and rounds
  - Ensure each car name is non‑empty and ≤ 5 characters
  - Ensure rounds is a positive integer
  - On any invalid input, throw IllegalArgumentException and terminate
- Movement Logic 
  - For each round, generate Randoms.pickNumberInRange(0,9) per car 
  - Move car forward if value ≥4
- Race Simulation
  - After each round, print each car’s name followed by a number of “–” equal to its position 
  - After all rounds, determine the car(s) at max position 
- Winner Announcement 
  - If one winner: Winners : name 
  - If multiple winners: Winners : name1, name2, … 