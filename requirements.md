# Car Racing

## Process Requirements

- Start by **forking and cloning** the [Car Racing repository](https://github.com/herotechcourse/kotlin-racingcar-precourse).
- **Before implementing any features, list the features you plan to implement in `README.md`.**
- Make **Git commits based on the feature list** you wrote in the previous step.
    - Follow the [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) for commit messages.
- For detailed instructions on how to proceed, refer to the Pre-course Mission Guidelines.

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

### Input/Output Requirements

#### Input

- Names of the cars (comma-separated):

```console
pobi,woni,jun
```

- Number of rounds:

```console
5
```

#### Output

- Race results by round:

```console
pobi : --
woni : ----
jun : ---
```

- Message for a single winner:

```console
Winners : pobi
```

- Message for multiple winners:

```console
Winners : pobi, jun
```

#### Example Execution

```console
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
- You must implement the solution **only in Kotlin**—**Java code is not allowed**.
- The entry point of the application must be the `main()` function in the `Application` class.
- You may **not modify** the `build.gradle.kts` file, and you may **not use any external libraries** other than those provided.
- Do **not** use `System.exit()` or `exitProcess()` to terminate the program.
- Unless otherwise specified in the requirements, you may **not rename or move** files, packages, or other project elements.

### Programming Requirements 2

- Follow the [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html).
- The **indentation depth must not exceed 2**. A maximum of 2 levels is allowed.
    - For example, an `if` statement inside a `while` loop is acceptable, but nesting beyond that is not.
    - Tip: To reduce indentation depth, extract logic into functions.
- Keep functions as **small and focused** as possible—each should do only **one thing**.
- Use **JUnit 5** and **AssertJ** to test the functionality according to your feature list.
    - If you're not familiar with these tools, refer to the following documentation before writing your tests:
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### Library

You must use the `Randoms` and `Console` APIs provided by the `camp.nextstep.edu.missionutils` package.

- To generate random values, use `Randoms.pickNumberInRange()` from `camp.nextstep.edu.missionutils.Randoms`.
- To receive user input, use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console`.

#### Example Usage

Return a single random integer between 0 and 9 (inclusive):

```kotlin
Randoms.pickNumberInRange(0, 9)
```