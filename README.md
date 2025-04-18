# Car Racing Game

## Overview

A simple command-line car racing game implemented in Kotlin.
This project is part of a Hero Tech Course Pre-course mission, designed to practice Git, Kotlin, and testing skills.

## Functional Requirements

- Users input car names separated by commas.
- Car names must not exceed 5 characters.
- The user specifies the number of rounds.
- In each round, each car may either move forward or stay still based on a random number.
- Race progress is displayed after each round.
- The winner(s) are announced at the end. Multiple winners are allowed if positions are tied.
- If invalid input is provided, the program throws an `IllegalArgumentException` and terminates.

## Feature Checklist

- [] Input validation
- [] Car entity with name and position
- [] Movement logic using randomness
- [] Round processing engine
- [] Console output per round
- [] Winner evaluation logic
- [] Unit testing with JUnit 5 and AssertJ

## Technologies

- Kotlin 1.9.24
- Gradle
- JUnit 5
- AssertJ
- `camp.nextstep.edu.missionutils` for random number generation and user input.

## How to Run

Run the main class `Application.kt` using your IDE (e.g., IntelliJ IDEA).

## How to Test

### macOS/Linux

```bash
./gradlew clean test

### Windows

```bash
gradlew.bat clean test

The output should include:

BUILD SUCCESSFUL
 

