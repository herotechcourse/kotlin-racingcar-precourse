# 🚗 Car Racing Game

A command-line racing game simulator built with Kotlin 1.9.24.  
This project demonstrates clean domain modeling, testable business logic, and adherence to Kotlin coding standards.

---

## 🏁 Overview

The racing game simulates cars moving across multiple rounds.  
Each car moves forward if a randomly generated number is **4 or greater**.  
At the end of all rounds, the car(s) that traveled the farthest distance are declared the winners.

---

## 🛠 Programming Requirements

### 1. Environment & Restrictions

- ✅ Must run on **Kotlin 1.9.24**
- ✅ **Java code is NOT allowed**
- ✅ Entry point: `main()` function in the `Application` class
- 🚫 Do NOT use `System.exit()` or `exitProcess()` to terminate the application
- 🚫 Do NOT rename/move project files, packages, or elements unless specified
- 🚫 You may **not** modify `build.gradle.kts`
- ✅ Use only the libraries provided in the base project

---

### 2. Coding Standards

- ✅ Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- ✅ Maximum indentation depth is **2 levels**
    - Example: `if` inside `while` is OK, but deeper nesting is **not allowed**
- ✅ Minimize nesting by extracting logic into functions
- ✅ Functions should be **small, cohesive**, and **single-responsibility**

---

## 🧪 Testing Guidelines

- ✅ Use **JUnit 5** for all unit and integration tests
- ✅ Use **AssertJ** for fluent assertions
- ✅ Follow the Given-When-Then pattern for clear test structure

📚 Recommended Reading:
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ Core Documentation](https://assertj.github.io/doc/)
- [AssertJ Exception Assertions](https://assertj.github.io/doc/#assertj-core-exception-assertions)
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

---

## 🚀 Run the Game

To run the application locally:

```bash
./gradlew clean run
```

# ✅ Test the Application

Run all tests using:

```bash
./gradlew clean test
```

# 📂 Project Structure
```text
root
├── Application.kt # Entry point
└── domain/
    ├── Car.kt
    ├── Cars.kt
    ├── Round.kt
    └── Rounds.kt

```