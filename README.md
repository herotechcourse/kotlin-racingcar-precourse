# kotlin-racingcar-precourse

## ✅ Features

- [ ] Receive car names as input (comma-separated)
    - [ ] Each name must be 5 characters or fewer
    - [ ] Invalid input should throw an `IllegalArgumentException`
- [ ] Receive number of race rounds
    - [ ] Must be a positive integer
- [ ] Move cars forward randomly each round
    - [ ] Move if random number (0~9) is 4 or more
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
