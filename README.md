# kotlin-racingcar-precourse - Hero Tech Course Pre-course Week 1

This is the Week 1 mission of the Hero Tech Course Pre-course.  
You will implement a console-based racing car game where users input car names and the number of race attempts. Based on random values, each car moves forward or stays still, and the final winners are displayed.

---

## ✅ Feature Checklist

### 🚗 Input Handling
- [X] Receive car names input ('InputCarNames')
  - [X] comma-separated string (,)
- [X] Validate car names  
  - [X] Each name must be at least 1 and at most **5 characters long**  
  - [X] Names must not be empty or contain only whitespace
- [X] Receive number of attempts input
- [X] Validate number of attempts  
  - [X] Trim leading/trailing spaces before validation  
  - [X] Ensure the input is a **valid number**  
  - [X] Only **positive integers** are allowed (zero or negative numbers are invalid)

### 🕹️ Game Execution
- [X] Repeat for the number of rounds entered by the user
- [X] For each round, generate a random number (0–9) for each car
- [X] If the number is **4 or higher**, the car moves forward; otherwise, it stays still
- [X] Each move adds a `-` to represent progress

### 📣 Output
- [X] Display the progress of all cars after each round  
  - Format: `pobi : --`
- [X] Display the final winner(s) at the end  
  - Single winner: `Winners : pobi`  
  - Multiple winners: `Winners : pobi, jun`
- [X] Ensure the output format **exactly matches** the requirements

---

## 📋 Submission Requirements Checklist

- [X] Feature list written in `README.md` before implementation
- [X] Git commits are divided by individual features listed above 
- [X] Commit messages follow AngularJS Git Commit Message Conventions
- [X] `README.md` includes all features and requirements

---

## 📌 Functional Requirements Summary

| Item | Description |
|------|-------------|
| Car Names | Input as a comma-separated string (e.g., `pobi,woni,jun`) |
| Name Constraints | Each name must be **1 to 5 characters**, no empty or whitespace-only strings |
| Movement Condition | A random number between 0–9 is generated; **move forward if ≥ 4** |
| Output Format | `name : ---` using `-` to show progress |
| Winner Output | Display the car(s) with the longest distance as `Winners : pobi, jun` |
| Exception Handling | Throw `IllegalArgumentException` and terminate the program if input is invalid |

---

## 💻 Programming Requirements

| Item | Description |
| --- | --- |
| Language | Kotlin 1.9.24 |
| Entry Point | main() function in Application.kt |
| Build Tool | Gradle (do not modify build.gradle.kts) |
| External Libraries | Do not add any external libraries; use only the ones provided |
| Exit Behavior | Do not use System.exit() or exitProcess() |
| File Structure | Do not change the provided file or directory structure |
| Coding Convention | Follow the Kotlin official coding conventions** |
| Nesting Limit | Maximum nesting depth is 2 levels |
| Function Design | Follow the Single Responsibility Principle (SRP): each function should do only one thing |

---

## 📤 Sample I/O

```text
Input:
Enter the names of the cars (comma-separated):
pobi,woni,jun

How many rounds will be played?
5

Output:
Race Results
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

...

Winners : pobi, jun

```
---

## ⚠️ Allowed Libraries
✅ Generate Random Numbers
```
import camp.nextstep.edu.missionutils.Randoms

val number = Randoms.pickNumberInRange(0, 9)
```


✅ Read Console Input
```
import camp.nextstep.edu.missionutils.Console

val input = Console.readLine()
```
 
