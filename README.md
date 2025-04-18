# kotlin-racingcar-precourse

# kotlin-racingcar-precourse

1. Car Setup

✅ Accept comma-separated car names as input
Example: pobi,woni,jun

✅ Validate car names:

Maximum 5 characters per name

No empty names

❌ Throw IllegalArgumentException for invalid input

2. Game Configuration
✅ Accept number of rounds as input

✅ Validate rounds:

Must be a positive integer

3. Game Logic
✅ Movement rules:

Each car has a 60% chance to move forward each round (random ≥4)

✅ Track positions:

Each dash (-) = 1 position

4. Output Format
✅ Input Prompts:

Names of the cars (comma-separated):
Number of rounds:
✅ Race Progress:

Race results by round:
pobi : --
woni : ----
jun : ---
✅ Winner Declaration:

Single winner: Winners : pobi

Multiple winners: Winners : pobi, jun

5. Error Handling
❌ Validate all inputs with descriptive errors:

Empty car names

Names >5 characters

Non-numeric rounds

Zero/negative rounds

6. Testing Scenarios
✅ Normal case (valid inputs)

❌ Edge cases:

Single car race

Tie for winners

Maximum name length (5 chars)