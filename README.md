# kotlin-racingcar-precourse

## Description
The Car Racing Program is an interactive console-based application where users can simulate a car race. Users provide the names of the cars and the number of rounds for the race. The program validates the input, simulates the race, and displays the results, including the winner(s).

## Features
1. Display user input instructions and formatted race results
    - Accept user input for car names
    - Accept user input for the number of race rounds
    - Print the results of the race in a formatted way, showing the car name and its current position for each round using "-"
    - Print the winner(s) separated by commas
    - In case of invalid input throw exception and terminate the program

2. Validate car names
    - Validate that the car names are comma separated
    - Validate that car name is not bigger than 5 characters
    - Validate that there is more than 1 car name entered

3. Validate number of rounds
    - Validate that the value entered is a positive integer and doesn't equal 0

4. Simulate each round
    - For each car, generate a random number between 0 and 9
    - Move the car forward if the number is 4 or greater
    
5. Determine winners
    - If one car has the highest position, display it as the sole winner
    - If more than one car has the highest position, display multiple winners

## Install Dependencies
1. Download and install the latest JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install Kotlin:
   - **For Mac**: Run the following command in the terminal:
     ```bash
     brew install kotlin
     ```
   - **For Windows**: Download and install Kotlin from [Kotlin](https://kotlinlang.org/docs/command-line.html).


## How to Run
1. Clone the repository.
2. Navigate to the project directory.

### Build

```bash
./gradlew clean build 
```

### Run
```bash
java -cp "build/libs/kotlin-racingcar-1.0-SNAPSHOT.jar:libs/mission-utils-1.2.0.jar:libs/kotlin-stdlib-1.9.24.jar" racingcar.ApplicationKt
```

### Test
```bash
./gradlew clean test 
```

#### Jar dependecies such as ```kotlin-stdlib-1.9.24``` and ```mission-utils-1.2.0``` are shiped with this repository in ```libs/``` folder
>
> ``` ./gradlew -q dependencies --configuration runtimeClasspath```
>
> org.jetbrains.kotlin:kotlin-stdlib:1.9.24
> - Download the jar from:
> https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib/1.9.24
>
> com.github.woowacourse-projects:mission-utils:1.2.0
> - The jar can be found locally in gradle cash
> ``` ~/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.2.0/```

## Make fat jar to ship to production 

```bash
mkdir build/temp
cd build/temp
jar -xf ../../libs/mission-utils-1.2.0.jar
jar -xf ../../libs/kotlin-stdlib-1.9.24.jar
jar -xf ../../build/libs/kotlin-racingcar-1.0-SNAPSHOT.jar
jar -cfm ../../build/libs/kotlin-racingcar-1.0-SNAPSHOT-fat.jar ../../manifest.txt *
cd ../..
```

## Start the game
```bash
java -jar build/libs/kotlin-racingcar-1.0-SNAPSHOT-fat.jar
```