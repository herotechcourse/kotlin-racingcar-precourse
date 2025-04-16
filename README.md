# kotlin-racingcar-precourse

## ✅ Features

- [x] Receive car names as input (comma-separated)
    - [x] Each name must be 5 characters or fewer
    - [x] Invalid input should throw an `IllegalArgumentException`
- [x] Receive number of race rounds
    - [x] Must be a positive integer
- [x] Move cars forward randomly each round
    - [x] Move if random number (0~9) is 4 or more
- [ ] Print each car’s progress each round
    - [ ] Use `-` to indicate progress
- [ ] Print winners at the end
    - [ ] Show all cars with the maximum distance
    - [ ] Join multiple names with commas

## 🧪 Testing Tools

- JUnit 5
- AssertJ

## 🛠️ Build

```bash
./gradlew clean test
```
