# kotlin-racingcar-precourse
## 구현 기능 목록
- 자동차 이름과 라운드 수를 입력받는다.
- 랜덤 값을 통해 자동차를 전진시킨다.
- 매 라운드마다 결과를 출력하고, 최종 우승자를 표시한다.

---

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
- [x] Implement RacingGame class to run each round
- [x] Loop over the number of rounds and move each car
- [x] Use Randoms.pickNumberInRange(0, 9) to generate movement number
- [x] Print each car's result after every round
- [x] Determine the car(s) with the highest position
- [x] Print winner(s) with names separated by commas
- [x] Throw IllegalArgumentException on invalid input
- [x] Add unit tests for RacingGame logic if possible

---

## Unit Testing

- All logic in the `Car` class is tested with JUnit5 + AssertJ:
    - Car moves forward when input is ≥ 4
    - Car does not move when input is < 4
    - Car throws exception if name is longer than 5 characters

## Reflection
I learned to break down requirements and manage responsibilities across layers.
Writing isolated tests and enforcing validation logic gave me a stronger understanding of domain-driven design.