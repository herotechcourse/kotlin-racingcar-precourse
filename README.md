# kotlin-racingcar-precourse


## Overview

This program simulates a car race where one or more cars win the race based on their random progress. The goal is to create a simple car race simulator that allows users to:
- Select the input the names of the cars (up to 5 characters each).
- Set the number of rounds for the race.
- Simulate each round with a 60% chance of a car advancing.
- Track which car advances the most and declare one or more winners at the end of the race.

## Planned Functions and Features

### 1. **Car Creation and Setup**
   - **Goal**: Enable user input for car names and number of rounds.
   - **Function to Implement**:
     - `createCars(String carNames)`: This function will take a single string containing car names, split the names, and create `Car` objects for each name. Each `Car` object will store an integer that tracks how many times the car has advanced during the race.
   - **Reasoning**: The user will enter car names in a single string (with commas separating each name). This function will handle extracting the car names, creating `Car` objects, and storing them in an array or list. The function will also initialize each car’s progress counter to zero, allowing the program to track how many rounds each car advances.

---

## Implementation Progress

### Phase 1: **Car Creation and Setup**
   - **Goal**: Implement the function to create cars based on user input.
   - **Current Status**:
     - Car object will be created
     - The `createCars` function will be implemented.
   - **Next Step**: 

---
