# kotlin-racingcar-precourse
## Planned features!

- [x] Let users input car names (comma-separated)
- [x] Validate that input isn't empty or weird ( 5 chars max per name, or empty), if it is throw an IllegalArgumentException and terminate.
- [x] Ask how many rounds to run
- [x] Validate the rounds input ensure its a number
- [x] Implement logic to randomly determine if a car moves in each round (based on a random number between 4 and 9).
- [ ] If a car moves, show it with a `-` next to its name
- [ ] Show the race progress after each round
- [ ] At the end, show the winner(s) — can be more than one


Display a - next to the name of any car that moves in a round.

Output the progress of the race after each round, showing the movement of the cars.

Determine and display the winner(s) at the end of the race — allowing for multiple winners if cars finish at the same position.
### Post testing and formatting
- [ ] Stick to the Kotlin style rules (2 levels of indent max, etc.)
- [ ] Write tests with JUnit 5 + AssertJ to check everything works

