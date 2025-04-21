package racingcar.model

import racingcar.intent.UserIntent
import racingcar.view.ViewRenderer
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    fun reduce(state: RacingState, intent: UserIntent): RacingState {
        return when (intent) {
            is UserIntent.EnterCarNames -> state.copy(cars = intent.names.map { Car(it) })
            is UserIntent.EnterRounds -> state.copy(totalRounds = intent.rounds)
            is UserIntent.StartGame -> playGame(state)
        }
    }

    private fun playGame(initialState: RacingState): RacingState {
        var state = initialState
        repeat(state.totalRounds) {
            println("Round ${state.currentRound + 1}")
            state = state.copy(
                cars = state.cars.map { it.move(Randoms.pickNumberInRange(0, 9)) },
                currentRound = state.currentRound + 1
            )
            ViewRenderer.render(state)
        }
        return state.copy(raceFinished = true)
    }
}
