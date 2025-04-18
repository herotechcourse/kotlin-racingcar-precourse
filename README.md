# kotlin-racingcar-precourse
## Feature List 
I follow a feature-driven approach. Each item below will be implemented and committed separately

### Phase 1 - Basic Working Game
Build a functional skeleton before adding full validation and testing.
- [ ] Input: Read comma-separated car names and number of rounds from the user
- [ ] Movement Logic: Random number between 0–9 determines car movement (4+ moves)
- [ ] Progress Display: Show each car's movement ("-") per round
- [ ] Winner Calculation: Determine winner(s) by max distance moved

### Phase 2 - Enhancement & Cleanup
Refine the initial version to meet all functional and programming requirements.
- [ ] Dynamic Car Handling: Support n cars, not hardcoded
- [ ] Name Validation: Ensure all car names are ≤ 5 characters
- [ ] Error Handling: Throw IllegalArgumentException for invalid inputs
- [ ] Test Coverage: Add JUnit 5 + AssertJ tests for:
* Input parsing
* Car movement logic
* Winner selection
- [ ] Code Cleanup: Break down main logic into small, focused functions
