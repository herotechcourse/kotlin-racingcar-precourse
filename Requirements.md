### Input
- [ ] Get car names from user input 
  - [ ] Names are separated by commas, and input ends with Enter
  - [ ] Each name must be 5 characters or less <br>
  ⁕ Every car must have a name ⇒ the name represents the car 

- [ ] Get number of rounds 
- [ ] Must be an integer (custom)
- [ ] Must be 1 or greater (custom) – a race cannot proceed with zero rounds

- [ ] If there is any problem with input, throw an IllegalArgumentException and terminate the program

### Output
- [ ] For each car, display its movement using - based on its name (custom)
  - [ ] For each round, generate a random number between 0 and 9 
  - [ ] If the number is 4 or greater, the car moves forward by one step (represented by -)
  - [ ] Repeat the above for the given number of rounds

- [ ] Display the winner(s)
  - [ ] If multiple winners exist, print all names separated by commas
  - [ ] Follow the input order when listing multiple winners (custom)

---

### 입력
- [ ] 사용자로부터 차 이름 입력받기
  - [ ] 콤마 기준으로 구분 / 입력의 끝은 엔터
  - [ ] 이름은 <= 5글자 <br>
  ⁕ 모든 차는 이름을 가지고 있어야 함 => 이름 = 차

- [ ] round 수 입력 받기
  - [ ] 정수여야 함 (custom)
  - [ ] 1이상이어야 함 (custom) => 그래야 경기 진행이 되기 때문

- [ ] 입력이 문제가 있을 경우 IllegalArgumentException를 던지고 프로그램 종료

### 출력
  - [ ] 입력된 차의 이름에 따라 (custom) 차의 이동 정도를 '-'를 이용해 나타냄
    - [ ] 입력은 0 - 9 사이의 수를 랜덤으로 뽑아 해당 수가 4 이상일 때 해당 라운드에서 한 칸(-) 이동
    - [ ] 라운드 수만큼 해당 행동을 반복함

  - [ ] 우승자 출력 (공동 우승 시 ',' 기준으로 나누어 출력)
  - [ ] 사용자가 입력한 순서에 따라 이름 출력 (custom)

개인적으로 추가되어야 할 부분이라고 상정된 요구사항들은 (custom)라고 추가 표시해둠