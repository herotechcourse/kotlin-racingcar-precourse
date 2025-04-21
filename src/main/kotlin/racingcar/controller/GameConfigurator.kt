package racingcar.controller

import racingcar.view.InputModule
import racingcar.service.validation.validateCarNames
import racingcar.service.validation.validateRounds

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