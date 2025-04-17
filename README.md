# kotlin-racingcar-precourse
## 구현 기능 목록

*
## Functional Requirements

- Car names are entered by the user, separated by commas.
- Each car name must be 1 to 5 characters long.
- The number of rounds is entered by the user.
- In each round, a random number between 0 and 9 is generated for every car.
- If the number is 4 or higher, the car moves forward.
- Each round prints the car's name and position as dashes (`-`).
- After all rounds, the program prints the name(s) of the winner(s), separated by commas.
- If invalid input is entered, an `IllegalArgumentException` is thrown and the program terminates.

---

## Implementation Checklist

- [x] Accept comma-separated car names from user input
- [x] Validate car names are not blank
- [x] Validate car names do not exceed 5 characters
- [x] Accept number of rounds from user input
- [x] Implement Car class with name and position
- [x] Implement move() method: car moves forward when random number ≥ 4
- [x] Write unit tests for Car class
- [ ] Implement RacingGame class to manage game rounds
- [ ] Print progress of each car after each round
- [ ] Determine winner(s) after final round
- [ ] Print winner(s), separated by commas
- [ ] Throw IllegalArgumentException on invalid input

---

## 🧪 Unit Testing

- All logic in the `Car` class is tested with JUnit5 + AssertJ:
    - Car moves forward when input is ≥ 4
    - Car does not move when input is < 4
    - Car throws exception if name is longer than 5 characters
