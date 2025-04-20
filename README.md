# kotlin-racingcar-precourse

## Feature List
- Car
  - [x] Car has a name that does not exceed 5 characters
  - [x] Car can move forward
  - [x] Car can stay still
- Race
  - [x] Race Round: All cars move forward
  - [x] Race Round: All cars stay still
- Race (Full Race Execution)
  - [x] Race runs for the specified number of rounds (Test runRace orchestrates rounds correctly)
- WinnerJudge (Winning Logic)
  - [x] Race identifies a single winner (Test findWinners with one car at max position)
  - [x] Race identifies multiple winners (Test findWinners with multiple cars at max position)
- Input Validation
  - [x] Race initialization throws IllegalArgumentException for invalid car names (empty, too long, invalid format like ",,")
  - [x] Race initialization throws IllegalArgumentException for invalid rounds (non-numeric, zero, negative)
