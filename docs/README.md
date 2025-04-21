# Racing Car (kotlin)
## Functional Requirements
### Input
- car names: comma-separated (,)
    - must be non-empty
    - must be ≤ 5 characters
- number of rounds → integer
- invalid input → `IllegalArgumentException`, terminate

### Rules
- car action: move forward OR stay
    - random number: 0 ~ 9
    - number ≥ 4 → move forward
- one round → apply action to all cars

### Progress
- display format: `carName : ---`

### Output
- winner(s): car(s) with the farthest position
- multiple winners: comma-separated (,)
