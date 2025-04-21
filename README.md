# kotlin-racingcar-precourse

A simple car racing game implemented in Kotlin as part of hero tech course mission.

## 🧩 Features & Flow Description

### 1. Get Names
- Car names are received using `Console.readLine()` from the `camp.nextstep.edu.missionutils` package.
- Input is split by commas (`,`) and each name is trimmed.
- If any name exceeds **5 characters** or is **empty**, an `IllegalArgumentException` is thrown.

### 2. Get Rounds
- The number of rounds is received using `Console.readLine()` as well.
- The input is converted to `Int`.
- If the input is empty or not a positive integer, an `IllegalArgumentException` is thrown.

### 3. Create a List of Cars
- A `List` of car objects is created using the input names.
- Each name corresponds to a new `Car` instance.

### 4. Start the Race
- The race runs for the number of rounds specified.
- In each round, every `Car` in the list calls the `tryMove()` function and then displays its current progress using `showProgress()`.

### Car Class
- `tryMove()`:
  - Uses `Randoms.pickNumberInRange(0, 9)` from the `camp.nextstep.edu.missionutils.Randoms` package.
  - If the number is **4 or more**, the car's position is incremented by 1.
- `showProgress()`:
  - Prints the car's current position as a visual representation (e.g., using `-`).

### 5. Find the Maximum Position
- After the race, the maximum `position` among all cars is identified.

### 6. Find the Winners
- There may be multiple cars with the same highest position.
- A `filter` is applied to select all cars that have the max position.

### 7. Display the Winners
- All winners are printed, separated by commas if necessary.

## 🛠 Technologies

- Kotlin 1.9.24
- Gradle
- camp.nextstep.edu.missionutils (Console, Randoms)
