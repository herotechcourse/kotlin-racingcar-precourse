# kotlin-racingcar-precourse


# **0. Functional Requirements**

Implement a simple car racing game with the following rules:

- The user should be able to specify car names and the number of rounds.
    - Car names should be comma-separated when entered by the user.
    - Each car must have a name, and names cannot exceed 5 characters.
- Each of the n cars can either move forward or stay still during a given number of rounds.
- A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
- When printing the progress of each car, display the car's name alongside its movement.
- After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
    - If there are multiple winners, their names should be displayed and separated by commas.
- If the user inputs invalid data, the program should throw an `IllegalArgumentException` and terminate.



# 1. Feature List

## 1. Input

### Valid Input

- **Car Names**
    - Prompt: `"Enter the names of the cars (comma-separated):"`
    - Input must be a comma-separated list of car names.
    - Each name must be **5 characters or fewer**.
- **Number of Rounds**
    - Prompt: `"How many rounds will be played?"`
    - Input must be an **integer greater than or equal to 1**.

### Invalid Input

### Car Names

- Name exceeds 5 characters → `IllegalArgumentException`
- Name is missing (e.g., `pobi,,jun`) → `IllegalArgumentException`, program terminates
- Duplicate names → Not allowed, throws `IllegalArgumentException`
- Name contains whitespace (e.g., `" pobi "`) → `IllegalArgumentException`, program terminates
- Empty input → `IllegalArgumentException`, program terminates

### Number of Rounds

- Non-numeric input (e.g., `"one"`) → `IllegalArgumentException`, program terminates
- Decimal number (e.g., `3.5`) → `IllegalArgumentException`, program terminates
- Zero or negative number → `IllegalArgumentException`, program terminates
- Empty or whitespace-only input → `IllegalArgumentException`, program terminates

---

## 2. Output

### Race Results by Round

- After each round, display the movement of all cars.
- Format:
    
    `[Car Name] : [Hyphens representing position]`
    
    Example: `pobi : --`
    
- Cars are displayed **in the order they were input**.
- Separate each round's output with a line break.

### Final Winners

- The car(s) with the **maximum distance** are declared winners.
- If there are multiple winners, list all names separated by commas.
- Format:
    
    `Winners : pobi, jun`
    
- Insert a **blank line** before printing the final winners.
- Always use the label `Winners`, even if there is only one winner.

---

## 3. Movement

### Movement Conditions

- Each car decides whether to move once per round.
- A random number from 0 to 9 is generated.
- If the number is **4 or greater**, the car moves forward by 1.
- If the number is less than 4, the car stays in place.
- Use the provided API:
    
    `Randoms.pickNumberInRange(0, 9)` from `camp.nextstep.edu.missionutils`
    

### Repeat Logic

- For each round, apply the movement logic to **all cars**.
- The game continues for the number of rounds specified by the user.
- After each round, store and print the updated results.

---

## 4. Winners

### Winner Criteria

- Winners are the car(s) that have moved the **farthest**.
- Distance is tracked via each car’s `position` property.

### Tie Handling

- If multiple cars share the same maximum position, all are winners.
- Display their names, separated by commas:
    
    `Winners : pobi, jun`
    

### Winner Selection Logic

1. Find the maximum `position` value among all cars.
2. Filter the cars with that same position.
3. Print the names of the winning cars.