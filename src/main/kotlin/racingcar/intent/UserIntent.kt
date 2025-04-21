package racingcar.intent

sealed class UserIntent {
    data class EnterCarNames(val names: List<String>) : UserIntent()
    data class EnterRounds(val rounds: Int) : UserIntent()
    object StartGame : UserIntent()
}
