# 🚗 Car Racing Game (Kotlin Console App)

A command-line car racing simulation written in pure Kotlin (v1.9.24). Players input car names and a round count, and the game determines movement based on random values.

---

## ✅ Feature Checklist

### 🎯 User Input
- [ ] Input comma-separated car names.
- [ ] Validate each name (non-empty, max 5 characters).
- [ ] Input the number of rounds (positive integer).

### 🏁 Game Logic
- [ ] Random number (0–9) determines movement.
    - Move if value is **≥ 4**, else stay.
- [ ] Show car name and progress after each round using `-`.

### 🏆 Results
- [ ] After all rounds, determine winners (max distance).
- [ ] Print winner names (comma-separated if tied).

---

## 🚫 Error Handling
- Invalid car names or rounds throw `IllegalArgumentException`.
- No program exit with `exitProcess` or `System.exit()`.

---

## 🧪 Testing
- Use **JUnit 5** and **AssertJ**.
- Cover:
    - Input parsing and validation.
    - Random movement logic.
    - Progress tracking.
    - Winner determination.

---

## 📚 Libraries (Mandatory)
- `Randoms.pickNumberInRange(0, 9)` from `camp.nextstep.edu.missionutils.Randoms`
- `Console.readLine()` from `camp.nextstep.edu.missionutils.Console`

---

## ⚙ Technical Constraints
- Entry point: `main()` in `Application.kt`.
- Max indentation: 2 levels.
- Use Kotlin coding conventions.
- No file renames or `build.gradle.kts` changes.
