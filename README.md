<div align = "justify">

# kotlin-racingcar-precourse

This is a simple command-line car racing game developed in Kotlin for the Hero Tech Course: Berlin Edition pre-course mission 1.
Users input car names and number of rounds, and each car moves forward based on random numbers.

<br>

---

## Features

- [x] Prompt user for car names (comma-separated)
- [x] Validate that all car names are non-empty and max 5 characters
- [x] Prompt user for number of rounds
- [x] Validate that round count is a positive number
- [x] Each round:
    - [x] Cars move forward only if random number (0–9) ≥ 4
    - [x] Display each car's progress using `-`
- [x] Determine and print final winner(s)
- [x] Handle invalid inputs with meaningful exceptions
- [ ] All test cases should be passed using `./gradlew clean test`

<br>

---

## How to run tests

For macOS/Linux:
```bash
./gradlew clean test
```

<br>

For Windows:
```bash
gradlew.bat clean test # or
.\gradlew.bat clean test
```

<br>

---

## Example Output

```
Enter car names (e.g., car1, Car2, car3):
pobi, woni, jun

How many rounds?
3

Round 1
pobi : -
woni : -
jun : -

Round 2
pobi : -
woni : -
jun : -

Round 3
pobi : --
woni : --
jun : --

Winners : pobi, woni, jun
```

<br>

---

## Project Structure

```

```

<br>

</div>