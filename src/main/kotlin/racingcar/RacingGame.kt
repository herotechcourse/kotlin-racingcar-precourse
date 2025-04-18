package racingcar

class RacingGame (
    private val input: InputHandler,
    private val validator: Validator
) {
    private lateinit var cars: Cars
    private var round: Int = 0

    /**
     * Starts the game.
     */
    fun startRace() {
        setupCars()
    }

    /**
     * Initializes the cars based on user input.
     */
    private fun setupCars() {
        val carNames = input.getCarsName()
        validator.validateCarsName(carNames)
        cars = Cars(carNames.map { Car(it) })
    }
}