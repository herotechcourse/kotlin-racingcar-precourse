# kotlin-racingcar-precourse
# Car Racing Game

## 🚀 Project Introduction

This is a simple console-based car racing game. The user provides the names of the cars participating and the number of rounds to race. In each round, each car randomly decides whether to move forward or stop. The game displays the progress after each round and announces the final winner(s).

This project is implemented in Kotlin and utilizes the `camp.nextstep.edu.missionutils` library for random number generation and console input handling.

## ✨ Features

Here is a list of the implemented features. It's recommended to manage each feature with a separate Git commit.

-   **[feature] Input Car Names:**
    -   Accepts car names separated by commas (`,`).
    -   Trims leading/trailing whitespace from each name.
-   **[feature] Input Number of Rounds:**
    -   Accepts the total number of rounds for the race.
-   **[feature] Validate Car Names:**
    -   Each car name must be 5 characters or less (throws `IllegalArgumentException` otherwise).
    -   Car names cannot be blank or empty (throws `IllegalArgumentException`).
    -   Car names cannot be duplicates (throws `IllegalArgumentException`).
-   **[feature] Validate Number of Rounds:**
    -   The number of rounds must be a positive integer greater than 0 (throws `IllegalArgumentException` if not a number or <= 0).
-   **[feature] Create Car Objects:**
    -   Creates `Car` objects based on the input names (name, initial position 0).
-   **[feature] Implement Car Movement Logic:**
    -   Each car generates a random number between 0 and 9.
    -   If the number is 4 or greater, the car moves forward (position increases by 1); otherwise, it stops.
-   **[feature] Output Round Results:**
    -   After each round, display the name and current position of all cars, visualized with `-` characters (e.g., `pobi : ---`).
-   **[feature] Determine Final Winner(s):**
    -   Identifies the car(s) that have moved the farthest as the winner(s).
    -   Allows for multiple winners if they tie for the maximum distance.
-   **[feature] Output Final Winner(s):**
    -   Displays the name(s) of the final winner(s).
    -   If there are multiple winners, separates their names with commas (`,`) (e.g., `Winners : pobi, jun`).
-   **[feature] Exception Handling:**
    -   If user input is invalid, throw an `IllegalArgumentException`, print an error message, and terminate the application gracefully (without using `System.exit()`).
-   **[feature] Write Test Code:**
    -   Use JUnit 5 and AssertJ to write unit and integration tests for each feature.
    -   Utilize the `mission-utils` test library to test random value generation and console I/O.

## ✅ Requirements

-   Kotlin 1.9.24
-   Gradle
-   `camp.nextstep.edu.missionutils` library (provided)

## 🛠️ How to Run

1.  **Build the Project:**
    ```
    ./gradlew build
    ```
    Or on Windows:
    ```
    gradlew.bat build
    ```
2.  **Run the Application:**
    -   Execute the `main` function in the `src/main/kotlin/racingcar/Application.kt` file directly from your IDE (like IntelliJ IDEA).
    -   Alternatively, after building, you might run the generated JAR (configuration might be needed in `build.gradle.kts` for a runnable JAR).

## 🧪 How to Test

Run all tests in the project to ensure that the functionality works correctly.

-   **macOS / Linux:**
    ```
    ./gradlew clean test
    ```
-   **Windows:**
    ```
    gradlew.bat clean test
    ```
    or
    ```
    .\gradlew.bat clean test
    ```

After running the tests, you should see the following message:

