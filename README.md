# Kotlin Racing Car Game

A simple command-line car racing simulation game implemented in Kotlin.

## Features

- Users can specify car names and the number of race rounds
- Car names are entered as comma-separated values
- Input validation:
  - Car names cannot be empty
  - Car names cannot exceed 5 characters
  - Number of rounds must be positive
- Racing simulation:
  - Each car either moves forward or stays still in each round
  - A car moves forward if a randomly generated number (0-9) is 4 or greater
  - Each car's progress is displayed after every round with its name and position
- Winner determination:
  - The car(s) that moved the furthest are declared winners
  - Multiple winners are possible if they reach the same position
  - Winners are displayed with names separated by commas
- Exception handling:
  - Invalid inputs throw IllegalArgumentException with appropriate messages

## How to Run

Make sure you have Java installed, then:

```bash
# Run with Gradle
./gradlew test              # Run tests
./gradlew jar               # Build executable JAR
java -jar build/libs/kotlin-racingcar-precourse-1.0-SNAPSHOT.jar  # Run the application
```

## Example Usage

```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,woni,jun

시도할 회수는 몇회인가요?
5

실행 결과

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

## Implementation Details

- Uses the camp.nextstep.edu.missionutils package for random numbers and console input
- Follows object-oriented design principles
- Includes comprehensive error handling
- Test-driven development approach

## Development Setup

### macOS Setup

1. Install Java (JDK) using Homebrew:
   ```bash
   brew install --cask temurin
   ```

2. Verify Java installation:
   ```bash
   java -version
   # Should show: openjdk version "24.0.1" or similar
   ```

3. Configure the build to package dependencies:
   ```bash
   # Edited build.gradle.kts to include:
   jar {
       manifest {
           attributes["Main-Class"] = "racingcar.ApplicationKt"
       }
       from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
       duplicatesStrategy = DuplicatesStrategy.EXCLUDE
   }
   ```

### Key Files Modified

1. **src/main/kotlin/racingcar/Application.kt**
   - Implemented the main game logic
   - Used the required utilities: Console.readLine() and Randoms.pickNumberInRange()
   - Added validation for car names and number of rounds
   - Implemented winner detection with support for multiple winners

2. **build.gradle.kts**
   - Added configuration for creating an executable JAR
   - Set the main class to "racingcar.ApplicationKt"

### Troubleshooting

If you encounter the "No line found" error when running with Gradle, build the JAR and run it directly:
```bash
./gradlew jar
java -jar build/libs/kotlin-racingcar-precourse-1.0-SNAPSHOT.jar
```
