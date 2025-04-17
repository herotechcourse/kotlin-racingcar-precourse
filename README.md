# kotlin-racingcar-precourse

### Features to implement:

- **Create function to receive and process user input**
  - **Receive user input:** use `Console.readLine()` from `camp.nextstep.edu.missionutils.Console`.
  - **Check constrains:** names comma separated, 5 chars max; rounds must be a natural number.
  - **If Invalid:** throw an _`IllegalArgumentException`_ and terminate.
- **Implement the movement function:** Use `Randoms.pickNumberInRange()` from `camp.nextstep.edu.missionutils.Randoms` to generate the random number. If `number > 4` the car moves else stand still.
- **Create function to print progress**
- **Create function to select winners:** if multiple, the names are separated by comma+space.
- **Create the logic to run the game:**
    - create winners list.
    - call the function to process input.
    - create loop to print the progress (with sleep?).
    - call function to display the winners.
    - exit.
- **Create Unit tests**