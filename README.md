# kotlin-racingcar-precourse

Features
Car Name Input

- Users can input multiple car names separated by commas.

- Each name must be non-empty and no longer than 5 characters.

Round Count Input

- Users specify how many rounds the race will have.

- Must be a positive integer.

Randomized Car Movement

- Each car moves forward if a random number between 0 and 9 is 4 or higher.

- Movement is evaluated in every round for each car.

Race Progress Visualization

- The position of each car is shown after each round using hyphens (-).

- Example: pobi : ---

Winner Announcement

- After all rounds, the car(s) with the farthest distance are declared the winner(s).

- If multiple cars share the farthest distance, they are listed together separated by commas.

Robust Input Validation

- Invalid car names or round numbers cause the program to throw an IllegalArgumentException and terminate gracefully.

Command-Line Interface

- Game interaction is fully text-based using the console.

