package racingcar

/**
 * Responsible for managing the racing game.
 *
 * @property input Handles user input.
 * @property output Displays output to the user.
 * @property validator Validates user input.
 */
class RacingGame (
    private val input: InputHandler,
    private val output: OutputHandler,
    private val validator: Validator
) {
    private lateinit var cars: Cars
    private var round: Int = 0

    /**
     * Starts the game.
     */
    fun startRace() {
        setupCars()
        setupRound()
    }

    /**
     * Initializes the cars based on user input.
     */
    private fun setupCars() {
        val carNames = input.getCarsName()
        validator.validateCarsName(carNames)
        cars = Cars(carNames.map { Car(it) })
    }

    /**
     * Sets the number of race round.
     */
    private fun setupRound() {
        val roundInput = input.getRound()
        validator.validateRound(roundInput)
        round = roundInput.toInt()
    }
}