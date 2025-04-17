# kotlin-racingcar-precourse

## Plan features

### 1. User Input
	[*] Prompt for car names (comma-separated)
	[*] Prompt for number of rounds

### 2. Validate User input
	[ ] Parse car names
		[ ] Throw `IllegalArgumentException` for invalid input
	[ ] Parse number of rounds
		[ ] Throw `IllegalArgumentException` for invalid input

### 3. Car Implementation
	[ ] Create 'car' class with:
		[ ] Name property
		[ ] Position tracking
		[ ] Movement logic

### 4. Race logic
	[ ] Initialize cars
	[ ] Run the race for specified number of rounds
	[ ] Determine winner(s) at the end of the race
		[ ] Support multiple winners

### 5. Race display
	[ ]	Display race progress after each round
		[ ] Show cars names
		[ ] Show current positions
	[ ] Display winner(s) when race end

### 6. Testing
	[ ] Input validation test
	[ ] Car class test
	[ ] Race simulation test
	[ ] Display test