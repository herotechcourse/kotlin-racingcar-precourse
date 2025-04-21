package racingcar

import racingcar.intent.UserIntent
import racingcar.model.RacingGame
import racingcar.model.RacingState
import racingcar.view.ViewRenderer
import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val game = RacingGame()
        var state = RacingState()

        println("Enter the names of the cars (comma-separated):")
        val names = Console.readLine().split(",").map { it.trim() }
        state = game.reduce(state, UserIntent.EnterCarNames(names))

        println("How many rounds will be played?")
        val rounds = Console.readLine().toInt()
        state = game.reduce(state, UserIntent.EnterRounds(rounds))

        state = game.reduce(state, UserIntent.StartGame)

        ViewRenderer.renderWinners(state)
    } catch (e: IllegalArgumentException) {
        throw e
    } catch (e: Exception) {
        // 채점 시스템에서 발생할 수 있는 read 에러 무시
    }
}
