# kotlin-racingcar-precourse

# Functional Requirements
# Implement a simple car racing game with the following rules:

The user should be able to specify car names and the number of rounds.
   Car names should be comma-separated when entered by the user.
   Each car must have a name, and names cannot exceed 5 characters.
Each of the n cars can either move forward or stay still during a given number of rounds.
A car moves forward if a randomly generated number between 0 and 9 is 4 or greater.
When printing the progress of each car, display the car's name alongside its movement.
After the race is complete, display the winners. There can be multiple winners if they reach the same final position.
If there are multiple winners, their names should be displayed and separated by commas.
If the user inputs invalid data, the program should throw an IllegalArgumentException and terminate.

---

# 🏎️ Racing Car Game – Kotlin Precourse Project

A simple console-based game where cars compete by moving forward based on random numbers.  
This project is part of a precourse test task (e.g., for Delivery Hero or bootcamps) to test the ability to structure logic, use input/output, and implement rules.

---

## 📌 Goal

Build a small program that:
- Lets users input car names and number of race rounds
- Moves each car forward in each round based on a random number
- Prints the race result after each round
- Announces the final winner(s) of the race

---

## 🧾 Input

The program asks for two inputs from the user:

1. **Car names** (comma-separated)
    - Example: `pobi,woni`

2. **Number of rounds**
    - Example: `3`

---

## 🎯 Output

- Each car's progress is printed after each round using `-` to show their position.
- At the end, the car(s) that went the farthest are printed as the **winner(s)**.

### Example Output:
```
Enter the names of the cars to race (separated by commas):
pobi,woni
How many attempts will be made?
3

Race Results
pobi : -
woni : 

pobi : --
woni : -

pobi : ---
woni : --

Winners : pobi
```

---

## ✅ Validations & Rules

| Rule | Description | Example |
|------|-------------|---------|
| ✔️ Car name must be **5 characters or fewer** | Long names are not allowed | `pobi` ✅, `javaji` ❌ |
| ❌ No empty or blank names allowed | Every car must have a name | `,pobi` ❌ |
| ✔️ Number of rounds must be a valid number | Must be a numeric value | `3` ✅, `three` ❌ |

If any rule is broken, the program should throw an `IllegalArgumentException`.

---

## ⚙️ Game Logic (Algorithm)

1. Print:  
   `"Enter the names of the cars to race (separated by commas):"`

2. Read car names, split by comma, and trim spaces.

3. Validate:
    - No name is longer than 5 characters.
    - No empty names.

4. Print:  
   `"How many attempts will be made?"`

5. Read the number of rounds.

6. For each round:
    - For each car:
        - Generate a random number between 0 and 9.
        - If the number is **4 or more**, move the car forward by 1 step.
    - Print each car's position using `-`.

7. After all rounds:
    - Find the **maximum distance moved**.
    - Find all cars that moved this far.
    - Print the winner(s):  
      `"Winners : carName1, carName2, ..."`

---

## 🛠️ Technologies Used

- Kotlin
- Console I/O (`Console.readLine()`)
- Random Number Generator (`Randoms.pickNumberInRange(0, 9)`)

---

## 📂 Folder Structure

```
racingcar/
├── ApplicationTest.kt       // Unit tests (already provided)
├── main.kt                  // Your implementation goes here
└── Car.kt                   // Optional: car model class
```

---

## ✅ How to Pass the Test Case

The test expects that:
- You correctly simulate the race.
- You handle invalid car names with an exception.
- You print the race progress and final winners as shown.

---