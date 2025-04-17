# Architecture Plan

### View
#### `view/InputView.kt`
- `enterCarNames()`: prompt the user to enter car names that separated by comma. (e.g., poni,woni,jun)
- `enterRoundCount()`: Prompt the user to enter how many rounds the race should run.
- companion object

#### `view/OutputView.kt`
-  `printRaceIntro()` : Display race start message ("Race Results")
- `printRoundResult(result: List<Car>)`: Display car progress for a round (pobi : ---)
- `printWinners(winners: List<Car>)`: Display final winner ("Winners : pobi, jun")

---

### Controller
#### `controller/RaceController.kt` : Control the entire process
- `play()`: game loop (input - validation - race execution - result printing)
- `runRace(cars: Cars, rount: Int)`: repeat race round times
- `findWinners(cars: Cars): List<Car>`: find the car with highest position

---

### Model
#### `model/Car.kt` : represent single car
- `move(random: Int)`: move forward if the number is 4 or over 4.
- `position(): Int`: Return current position
- `name(): String` : Return the car's name
- `isWinner(maxPosition: Int): Boolean`: check if the car is winner

#### `model/Cars.kt`: manages a list of Car object
- `moveAll()`: moves all cars using random number generator
- `getAll(): List<Car>`: Return current list of cars
- `findWinners(): List<Car>`: Return the car with highest position. (We have to consider the situation that winner is not only one car.)

#### `model/CarName.kt`: I want to guarantee that CarName is always validate.

---

### Exception
#### `exception/ExceptoinMessage.kt` (enum)
- EMPTY_CAR_NAME("[ERROR] Car name can't be blank.")
- INVALID_NAME_FORMAT("[ERROR] Car names must be comma-separated.")
- DUPLICATE_CAR_NAME("[ERROR] Car names must be unique.")
- TOO_LONG_CAR_NAME("[ERROR] Car name must be 5 characters or less.")
- INVALID_ROUND_COUNT("[ERROR] Round count must be numeric and positive.")