package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.intent.UserIntent
import racingcar.view.ViewRenderer

class RacingGame {
    fun reduce(state: RacingState, intent: UserIntent): RacingState {
        return when (intent) {
            is UserIntent.EnterCarNames -> {
                validateCarNames(intent.names)
                state.copy(cars = intent.names.map { Car(it) })
            }

            is UserIntent.EnterRounds -> state.copy(totalRounds = intent.rounds)

            is UserIntent.StartGame -> {
                var currentState = state
                repeat(state.totalRounds) {
                    println("Round ${currentState.currentRound + 1}")
                    currentState = currentState.copy(
                        cars = currentState.cars.map {
                            it.move(Randoms.pickNumberInRange(0, 9))
                        },
                        currentRound = currentState.currentRound + 1
                    )
                    ViewRenderer.render(currentState)
                }
                currentState.copy(raceFinished = true)
            }
        }
    }

    private fun validateCarNames(names: List<String>) {
        names.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("Car name must be 5 characters or fewer: $it")
            }
        }
    }
}
