package racingcar.gameflow

import racingcar.input.InputModule

data class GameStartResult(val carNames: String, val rounds: String)

class GameManager (private val input: InputModule) {
    fun start(): GameStartResult {
        val carNames = input.readCarNames()
        val rounds = input.readRounds()
        return GameStartResult(carNames, rounds)
    }
}