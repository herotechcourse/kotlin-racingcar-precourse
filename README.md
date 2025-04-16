# kotlin-racingcar-precourse

# Racing Car Game - Feature List
## Input

- [ ] Enter car names
  - Input in a single line, separated by commas
  - Names must not contain spaces or be empty
  - Each name must be 5 characters or fewer

- [ ] Enter number of rounds
  - Input must be a number
  - Handle invalid (non-numeric) input


---

## Game Logic


- [ ] Round management
    - Repeat for the number of rounds entered
    - For each round, generate a random number (0–9) for each car

- [ ] Car movement
    - Numbers 0–3: Do not move
    - Numbers 4–9: Move forward by one step

---

## Output & Results


- [ ] Print round results
    - Display each car's name and progress using `-` characters

- [ ] Determine final winners
    - After the last round, determine the car(s) that moved the farthest
    - Allow for multiple winners (tie)

- [ ] Print winners
    - Single winner: print one name
    - Multiple winners: print names separated by commas