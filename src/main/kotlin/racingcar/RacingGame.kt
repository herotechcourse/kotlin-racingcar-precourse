package racingcar

class RacingGame (
    private val input: InputHandler,
    private val output: OutputHandler,
    private val validator: Validator
) {
    private lateinit var cars: Cars
    private var round: Int = 0

    fun startRace() {
        setupCars()
        setupRounds()
        playRaceRounds()
        announceWinners()
    }

    private fun setupCars() {
        val carNames = input.getCarsName()
        validator.validateCarsName(carNames)
        cars = Cars(carNames.map { Car(it) })
    }

    private fun setupRounds() {
        val roundInput = input.getRound()
        validator.validateRound(roundInput)
        round = roundInput.toInt()
    }

    private fun playRaceRounds() {
        output.printRaceHeader()
        repeat(round) {
            cars.move()
            output.printRaceProgress(cars.getAll())
        }
    }

    private fun announceWinners() {
        val winners = cars.findWinners()
        output.printWinners(winners)
    }
}