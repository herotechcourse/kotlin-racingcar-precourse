package racingcar.gameflow

// View
import racingcar.input.InputModule
import racingcar.output.OutputModule

// Logic
import racingcar.raceexecution.generateRandomNumber
import racingcar.raceexecution.isMoveConditionMet

// Validation
import racingcar.validation.validateCarNames
import racingcar.validation.validateRounds

class Game(private val input: InputModule,
            private val output: OutputModule) {
    fun start() {
        // 1. Getting input from User and save it.
        val inputHandler = GameManager(input)   // Just holding the remote control.
        val gameConfig = inputHandler.start()   // Press the remote control.

        // 2. Validation
        validateCarNames(gameConfig.carNames)
        validateRounds(gameConfig.rounds)

        // 3. Initialize game
        val initResult = gameInit(gameConfig)
        val listCars = initResult.cars
        val nRounds = initResult.rounds

        // 4. Start game
        val generate = { generateRandomNumber() }
        val isMovable = { number: Int -> isMoveConditionMet(number) }

        println("\nRace Results")
        gameLoop(listCars, nRounds, output, generate, isMovable)
    }
}