package racingcar

fun main() {
    val carNames: List<String> = InputManager.carNames()
    val gameRound: Int = InputManager.rounds()

    val game = RacingGame()
    game.joinGame(carNames, gameRound)
    game.start()
    game.whoIsWinner()
}
