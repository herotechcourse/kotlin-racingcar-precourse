# kotlin-racingcar-precourse

> [!NOTE]
> - Break down large functions that handle multiple responsibilities into smaller functions that each do one thing well.
>   - List out the features before implementation and commit your work in small, feature-focused increments.
>   - **If something is not explicitly stated in the functional requirements, use your own judgment to implement it.**
> - **Before implementing any features, list the features you plan to implement in `README.md`.**

---

## List of Features

1. Take input for car names
    - [x] The user enters car names separated by commas (,).
    - [x] Each name must be at least 1 character and no more than 5 characters.
2. Take input for number of rounds
    - [x] The user enters the number of rounds.
    - [x] Must be a number greater than or equal to 1.
3. Implement logic for car to move forward
    - [x] The car decides whether to move forward based on a random value (0 to 9).
    - [x] If it is 4 or more, it moves forward.
4. Output results in each round
    - [x] For each round, output the names of all cars and their movement results.
    - [x] The movement results are expressed as `-` symbols.
5. Determine and output the winner(s)
    - [x] The car(s) that moved the most are determined as the winner.
    - [x] If there are multiple winners, output them separated by commas.
6. Handle exceptions
    - [x] If the car name is blank or more than 6 characters.
    - [x] If the number of rounds is not a number.
