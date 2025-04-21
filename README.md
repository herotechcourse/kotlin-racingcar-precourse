# kotlin-racingcar-precourse

## Feature List
1. Car Name Input Function
   - Receive comma-separated car names
   - Car names must be 5 characters or less
   - Exception handling for empty car names
   - Exception handling for car names exceeding 5 characters
   - Exception handling for duplicate car names
   - Exception handling for invalid input format (e.g., consecutive commas)
   - Exception handling for leading/trailing spaces in car names

2. Race Round Input Function
   - Receive number of rounds
   - Exception handling for negative numbers
   - Exception handling for zero
   - Exception handling for non-numeric input
   - Exception handling for decimal numbers
   - Exception handling for empty input

3. Car Movement Function
   - Generate random number between 0 and 9
   - Move forward if number is 4 or greater
   - Stay in place if number is 3 or less
   - Track current position of each car
   - Exception handling for invalid random number generation

4. Race Progress Display Function
   - Display car positions for each round
   - Use '-' character to show movement distance
   - Display car name with position
   - Add empty line between rounds
   - Exception handling for display formatting

5. Winner Determination and Display Function
   - Select car(s) with farthest final position
   - Handle multiple winners
   - Display winner names
   - Separate multiple winners with commas
   - Exception handling for winner determination
