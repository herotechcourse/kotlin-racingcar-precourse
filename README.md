# kotlin-racingcar-precourse

## 📚 Overview
A simple car racing game built with **Kotlin 1.9.24**.  
Users can input car names and the number of rounds to simulate the race.  
Cars move forward based on a random number generation rule.

---

## 🛠️ Technologies Used
- **Kotlin 1.9.24** — Main programming language.
- **Gradle** — Build tool (using `build.gradle.kts`).
- **JUnit 5** — Unit testing framework.
- **AssertJ** — Fluent assertions for tests.
- **camp.nextstep.edu.missionutils**
    - `Randoms.pickNumberInRange()` — Random number generator.
    - `Console.readLine()` — User input reader.

---
## 🛠️ Usage
- [x] Input car names (comma-separated).
- [x] Validate car names (non-blank, max 5 characters).
- [x] Input number of rounds.
- [x] Move cars based on random number generation.
- [x] Display race results after each round.
- [x] Determine and display the winner(s).
- [x] Handle invalid input gracefully by throwing exceptions.

---


## 🖥️ Input/Output Example

**Input:**
```bash
Enter the names of the cars (comma-separated): pobi,woni,jun

How many rounds will be played? 5
```
### Output
```bash
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

#### Author: Dinely Shanuka