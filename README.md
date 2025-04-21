# kotlin-racingcar-precourse

A simple command-line car racing game built in Kotlin using the MissionUtils library. This game allows users to input car names and the number of rounds to simulate a fun racing experience, with randomized movement and a final winner announcement.

## Features

- Multiple car names accepted as input (comma-separated).
- Each car moves forward only if a random number between 0-9 is 4 or greater.
- The game runs for a user-defined number of rounds.
- At the end, the car(s) with the furthest distance are declared as the winner(s).

### Input validation

- Car name length (must be ≤ 5 characters)
- Duplicate names not allowed
- No blank names
-Number of rounds must be a positive integer

  
## Getting Started

### Clone the Repository

```bash
https://github.com/emily-cloud/kotlin-racingcar-precourse
cd kotlin-racingcar-precourse
