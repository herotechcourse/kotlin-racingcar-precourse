# kotlin-racingcar-precourse

Car Racing Game_자동차 경주
---
This project implements a simple car racing game using Kotlin. 
Users enter comma-separated car names and the number of rounds, and the application simulates the race by generating random numbers to determine movement.

🚀Functional Requirements
---

| #  | Requirement                                                                                   |
|----|----------------------------------------------------------------------------------------------|
| 1  | Users specify comma-separated car names and the number of rounds.                           |
| 2  | Each car name must be non-empty and ≤ 5 characters.                                         |
| 3  | For each round, generate a random integer [0–9]; if ≥ 4, the car moves forward.              |
| 4  | Display each car’s progress using dashes (`-`) next to its name after every round.          |
| 5  | After all rounds, determine the winner(s): the car(s) with the greatest distance traveled.   |
| 6  | If multiple cars tie for first, list their names separated by commas.                        |
| 7  | On any invalid input, throw `IllegalArgumentException` and terminate immediately.            |


## 🖥️ Input/Output Requirements

### Input
- Names of the cars (comma-separated). Example:
    ```
    pobi,woni,jun
    ```
- Number of rounds. Example:
    ```
    5
    ```

### Output
- Race results by round. Example:
    ```
    pobi : --
    woni : ----
    jun : ---
    ```
- Message for a single winner. Example:
    ```
    Winners : pobi
    ```
- Message for multiple winners. Example:
    ```
    Winners : pobi, jun
    ```

### Example Execution
```text
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

Race Results
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

Winners : pobi, jun
```

---


## ✅ Implementation Checklist

| Checklist (EN / KR)                                                                                             | Done |
| ---------------------------------------------------------------------------------------------------------------- |-----|
| Specify comma-separated car names and the number of rounds<br/>쉼표로 구분된 자동차 이름과 라운드 수 입력               | [X] |
| Validate each car name is non-blank and at most 5 characters long<br/>각 자동차 이름이 공백만이 아니고 최대 5자 이하인지 검사 | [X] |
| Generate a random integer between 0 and 9 for each round<br/>매 라운드마다 0~9 사이의 랜덤 정수 생성                  | [ ] |
| Move the car forward if the generated number is 4 or greater<br/>생성된 숫자가 4 이상이면 자동차 전진                   | [ ] |
| Display each car’s progress as dashes next to its name after every round<br/>각 라운드 후 자동차 이름 옆에 대시로 진행 상태 표시 | [ ] |
| Determine the winner(s) after all rounds<br/>모든 라운드가 끝난 후 우승자 결정                                       | [ ] |
| If multiple winners, list their names separated by commas<br/>복수 우승자일 경우 이름을 쉼표로 구분하여 표시           | [ ] |
| Throw `IllegalArgumentException` and terminate on invalid input<br/>잘못된 입력 시 `IllegalArgumentException` 예외를 발생시키고 종료 | [ ] |



## ⚠️ Error Handling

- 사용자 입력이 빈 문자열이거나, 자동차 이름이 5자를 초과할 경우
- 라운드 수가 숫자가 아니거나 음수일 경우

이 경우 `IllegalArgumentException`을 던지고 즉시 프로그램을 종료합니다.
