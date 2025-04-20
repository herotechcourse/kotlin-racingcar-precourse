package racingcar.gameflow

import racingcar.input.InputModule
import racingcar.validation.validateCarNames
import racingcar.validation.validateRounds

data class GameConfig(val carNames: String, val rounds: String)

class GameConfigurator (private val input: InputModule) {
    fun configure(): GameConfig {
        val carNames = input.readCarNames()
        val rounds = input.readRounds()
        validateCarNames(carNames)
        validateRounds(rounds)
        return GameConfig(carNames, rounds)
    }
}