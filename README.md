# kotlin-racingcar-precourse





# **Car Racing Game: Feature Additions & Implementation Plan**

## **Features to Add**
1. **Accept Car Names as Comma-Separated Input**
    - Users will enter multiple car names in one input, separated by commas.
    - Validate input to ensure names do not exceed **5 characters** and contain only letters.

2. **Throw `IllegalArgumentException` for Invalid Input**
    - If a user enters an incorrect format (e.g., empty names, numbers in names, invalid rounds), the program should **terminate with an error message**.

3. **Store Car Positions Using `MutableMap<String, String>`**
    - Track each car’s movement with `"-"` symbols stored in a **mutable map**.

4. **Execute the Race for a Given Number of Rounds**
    - Each car randomly moves forward if it gets `4 or higher` from `Randoms.pickNumberInRange(0, 9)`.
    - Print **progress after each round**, displaying each car's name alongside its track history.

5. **Determine the Winner(s) Based on Maximum Progress**
    - Find the longest track (`"-"` count) among all cars.
    - If multiple cars reach the same max distance, **declare them as joint winners**.
    - Print **winner names correctly formatted** (e.g., `"Winners : pobi, jun"`).

## **Implementation Approach**
✔ Use `Console.readLine()?.split(",")?.map { it.trim() }` for handling car name input.  
✔ Ensure input validation with conditions checking **length** and **allowed characters**.  
✔ Use a `MutableMap<String, String>` to store progress dynamically.  
✔ Implement race logic using a **for-loop** instead of manual decrementing (`while`).  
✔ Ensure correct output formatting follows task specifications.

---

