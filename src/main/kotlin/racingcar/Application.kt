package racingcar

import racingcar.intent.UserIntent
import racingcar.model.RacingGame
import racingcar.model.RacingState
import racingcar.view.ViewRenderer

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val game = RacingGame()
            var state = RacingState()

            println("Enter the names of the cars (comma-separated):")
            val names = readln().split(",").map { it.trim() }
            state = game.reduce(state, UserIntent.EnterCarNames(names))

            println("How many rounds will be played?")
            val rounds = readln().toInt()
            state = game.reduce(state, UserIntent.EnterRounds(rounds))

            state = game.reduce(state, UserIntent.StartGame)

            ViewRenderer.renderWinners(state)
        } catch (e: Exception) {
        }
    }
}
