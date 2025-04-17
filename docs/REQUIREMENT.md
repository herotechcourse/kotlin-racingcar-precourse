# kotlin-racingcar-precourse

## Goals

### Learning Objectives
- Get comfortable with tools used in real-world development, such as Git, GitHub, and an IDE.
- Break down large functions that handle multiple responsibilities into smaller functions that each do one thing well.
- Learn how to use testing tools and verify that your program works correctly.

---

## Pre-course Guidelines

### How It Works
- Each mission consists of **Process Requirements**, **Functional Requirements**, and **Programming Requirements**.
- Aim to satisfy all three types of requirements. In particular, list out the features before implementation and commit your work in small, feature-focused increments.
- **If something is not explicitly stated in the functional requirements, use your own judgment to implement it.**
- New missions will be released every Tuesday at 3:00 PM (CEST / UTC+2), and must be completed and submitted by the following Monday at 11:59 PM (CEST / UTC+2).
    - **If you miss the deadline, your mission will be considered unsubmitted.**
    - No additional pushes are allowed after the submission deadline.

### How to Submit
- After completing the mission, submit your code via GitHub.
    - Refer to the [How to Proceed with the Mission](https://docs.google.com/document/d/1mpJtYaGOaLtk_K3yk3qqTowOWWqz94_fgS3UXFn-qZA/edit?tab=t.0#heading=h.j54y4c3df9nv) for instructions on how to submit through GitHub.
- Once your GitHub submission is complete, finalize your submission on the [Application Platform](https://apply.techcourse.co.kr).
    - See the [How to Submit the Mission](https://docs.google.com/document/d/1mpJtYaGOaLtk_K3yk3qqTowOWWqz94_fgS3UXFn-qZA/edit?tab=t.0#heading=h.bgvj3gfwqhxj) for more details.
    - In the submission form, feel free to share your reflections, what you learned, or areas where you invested significant time.

### Final Checklist Before Submitting
- Even if your program works, **you will receive a score of 0 if your output format does not match the functional requirements.**
- Make sure all tests pass by following the testing guide below.
- **If any test fails, your score will be 0, so be sure to verify before submitting.**

#### Test Execution Guide
- Make sure your program runs with Kotlin 1.9.24 in your IDE (e.g., IntelliJ IDEA).
- Run the following command to verify that all tests pass:
    - For macOS/Linux:
      ```bash
      ./gradlew clean test
      ```
    - For Windows:
      ```bash
      gradlew.bat clean test
      ```
      or
      ```bash
      .\gradlew.bat clean test
      ```

You should see: 
```
BUILD SUCCESSFUL in 0s
```


---

## Process Requirements

- Start by **forking and cloning** the [Car Racing repository](https://github.com/herotechcourse/kotlin-racingcar-precourse).
- **Before implementing any features, list the features you plan to implement in `README.md`.**
- Make **Git commits based on the feature list** you wrote in the previous step.
    - Follow the [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) for commit messages.
- For detailed instructions on how to proceed, refer to the Pre-course Mission Guidelines.

---

## Functional Requirements

Implement a simple car racing game with the following rules:

- The user should be able to specify car names and the number of rounds.
    - Car names should be comma-separated when entered by the user.
    - Each car must have a name, and names cannot exceed 5 characters.
- Each of the n cars can either move forward or stay still during a given number of rounds.
- A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
- When printing the progress of each car, display the car's name alongside its movement.
- After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
    - If there are multiple winners, their names should be displayed and separated by commas.
- If the user inputs invalid data, the program should throw an `IllegalArgumentException` and terminate.

---

## Input/Output Requirements

### Input

- Names of the cars (comma-separated):
```bash
pobi,woni,jun
```

- Number of rounds:
```bash
5
```


### Output

- Race results by round:
```bash
pobi : -- 
woni : ---- 
jun : ---
```


- Message for a single winner:
```bash
Winners : pobi
```


- Message for multiple winners:
```bash
Winners : pobi, jun
```


### Example Execution
```bash
Enter the names of the cars (comma-separated):
pobi,woni,jun
How many rounds will be played?
5

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


---

## Programming Requirements

### Programming Requirements 1

- The program must be executable with **Kotlin 1.9.24**.
- You must implement the solution **only in Kotlin** — **Java code is not allowed**.
- The entry point of the application must be the `main()` function in the `Application` class.
- You may **not modify** the `build.gradle.kts` file, and you may **not use any external libraries** other than those provided.
- Do **not** use `System.exit()` or `exitProcess()` to terminate the program.
- Unless otherwise specified in the requirements, you may **not rename or move** files, packages, or other project elements.

### Programming Requirements 2

- Follow the [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html).
- The **indentation depth must not exceed 2**. A maximum of 2 levels is allowed.
    - For example, an `if` statement inside a `while` loop is acceptable, but nesting beyond that is not.
    - Tip: To reduce indentation depth, extract logic into functions.
- Keep functions as **small and focused** as possible — each should do only **one thing**.
- Use **JUnit 5** and **AssertJ** to test the functionality according to your feature list.
    - If you're not familiar with these tools, refer to the following documentation before writing your tests:
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

---

## Library

You must use the `Randoms` and `Console` APIs provided by the `camp.nextstep.edu.missionutils` package.

- To generate random values, use `Randoms.pickNumberInRange()` from `camp.nextstep.edu.missionutils.Randoms`.
- To receive user input, use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console`.
    ```kotlin
    Randoms.pickNumberInRange(0, 9)
    ```


