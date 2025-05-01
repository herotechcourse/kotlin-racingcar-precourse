# kotlin-racingcar-precourse

## 기능

- 자동차의 이름을 입력받는다.
- 자동차의 이름은 여러 개일 경우 쉼표로 구분되며, 각각의 이름은 5자를 초과할 수 없다.
- 경주를 시도할 횟수를 입력받는다.
- 주어진 횟수동안 모든 자동차는 조건이 맞을 때 전진할 수 있다.
- 각각의 자동차는 0에서 9 사이의 무작위 값을 구한 후, 무작위 값이 4 이상일 때 전진한다.
- 경주 도중에 진행 상황을 출력한다.
- 경주가 완료된 후 우승한 자동차의 이름을 알려 준다. 우승자는 반드시 한 명 이상이다.
- 우승자가 여러 명일 경우 쉼표로 구분하여 출력한다.
- 사용자가 잘못된 값을 입력받을 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션이 종료되어야 한다.

## 폴더 구조

- `src/main/kotlin/racingcar/Application.kt`
- `src/main/kotlin/racingcar/RaceGame.kt`
- `src/main/kotlin/racingcar/RacingCar.kt`
- `src/main/kotlin/racingcar/Drivable.kt`

- `src/test/kotlin/racingcar/ApplicationTest.kt`

## 입출력 요구 사항

### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

### 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
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

최종 우승자 : pobi, jun
```

---